package it.vkod.woo.product.client.views.mobile;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import it.vkod.woo.product.client.clients.WooBasketServiceClient;
import it.vkod.woo.product.client.clients.WooOrderServiceClient;
import it.vkod.woo.product.client.pojo.basket.req.BasketBilling;
import it.vkod.woo.product.client.pojo.basket.req.BasketProduct;
import it.vkod.woo.product.client.pojo.basket.req.BasketShipping;
import it.vkod.woo.product.client.pojo.order.req.*;
import it.vkod.woo.product.client.pojo.order.res.OrderResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static it.vkod.woo.product.client.views.mobile.PaymentView.ROUTE;

@Slf4j
@UIScope
@Route(value = ROUTE, layout = MasterView.class)
@SpringComponent
@CssImport("./styles/materialize.min.css")
@CssImport("./styles/custom-card.css")
public class PaymentView extends Div {

    @Autowired
    private WooBasketServiceClient basketServiceClient;

    @Autowired
    private WooOrderServiceClient orderServiceClient;

    private static final String TOKEN_COOKIE = "token";
    public final static String ROUTE = "payment";
    private final String BG_COLOR = "#3333FF";
    private final String TEXT_COLOR = "white";
    private final String BUTTON_HEIGHT = "38px";
    private final String ICON_SIZE = "28px";

    @PostConstruct
    public void init() {
        if (getTokenCookie() == null)
            UI.getCurrent().navigate("");

        setClassName("container-fluid");

        ProgressBar progressBar = new ProgressBar(0, 100, 100);
        add(progressBar);

        getBasketByUserId();
    }

    private void getBasketByUserId() {
        final Map<Long, List<BasketProduct>> groupedBaskets = Arrays
                .stream(basketServiceClient.apiGetBasketProducts(getTokenCookie().getValue()))
                .collect(Collectors.groupingBy(BasketProduct::getStoreId));
        groupedBaskets.forEach((storeId, baskets) -> add(createBasketInfoDiv(storeId, baskets)));
    }

    private Div createBasketInfoDiv(final long storeId, List<BasketProduct> basketProducts) {

        Div basketInfoDiv = new Div();
        basketInfoDiv.setClassName("card");
        AtomicReference<Double> subTotal = new AtomicReference<>((double) 0);

        basketProducts.forEach(basketProduct -> {
            final double price = basketProduct.getPrice() * basketProduct.getQuantity();
            subTotal.updateAndGet(v -> v + price);
        });

        Grid<BasketProduct> grid = new Grid<>();
        grid.setItems(basketProducts);
        grid.addColumn(BasketProduct::getName).setHeader("Product").setWidth("180px");
        grid.addColumn(BasketProduct::getQuantity).setHeader("Quantity").setAutoWidth(true).setTextAlign(ColumnTextAlign.END);
        grid.addColumn(BasketProduct::getPrice).setHeader("Price").setAutoWidth(true).setTextAlign(ColumnTextAlign.END);
        grid.addColumn(basketProduct -> new DecimalFormat("##.##").format(basketProduct.getPrice() * basketProduct.getQuantity()) + "€").setHeader("Subtotal").setAutoWidth(true).setTextAlign(ColumnTextAlign.END);
        grid.recalculateColumnWidths();
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS, GridVariant.LUMO_ROW_STRIPES);

        final Icon confirmPaymentMethodButtonIcon = VaadinIcon.CREDIT_CARD.create();
        confirmPaymentMethodButtonIcon.setSize(ICON_SIZE);
        Button confirmPaymentMethodButton = new Button("Confirm Delivery with " + subTotal + "€", confirmPaymentMethodButtonIcon);
        confirmPaymentMethodButton.getStyle()
                .set("background", BG_COLOR)
                .set("color", TEXT_COLOR)
                .set("height", BUTTON_HEIGHT)
                .set("width", "90%");
        confirmPaymentMethodButton.addClickListener(addClick -> {
            final OrderResponse orderResponse = createOrderRequestWithOrderApi(storeId, basketProducts);
            log.info(orderResponse.toString());
            confirmPaymentMethodButton.setEnabled(false);
            //            basketServiceClient.apiClearBasketProducts(getTokenCookie().getValue());
        });

        RadioButtonGroup<String> paymentMethodRadioGroup = new RadioButtonGroup<>();
        paymentMethodRadioGroup.setLabel("Payment Method");
        paymentMethodRadioGroup.setItems("Cash on delivery", "Cart on delivery", "PayPal Online");
        paymentMethodRadioGroup.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
        paymentMethodRadioGroup.setValue("Cash on delivery");

        basketInfoDiv.add(grid, paymentMethodRadioGroup, confirmPaymentMethodButton);
        return basketInfoDiv;
    }

    private OrderResponse createOrderRequestWithOrderApi(final long storeId, List<BasketProduct> basketProducts) {

        BasketShipping shipping = basketServiceClient.apiGetBasketShipping(getTokenCookie().getValue())[0];
        BasketBilling billing = basketServiceClient.apiGetBasketBilling(getTokenCookie().getValue())[0];

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
        new Notification("Your order is " + orderResponse.getId() + "  created!", 4000).open();

        return orderResponse;
    }

    private Cookie getTokenCookie() {
        Cookie[] cookies = VaadinService.getCurrentRequest().getCookies();
        return Arrays.stream(cookies).filter(cookie -> TOKEN_COOKIE.equals(cookie.getName())).findFirst().orElse(null);
    }

}