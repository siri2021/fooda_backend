package it.vkod.woo.product.client.views;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import it.vkod.woo.product.client.clients.WooBasketServiceClient;
import it.vkod.woo.product.client.clients.WooOrderServiceClient;
import it.vkod.woo.product.client.components.PaymentCard;
import it.vkod.woo.product.client.pojo.basket.req.BasketBilling;
import it.vkod.woo.product.client.pojo.basket.req.BasketOrder;
import it.vkod.woo.product.client.pojo.basket.req.BasketProduct;
import it.vkod.woo.product.client.pojo.basket.req.BasketShipping;
import it.vkod.woo.product.client.pojo.order.req.*;
import it.vkod.woo.product.client.pojo.order.res.OrderResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Slf4j
@Route(value = "payment", layout = MainAppLayout.class)
@StyleSheet("https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css")
public class PaymentLayout extends AbstractView {

    private final transient WooBasketServiceClient basketServiceClient;
    private final transient WooOrderServiceClient orderServiceClient;

    private final String sessionId = VaadinSession.getCurrent().getSession().getId();

    private final MainAppLayout appLayout;
    private final VerticalLayout layoutContent = new VerticalLayout();

    public PaymentLayout(WooBasketServiceClient basketServiceClient, WooOrderServiceClient orderServiceClient, MainAppLayout appLayout) {
        this.basketServiceClient = basketServiceClient;
        this.orderServiceClient = orderServiceClient;
        this.appLayout = appLayout;

        Notification.show("Your session ID is " + sessionId, 2000, Notification.Position.BOTTOM_CENTER).open();

        getBasketByUserId();

        add(layoutContent);

        setMargin(false);
        setPadding(false);
        setSpacing(false);
        setAlignItems(Alignment.STRETCH);
        setFlexGrow(0.50, layoutContent);
        setSizeFull();
    }

    private void getBasketByUserId() {

        final Map<Long, List<BasketProduct>> groupedBaskets = Arrays
                .stream(basketServiceClient.apiGetBasketProducts(sessionId))
                .collect(Collectors.groupingBy(BasketProduct::getStoreId));
        groupedBaskets.forEach((storeId, basketProducts) -> layoutContent.add(createBasketInfoDivs(storeId, basketProducts)));
    }

    @SneakyThrows
    private Div createBasketInfoDivs(final long storeId, final List<BasketProduct> basketProducts) {

        AtomicReference<Double> subTotal = new AtomicReference<>((double) 0);
        basketProducts.forEach(basketProduct -> {
            final double price = basketProduct.getPrice() * basketProduct.getQuantity();
            subTotal.updateAndGet(v -> v + price);
        });
//
//        VerticalLayout orderInfo = new VerticalLayout();
//
//        final Grid<BasketProduct> grid = new Grid<>();
//        grid.setSelectionMode(Grid.SelectionMode.NONE);
//        grid.setItems(basketProducts);
//        grid.addColumn(BasketProduct::getName).setHeader("Product").setAutoWidth(true);
//        grid.addColumn(BasketProduct::getQuantity).setHeader("Qty").setAutoWidth(true);
//        grid.addColumn(b -> new DecimalFormat("##.##").format(b.getPrice() * b.getQuantity()) + "€").setHeader("Subtotal").setAutoWidth(true);
//        grid.setWidthFull();
//        grid.recalculateColumnWidths();
//
//        Image logo = new Image("https://www.codespromo.be/wp-content/uploads/2017/02/Pizzahut.jpg", "logo");
//        logo.setMaxWidth("150px");
//
//        ComboBox<String> payment = new ComboBox<>();
//        payment.setItems("Cash on Delivery", "Credit Card on delivery", "Bancontact", "PayPal");
//        payment.setLabel("Payment Method");
//        payment.setWidthFull();
//        payment.addValueChangeListener(valueChanged -> paymentMethod = valueChanged.getValue());
//
//        final Icon icon = VaadinIcon.CREDIT_CARD.create();
//        icon.setSize("28px");
//        Button button = new Button("Confirm order with " + new DecimalFormat("##.##").format(subTotal.get().doubleValue()) + "€", icon);
//        button.setWidthFull();
//        button.addClickListener(orderEvent(storeId, basketProducts));
//        orderInfo.add(logo, grid, payment, button);


        PaymentCard card = new PaymentCard(
                "https://www.codespromo.be/wp-content/uploads/2017/02/Pizzahut.jpg",
                subTotal.get().doubleValue(),
                basketProducts,
                Arrays.asList("Product", "Quantity", "Subtotal"),
                orderEvent(storeId, basketProducts)
        );

        return card;
    }

    private ComponentEventListener<ClickEvent<Button>> orderEvent(long storeId, List<BasketProduct> basketProducts) {
        return addClick -> {
            final OrderResponse orderResponse = createOrderRequestWithOrderApi(storeId, basketProducts);
            log.info(orderResponse.toString());
            // basketServiceClient.apiClearBasketProducts(sessionId);
        };
    }

    @SneakyThrows
    private OrderResponse createOrderRequestWithOrderApi(final long storeId, List<BasketProduct> basketProducts) {

        BasketShipping delivery = basketServiceClient.apiGetBasketShipping(sessionId)[0];
        BasketBilling billing = basketServiceClient.apiGetBasketBilling(sessionId)[0];

        List<OrderRequestLineItemsItem> products = new ArrayList<>();
        basketProducts.forEach(basketProduct -> products.add(
                OrderRequestLineItemsItem.builder()
                        .product_id((int) basketProduct.getProductId())
                        .quantity(basketProduct.getQuantity()).build()));

        String paymentMethod = "Cash on delivery";
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
                        .first_name(delivery.getFirstName())
                        .last_name(delivery.getLastName())
                        .address_1(delivery.getAddress())
                        .address_2(" ")
                        .postcode(delivery.getPostcode())
                        .city(delivery.getMunicipality())
                        .state(billing.getMunicipality())
                        .country("Belgium")
                        .build())
                .line_items(products)
                .payment_method("cod")
                .payment_method_title(paymentMethod)
                .set_paid(false)
                .build();

        final OrderResponse orderResponse = orderServiceClient.apiAddOrderWithResponse(orderRequest, storeId);

        basketServiceClient.apiAddBasketOrder(BasketOrder.builder()
                .orderId(orderResponse.getId())
                .storeId(storeId)
                .userId(sessionId)
                .build()
        );

        new Notification("Your order " + orderResponse.getId() + " is created!", 3000).open();
        appLayout.getBadge().setCount(appLayout.getBadge().getCount() - basketProducts.size());

        return orderResponse;
    }

    @Override
    String getViewName() {
        return getClass().getName();
    }
}