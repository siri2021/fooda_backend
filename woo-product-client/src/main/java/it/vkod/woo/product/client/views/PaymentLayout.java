package it.vkod.woo.product.client.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import it.vkod.woo.product.client.clients.WooBasketServiceClient;
import it.vkod.woo.product.client.clients.WooOrderServiceClient;
import it.vkod.woo.product.client.pojo.basket.req.BasketBilling;
import it.vkod.woo.product.client.pojo.basket.req.BasketProduct;
import it.vkod.woo.product.client.pojo.basket.req.BasketShipping;
import it.vkod.woo.product.client.pojo.order.req.*;
import it.vkod.woo.product.client.pojo.order.res.OrderResponse;
import lombok.extern.slf4j.Slf4j;

import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Slf4j
@Route(value = "payment", layout = MainAppLayout.class)
@StyleSheet("https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css")
public class PaymentLayout extends AbstractView {

    private final transient WooBasketServiceClient basketServiceClient;
    private final transient WooOrderServiceClient orderServiceClient;

    private final MainAppLayout appLayout;
    private final VerticalLayout layoutContent = new VerticalLayout();

    private final String sessionId = VaadinSession.getCurrent().getSession().getId();

    public PaymentLayout(WooBasketServiceClient basketServiceClient, WooOrderServiceClient orderServiceClient, MainAppLayout appLayout) {
        this.basketServiceClient = basketServiceClient;
        this.orderServiceClient = orderServiceClient;
        this.appLayout = appLayout;
        getBasketByUserId();
    }

    private void getBasketByUserId() {
        final Map<Long, List<BasketProduct>> groupedBaskets = Arrays
                .stream(basketServiceClient.apiGetBasketProducts(sessionId))
                .collect(Collectors.groupingBy(BasketProduct::getStoreId));
        groupedBaskets.forEach(this::createBasketInfoDiv);
        add(layoutContent);
    }

    private void createBasketInfoDiv(final long storeId, List<BasketProduct> basketProducts) {

        Div row = new Div();
        row.setClassName("row");

        Div col = new Div();
        col.setClassName("col s12 m6");

        Div card = new Div();
        card.setClassName("card");

        Div cardContent = new Div();
        cardContent.setClassName("card-content");
        Span title = new Span("Billing Address");
        title.setClassName("card-title");
        cardContent.add(title);

        AtomicReference<Double> subTotal = new AtomicReference<>((double) 0);

        basketProducts.forEach(basketProduct -> {
            final double price = basketProduct.getPrice() * basketProduct.getQuantity();
            subTotal.updateAndGet(v -> v + price);
        });

        Grid<BasketProduct> grid = new Grid<>();
        grid.setItems(basketProducts);
        grid.addColumn(BasketProduct::getName).setHeader("Product");
        grid.addColumn(BasketProduct::getQuantity).setHeader("Quantity").setAutoWidth(true).setTextAlign(ColumnTextAlign.END);
        grid.addColumn(basketProduct -> new DecimalFormat("##.##").format(basketProduct.getPrice()) + "€").setHeader("Price").setAutoWidth(true).setTextAlign(ColumnTextAlign.END);
        grid.addColumn(basketProduct -> new DecimalFormat("##.##").format(basketProduct.getPrice() * basketProduct.getQuantity()) + "€").setHeader("Subtotal").setAutoWidth(true).setTextAlign(ColumnTextAlign.END);
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS, GridVariant.LUMO_ROW_STRIPES);
        grid.getStyle().set("margin-left", "0").set("margin-right", "0");
        grid.recalculateColumnWidths();
        grid.setWidthFull();

        final Icon icon = VaadinIcon.CREDIT_CARD.create();
        icon.setSize("28px");
        Button button = new Button("Confirm order with " + new DecimalFormat("##.##").format(subTotal.get().doubleValue()) + "€", icon);
        button.addClickListener(addClick -> {
            final OrderResponse orderResponse = createOrderRequestWithOrderApi(storeId, basketProducts);
            log.info(orderResponse.toString());
            button.setEnabled(false);
            //            basketServiceClient.apiClearBasketProducts(sessionId);
        });

        RadioButtonGroup<String> payment = new RadioButtonGroup<>();
        payment.setLabel("Payment Method");
        payment.setItems("Cash", "Credit Card", "PayPal");
        payment.addThemeVariants(RadioGroupVariant.MATERIAL_VERTICAL);
        payment.setValue("Cash");

        cardContent.add(grid, payment);

        Div cardActions = new Div();
        cardActions.setClassName("card-actions");
        cardActions.add(button);

        card.add(cardContent, cardActions);

        layoutContent.add(card);
    }

    private OrderResponse createOrderRequestWithOrderApi(final long storeId, List<BasketProduct> basketProducts) {

        BasketShipping shipping = basketServiceClient.apiGetBasketShipping(sessionId)[0];
        BasketBilling billing = basketServiceClient.apiGetBasketBilling(sessionId)[0];

        List<OrderRequestLineItemsItem> products = new ArrayList<>();
        basketProducts.forEach(basketProduct -> {
            products.add(
                    OrderRequestLineItemsItem.builder()
                            .product_id((int) basketProduct.getProductId())
                            .quantity(basketProduct.getQuantity()).build());
        });

        OrderRequest orderRequest = OrderRequest.builder()
                .shipping_lines(Collections.singletonList(OrderRequestShippingLinesItem.builder()
                        .method_id("free_shipping")
                        .method_title("Free Shipping")
                        .total("0")
                        .build()))
                .billing(OrderRequestBilling.builder()
                        .first_name(billing.getFirstName())
                        .last_name(billing.getLastName())
                        .email(billing.getEmail())
                        .phone(billing.getPhone())
                        .address_1(billing.getAddress())
                        .address_2(" ")
                        .postcode(billing.getPostcode())
                        .city(billing.getMunicipality())
                        .state(billing.getMunicipality())
                        .country("Belgium")
                        .build())
                .shipping(OrderRequestShipping.builder()
                        .first_name(shipping.getFirstName())
                        .last_name(shipping.getLastName())
                        .address_1(shipping.getAddress())
                        .address_2(" ")
                        .postcode(shipping.getPostcode())
                        .city(shipping.getMunicipality())
                        .state(billing.getMunicipality())
                        .country("Belgium")
                        .build())
                .line_items(products)
                .payment_method("cod")
                .payment_method_title("Cash on delivery")
                .set_paid(false)
                .build();

        final OrderResponse orderResponse = orderServiceClient.apiAddOrderWithResponse(orderRequest, storeId);
        new Notification("Your order is created!", 3000).open();

        return orderResponse;
    }

    @Override
    String getViewName() {
        return getClass().getName();
    }
}