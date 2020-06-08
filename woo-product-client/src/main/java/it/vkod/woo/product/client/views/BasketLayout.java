package it.vkod.woo.product.client.views;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import it.vkod.woo.product.client.clients.WooBasketServiceClient;
import it.vkod.woo.product.client.components.BasketCard;
import it.vkod.woo.product.client.pojo.basket.req.BasketProduct;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.stream.Stream;

@Slf4j
@Route(value = "basket", layout = MainAppLayout.class)
@StyleSheet("https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css")
public class BasketLayout extends AbstractView {

    private final transient WooBasketServiceClient basketServiceClient;
    private final MainAppLayout appLayout;

    private final VerticalLayout layoutContent = new VerticalLayout();
    private final String sessionId = VaadinSession.getCurrent().getSession().getId();
    private final transient Stream<BasketProduct> basketProducts;

    public BasketLayout(final WooBasketServiceClient basketServiceClient, final MainAppLayout appLayout) {
        this.appLayout = appLayout;
        this.basketServiceClient = basketServiceClient;
        Notification.show("Your session ID is " + sessionId, 2000, Notification.Position.BOTTOM_CENTER).open();

        basketProducts = Arrays.stream(basketServiceClient.apiGetBasketProducts(sessionId));
        basketProducts.forEach(this::mapBasketProductWithBasketCardDiv);

        setMargin(false);
        setPadding(false);
        setFlexGrow(0.25, layoutContent);
        add(layoutContent);
    }

    private void mapBasketProductWithBasketCardDiv(BasketProduct product) {
        layoutContent.add(
                new BasketCard(
                        product.getName(),
                        product.getImageUrl(),
                        product.getRestUrl(),
                        product.getPrice() * product.getQuantity(),
                        increaseEvent(product),
                        decreaseEvent(product)
                ));
    }

    private ComponentEventListener<ClickEvent<Button>> increaseEvent(BasketProduct product) {
        return click -> {
            basketServiceClient.apiIncreaseBasketProductQuantity(product);
            appLayout.getBadge().setCount(appLayout.getBadge().getCount() + 1);
            final String message = product.getName() + " is increased.";
            new Notification(message, 1000).open();
        };
    }

    private ComponentEventListener<ClickEvent<Button>> decreaseEvent(BasketProduct product) {
        return click -> {
            basketServiceClient.apiDecreaseBasketProductQuantity(product);
            final String message = product.getName() + " is decreased.";
            appLayout.getBadge().setCount(appLayout.getBadge().getCount() - 1);
            new Notification(message, 1000).open();
        };
    }


    @Override
    String getViewName() {
        return getClass().getName();
    }
}