package it.vkod.fooda.customer.frontend.views;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import it.vkod.fooda.customer.frontend.clients.WooBasketServiceClient;
import it.vkod.fooda.customer.frontend.clients.WooOrderServiceClient;
import it.vkod.fooda.customer.frontend.components.PaymentCard;
import it.vkod.fooda.customer.frontend.models.basket.req.BasketBilling;
import it.vkod.fooda.customer.frontend.models.basket.req.BasketOrder;
import it.vkod.fooda.customer.frontend.models.basket.req.BasketProduct;
import it.vkod.fooda.customer.frontend.models.basket.req.BasketShipping;
import it.vkod.fooda.customer.frontend.models.order.req.*;
import it.vkod.fooda.customer.frontend.models.order.res.OrderResponse;
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

    private final MainAppLayout app;
    private final VerticalLayout content = new VerticalLayout();

    public PaymentLayout(WooBasketServiceClient basketServiceClient, WooOrderServiceClient orderServiceClient, MainAppLayout app) {
        this.basketServiceClient = basketServiceClient;
        this.orderServiceClient = orderServiceClient;
        this.app = app;

        getBasketByUserId();

        add(content);
    }

    private void getBasketByUserId() {

        final Map<Long, List<BasketProduct>> groupedBaskets = Arrays
                .stream(basketServiceClient.apiGetBasketProducts(app.getSession().getId()))
                .collect(Collectors.groupingBy(BasketProduct::getStoreId));
        groupedBaskets.forEach((storeId, basketProducts) -> content.add(createBasketInfoDivs(storeId, basketProducts)));
    }

    @SneakyThrows
    private Div createBasketInfoDivs(final long storeId, final List<BasketProduct> basketProducts) {

        AtomicReference<Double> subTotal = new AtomicReference<>((double) 0);
        basketProducts.forEach(basketProduct -> {
            final double price = basketProduct.getPrice() * basketProduct.getQuantity();
            subTotal.updateAndGet(v -> v + price);
        });

        return new PaymentCard(
                "https://www.codespromo.be/wp-content/uploads/2017/02/Pizzahut.jpg",
                subTotal.get(),
                mapProductsWithArrayList(basketProducts),
                true,
                orderEvent(storeId, basketProducts)
        );

    }

    private List<String[]> mapProductsWithArrayList(List<BasketProduct> basketProducts) {
        final List<String[]> products = new ArrayList<>();
        products.add(new String[]{"Product", "Quantity", "Price", "Subtotal"});
        products.addAll(basketProducts.stream()
                .map(p -> new String[]{
                        p.getName(),
                        String.valueOf(p.getQuantity()),
                        p.getPrice() + "€",
                        p.getPrice() * p.getQuantity() + "€"
                })
                .collect(Collectors.toList()));
        return products;
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

        BasketShipping delivery = basketServiceClient.apiGetBasketShipping(app.getSession().getId())[0];
        BasketBilling billing = basketServiceClient.apiGetBasketBilling(app.getSession().getId())[0];

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

        basketServiceClient.apiAddBasketOrder(new BasketOrder(UUID.randomUUID(), orderResponse.getId(), app.getSession().getId(), storeId));

        new Notification("Your order " + orderResponse.getId() + " is created!", 3000).open();
        app.getBadge().setCount(app.getBadge().getCount() - basketProducts.size());

        return orderResponse;
    }

    @Override
    String getViewName() {
        return getClass().getName();
    }
}