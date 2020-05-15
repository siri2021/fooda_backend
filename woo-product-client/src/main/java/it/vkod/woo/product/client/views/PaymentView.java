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
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
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
    private final String BUTTON_HEIGHT = "38px";
    private final String ICON_SIZE = "28px";
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
        AtomicReference<Double> subTotal = new AtomicReference<>((double) 0);

        baskets.forEach(basket -> {
            Div basketContentDiv = new Div();
            basketContentDiv.setClassName("card-content");
            Header cartInfoHeader = new Header();
            cartInfoHeader.getStyle().set("font-size", "12pt");
            cartInfoHeader.setText(basket.getName() + " x " + basket.getQuantity());
            Label priceLabel = new Label();
            priceLabel.getStyle().set("font-size", "12pt");
            final double price = basket.getPrice() * basket.getQuantity();
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
            new Notification("Payment Method is confirmed!", 2000).open();
        });
        confirmPaymentMethodButton.setEnabled(false);

        Div basketActionsDiv = new Div();
        basketActionsDiv.setClassName("card-action");
        final Icon cashOnDeliveryButtonIcon = VaadinIcon.CASH.create();
        cashOnDeliveryButtonIcon.setSize(ICON_SIZE);
        Button cashOnDeliveryButton = new Button("Cash", cashOnDeliveryButtonIcon);
        cashOnDeliveryButton.getStyle().set("background", BG_COLOR).set("color", TEXT_COLOR).set("height", BUTTON_HEIGHT).set("width", "42%");
        cashOnDeliveryButton.addClickListener(removeClick -> {
            confirmPaymentMethodButton.setEnabled(true);
            new Notification("Cash on delivery is selected!", 2000).open();
        });
        final Icon creditCardOnDeliveryButtonIcon = VaadinIcon.CREDIT_CARD.create();
        creditCardOnDeliveryButtonIcon.setSize(ICON_SIZE);
        Button creditCardOnDeliveryButton = new Button("Credit card", creditCardOnDeliveryButtonIcon);
        creditCardOnDeliveryButton.getStyle().set("background", BG_COLOR).set("color", TEXT_COLOR).set("height", BUTTON_HEIGHT).set("width", "42%");
        creditCardOnDeliveryButton.addClickListener(addClick -> {
            confirmPaymentMethodButton.setEnabled(true);
            new Notification("Credit card on delivery is selected!", 2000).open();
        });


        basketActionsDiv.add(cashOnDeliveryButton, creditCardOnDeliveryButton, confirmPaymentMethodButton);
        basketInfoDiv.add(basketActionsDiv);
        return basketInfoDiv;
    }


}