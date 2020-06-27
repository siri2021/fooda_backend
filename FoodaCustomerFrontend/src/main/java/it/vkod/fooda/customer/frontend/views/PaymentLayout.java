package it.vkod.fooda.customer.frontend.views;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import it.vkod.fooda.customer.frontend.clients.FoodaBasketClient;
import it.vkod.fooda.customer.frontend.clients.FoodaOrderClient;
import it.vkod.fooda.customer.frontend.models.basket.req.*;
import it.vkod.fooda.customer.frontend.models.order.req.*;
import it.vkod.fooda.customer.frontend.models.order.res.OrderResponse;
import it.vkod.fooda.customer.frontend.views.components.PaymentCard;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Route(value = "payment", layout = MainAppLayout.class)
@StyleSheet("https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css")
public class PaymentLayout extends AbstractView {

    @Autowired
    private FoodaBasketClient basketServiceClient;
    @Autowired
    private FoodaOrderClient orderServiceClient;
    @Autowired
    private MainAppLayout app;

    private final VerticalLayout content = new VerticalLayout();

    @PostConstruct
    public void init() {
        Arrays
                .stream(basketServiceClient.apiGetBasketProducts(app.getSession().getId()))
                .collect(Collectors.groupingBy(BasketProduct::getStoreId))
                .forEach((storeId, basketProducts) -> content.add(createBasketInfoDivs(storeId, basketProducts)));
        add(content);
    }

    @SneakyThrows
    private Div createBasketInfoDivs(final long storeId, final List<BasketProduct> basketProducts) {
        return PaymentCard.builder()
                .logo("https://www.codespromo.be/wp-content/uploads/2017/02/Pizzahut.jpg")
                .products(basketProducts)
                .billingAddress(basketServiceClient.apiGetBasketBilling(app.getSession().getId()))
                .shippingAddress(basketServiceClient.apiGetBasketAddress(app.getSession().getId()))
                .payment(BasketPayment.builder()
                        .paymentId(UUID.randomUUID())
                        .method("cod")
                        .title("Cash on delivery")
                        .storeId(storeId)
                        .userId(app.getSession().getId()).build())
                .confirmEvent(orderEvent(storeId, basketProducts))
                .build();
    }

    private ComponentEventListener<ClickEvent<Button>> orderEvent(long storeId, List<BasketProduct> basketProducts) {
        return addClick -> {
            final OrderResponse orderResponse = createOrderRequestWithOrderApi(storeId, basketProducts);
            log.info(orderResponse.toString());
            basketServiceClient.apiClearBasketProducts(app.getSession().getId());
        };
    }

    @SneakyThrows
    private OrderResponse createOrderRequestWithOrderApi(final long storeId, List<BasketProduct> basketProducts) {

        BasketAddress delivery = basketServiceClient.apiGetBasketAddress(app.getSession().getId());
        BasketAddress billing = basketServiceClient.apiGetBasketAddress(app.getSession().getId());

        List<OrderRequestLineItemsItem> products = new ArrayList<>();
        basketProducts.forEach(basketProduct -> products.add(OrderRequestLineItemsItem.builder()
                .product_id((int) basketProduct.getProductId())
                .quantity(basketProduct.getQuantity()).build()));

        BasketPayment basketPayment = BasketPayment.builder()
                .paymentId(UUID.randomUUID())
                .method("Cash on Delivery")
                .storeId(storeId)
                .title("cod")
                .userId(app.getSession().getId())
                .build();

        OrderRequest orderRequest = mapBasketToOrderRequest(delivery, billing, products, basketPayment);
        final OrderResponse orderResponse = orderServiceClient.apiAddOrderWithResponse(orderRequest, storeId);
        basketServiceClient.apiAddBasketOrder(new BasketOrder(UUID.randomUUID(), orderResponse.getId(), app.getSession().getId(), storeId));

        new Notification("Your order " + orderResponse.getId() + " is created!", 3000).open();
        app.getBadge().setCount(app.getBadge().getCount() - basketProducts.size());

        return orderResponse;
    }

    private OrderRequest mapBasketToOrderRequest(BasketAddress delivery, BasketAddress billing, List<OrderRequestLineItemsItem> products, BasketPayment basketPayment) {
        return OrderRequest.builder()
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
                        .address_1(billing.getAddressLine1())
                        .address_2(billing.getAddressLine2())
                        .postcode(billing.getPostcode())
                        .city(billing.getMunicipality() + "," + billing.getCity())
                        .state(billing.getRegion())
                        .country(billing.getCountry())
                        .build())
                .shipping(OrderRequestShipping.builder()
                        .first_name(delivery.getFirstName())
                        .last_name(delivery.getLastName())
                        .address_1(delivery.getAddressLine1())
                        .address_2(delivery.getAddressLine2())
                        .postcode(delivery.getPostcode())
                        .city(delivery.getMunicipality() + "," + delivery.getCity())
                        .state(delivery.getRegion())
                        .country(delivery.getCountry())
                        .build())
                .line_items(products)
                .payment_method(basketPayment.getMethod())
                .payment_method_title(basketPayment.getTitle())
                .set_paid(false)
                .build();
    }

    @Override
    String getViewName() {
        return getClass().getName();
    }
}