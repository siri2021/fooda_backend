package it.vkod.woo.product.client.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Input;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import it.vkod.woo.product.client.payloads.basketRequest.Basket;
import it.vkod.woo.product.client.services.WooBasketServiceClient;
import it.vkod.woo.product.client.services.WooMatchServiceClient;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static it.vkod.woo.product.client.views.PaymentView.ROUTE;

@UIScope
@Route(value = ROUTE, layout = MasterView.class)
@SpringComponent
public class PaymentView extends Div {

    @Autowired
    private WooBasketServiceClient basketServiceClient;

    public final static String ROUTE = "payment";
    private final String BG_COLOR = "#FF5733";
    private final String TEXT_COLOR = "white";
    private final String BUTTON_HEIGHT = "48px";
    private final String BUTTON_WIDTH = "32px";
    private long USER_ID;

    @PostConstruct
    public void init() {

        setClassName("container-fluid");
        setUserIdFromInput();
    }

    private void setUserIdFromInput() {
        Dialog dialog = new Dialog();
        Input input = new Input();
        dialog.add(input);
        dialog.open();
        input.getElement().callJsFunction("focus");
        input.addValueChangeListener(event -> {
            if (event.getValue().contains("#")) {
                dialog.close();
                USER_ID = Long.parseLong(input.getValue().replace("#", ""));
                getBasketByUserId(USER_ID);
            }
        });
    }

    private void getBasketByUserId(final long userId) {

        final Map<Long, List<Basket>> groupedBaskets = Arrays.stream(basketServiceClient.apiGetBasketProducts(userId))
                .collect(Collectors.groupingBy(Basket::getStoreId));

        groupedBaskets.forEach((storeId, baskets) -> {
            Div productCard = new Div();
            productCard.setClassName("card horizontal");
            productCard.add(createBasketInfoDiv(baskets));
            add(productCard);
        });
    }

    private Div createBasketInfoDiv(List<Basket> baskets) {

        Div basketInfoDiv = new Div();
        basketInfoDiv.setClassName("card-stacked");

        baskets.forEach(basket -> {
            Div basketContentDiv = new Div();
            basketContentDiv.setClassName("card-content");
            Header cartInfoHeader = new Header();
            cartInfoHeader.setText(basket.getName() + " x " + basket.getQuantity());
            Label priceLabel = new Label();
            priceLabel.setText("€" + basket.getPrice() * basket.getQuantity());
            basketContentDiv.add(cartInfoHeader, priceLabel);
            basketInfoDiv.add(basketContentDiv);
        });

        Div basketActionsDiv = new Div();
        basketActionsDiv.setClassName("card-action");
        final Icon cashOnDeliveryButtonIcon = VaadinIcon.CASH.create();
        Button cashOnDeliveryButton = new Button(cashOnDeliveryButtonIcon);
        cashOnDeliveryButton.getStyle().set("background", BG_COLOR).set("color", TEXT_COLOR).set("height", BUTTON_HEIGHT).set("width", BUTTON_WIDTH);
        cashOnDeliveryButton.addClickListener(removeClick -> {
            new Notification("Cash on delivery is selected!", 2000).open();
        });
        final Icon creditCardOnDeliveryButtonIcon = VaadinIcon.CREDIT_CARD.create();
        Button creditCardOnDeliveryButton = new Button(creditCardOnDeliveryButtonIcon);
        creditCardOnDeliveryButton.getStyle().set("background", BG_COLOR).set("color", TEXT_COLOR).set("height", BUTTON_HEIGHT).set("width", BUTTON_WIDTH);
        creditCardOnDeliveryButton.addClickListener(addClick -> {
            new Notification("Credit card on delivery is selected!", 2000).open();
        });
        basketActionsDiv.add(cashOnDeliveryButton, creditCardOnDeliveryButton);

        basketInfoDiv.add(basketActionsDiv);
        return basketInfoDiv;
    }


}