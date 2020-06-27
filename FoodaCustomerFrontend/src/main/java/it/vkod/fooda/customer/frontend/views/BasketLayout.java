package it.vkod.fooda.customer.frontend.views;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import it.vkod.fooda.customer.frontend.clients.FoodaBasketClient;
import it.vkod.fooda.customer.frontend.models.basket.req.BasketProduct;
import it.vkod.fooda.customer.frontend.views.components.BasketCard;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Slf4j
@Route(value = "basket", layout = MainAppLayout.class)
@StyleSheet("https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css")
@CssImport("./styles/cards.css")
public class BasketLayout extends AbstractView {

    @Autowired
    private FoodaBasketClient basketServiceClient;
    @Autowired
    private MainAppLayout app;

    private final Div container = new Div();

    @PostConstruct
    public void init() {
        container.setClassName("cards-container");

        Arrays.stream(basketServiceClient.apiGetBasketProducts(app.getSession().getId()))
                .forEach(product -> container.add(BasketCard.builder()
                        .product(product)
                        .increaseEvent(increaseEvent(product))
                        .decreaseEvent(decreaseEvent(product))
                        .build()
                        .init()));

        VerticalLayout content = new VerticalLayout();
        content.add(container);
        add(content);
    }

    private ComponentEventListener<ClickEvent<Button>> increaseEvent(BasketProduct product) {
        return click -> {
            basketServiceClient.apiIncreaseBasketProductQuantity(product);
            app.getBadge().setCount(app.getBadge().getCount() + 1);
            final String message = product.getName() + " is increased.";
            new Notification(message, 1000).open();
        };
    }

    private ComponentEventListener<ClickEvent<Button>> decreaseEvent(BasketProduct product) {
        return click -> {
            basketServiceClient.apiDecreaseBasketProductQuantity(product);
            final String message = product.getName() + " is decreased.";
            app.getBadge().setCount(app.getBadge().getCount() - 1);
            new Notification(message, 1000).open();
        };
    }


    @Override
    String getViewName() {
        return getClass().getName();
    }
}