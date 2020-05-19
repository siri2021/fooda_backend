package it.vkod.woo.product.client.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import it.vkod.woo.product.client.payloads.basket.request.BasketBilling;
import it.vkod.woo.product.client.payloads.basket.request.BasketProduct;
import it.vkod.woo.product.client.payloads.basket.request.BasketShipping;
import it.vkod.woo.product.client.payloads.order.request.OrderBilling;
import it.vkod.woo.product.client.payloads.order.request.OrderLineItemsItem;
import it.vkod.woo.product.client.payloads.order.request.OrderRequest;
import it.vkod.woo.product.client.payloads.order.request.OrderShipping;
import it.vkod.woo.product.client.services.WooBasketServiceClient;
import it.vkod.woo.product.client.services.WooOrderServiceClient;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static it.vkod.woo.product.client.views.PaymentView.ROUTE;

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
    private final String BG_COLOR = "#FF5733";
    private final String TEXT_COLOR = "white";
    private final String BUTTON_HEIGHT = "38px";
    private final String ICON_SIZE = "28px";

    @PostConstruct
    public void init() {
        setClassName("container-fluid");
        getBasketByUserId();
    }

    private void getBasketByUserId() {

        final Map<Long, List<BasketProduct>> groupedBaskets = Arrays
                .stream(basketServiceClient.apiGetBasketProducts(getTokenCookie().getValue()))
                .collect(Collectors.groupingBy(BasketProduct::getStoreId));

        groupedBaskets.forEach((storeId, baskets) -> {
            Div productCard = new Div();
            productCard.setClassName("card horizontal");
            final Div basketInfoDiv = createBasketInfoDiv(storeId, baskets);
            productCard.add(basketInfoDiv);
            add(productCard);
        });
    }

    private Div createBasketInfoDiv(final long storeId, List<BasketProduct> basketProducts) {

        Div basketInfoDiv = new Div();
        basketInfoDiv.setClassName("card-stacked");
        AtomicReference<Double> subTotal = new AtomicReference<>((double) 0);

        basketProducts.forEach(basketProduct -> {
            Div basketContentDiv = new Div();
            basketContentDiv.setClassName("card-content");
            Header cartInfoHeader = new Header();
            cartInfoHeader.getStyle().set("font-size", "12pt");
            cartInfoHeader.setText(basketProduct.getName() + " x " + basketProduct.getQuantity());
            Label priceLabel = new Label();
            priceLabel.getStyle().set("font-size", "12pt");
            final double price = basketProduct.getPrice() * basketProduct.getQuantity();
            priceLabel.setText("€" + price);
            subTotal.updateAndGet(v -> v + price);
            basketContentDiv.add(cartInfoHeader, priceLabel);
            basketInfoDiv.add(basketContentDiv);
        });

        final Icon confirmPaymentMethodButtonIcon = VaadinIcon.CREDIT_CARD.create();
        confirmPaymentMethodButtonIcon.setSize(ICON_SIZE);
        Button confirmPaymentMethodButton = new Button("Confirm Delivery with €" + subTotal, confirmPaymentMethodButtonIcon);
        confirmPaymentMethodButton.getStyle().set("background", "#2E8B57").set("color", TEXT_COLOR).set("height", BUTTON_HEIGHT).set("width", "90%");
        confirmPaymentMethodButton.addClickListener(addClick -> {
            createOrderRequestWithOrderApi(storeId, basketProducts);
            new Notification("BasketPayment Method is confirmed!", 2000).open();
        });
        confirmPaymentMethodButton.setVisible(false);

        Div basketActionsDiv = new Div();
        basketActionsDiv.setClassName("card-action");
        final Icon cashOnDeliveryButtonIcon = VaadinIcon.CASH.create();
        cashOnDeliveryButtonIcon.setSize(ICON_SIZE);
        Button cashOnDeliveryButton = new Button("Cash", cashOnDeliveryButtonIcon);
        cashOnDeliveryButton.getStyle().set("background", BG_COLOR).set("color", TEXT_COLOR).set("height", BUTTON_HEIGHT).set("width", "42%");
        cashOnDeliveryButton.addClickListener(removeClick -> {
            confirmPaymentMethodButton.setVisible(true);
            new Notification("Cash on delivery is selected!", 2000).open();
        });
        final Icon creditCardOnDeliveryButtonIcon = VaadinIcon.CREDIT_CARD.create();
        creditCardOnDeliveryButtonIcon.setSize(ICON_SIZE);
        Button creditCardOnDeliveryButton = new Button("Credit card", creditCardOnDeliveryButtonIcon);
        creditCardOnDeliveryButton.getStyle().set("background", BG_COLOR).set("color", TEXT_COLOR).set("height", BUTTON_HEIGHT).set("width", "42%");
        creditCardOnDeliveryButton.addClickListener(addClick -> {
            confirmPaymentMethodButton.setVisible(true);
            new Notification("Credit card on delivery is selected!", 2000).open();
        });


        basketActionsDiv.add(cashOnDeliveryButton, creditCardOnDeliveryButton, confirmPaymentMethodButton);
        basketInfoDiv.add(basketActionsDiv);
        return basketInfoDiv;
    }

    private void createOrderRequestWithOrderApi(final long storeId, List<BasketProduct> basketProducts) {

        BasketShipping shipping = basketServiceClient.apiGetBasketShipping(getTokenCookie().getValue())[0];
        BasketBilling billing = basketServiceClient.apiGetBasketBilling(getTokenCookie().getValue())[0];

        List<OrderLineItemsItem> products = new ArrayList<>();
        basketProducts.forEach(basketProduct -> {
            products.add(
                    OrderLineItemsItem.builder()
                            .productId((int) basketProduct.getProductId())
                            .quantity(basketProduct.getQuantity()).build());
        });

        OrderRequest orderRequest = OrderRequest.builder()
                .billing(OrderBilling.builder()
                        .firstName(billing.getFirstName())
                        .lastName(billing.getLastName())
                        .email(billing.getEmail())
                        .phone(billing.getPhone())
                        .address1(billing.getAddress())
                        .postcode(billing.getPostcode())
                        .city(billing.getMunicipality())
                        .build())
                .shipping(OrderShipping.builder()
                        .firstName(shipping.getFirstName())
                        .lastName(shipping.getLastName())
                        .address1(shipping.getAddress())
                        .postcode(shipping.getPostcode())
                        .city(shipping.getMunicipality())
                        .build())
                .lineItems(products)
                .paymentMethod("cod")
                .paymentMethodTitle("Cash on delivery")
                .setPaid(false)
                .build();

        System.out.println(orderRequest);

        orderServiceClient.apiAddOrder(orderRequest);

        new Notification("Order is added", 4000).open();
    }

    private Cookie getTokenCookie() {
        Cookie[] cookies = VaadinService.getCurrentRequest().getCookies();
        return Arrays.stream(cookies).filter(cookie -> TOKEN_COOKIE.equals(cookie.getName())).findFirst().orElse(null);
    }

}