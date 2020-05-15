package it.vkod.woo.product.client.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.*;
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

import static it.vkod.woo.product.client.views.CartView.ROUTE;

@UIScope
@Route(value = ROUTE, layout = MasterView.class)
@SpringComponent
public class CartView extends Div {

    @Autowired
    private WooBasketServiceClient basketServiceClient;

    public final static String ROUTE = "basket";
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
        input.addValueChangeListener(valueChange -> {
            if (valueChange.getValue().contains("#")) {
                dialog.close();
                USER_ID = Long.parseLong(input.getValue().replace("#", ""));
                getBasketByUserId(USER_ID);
            }
        });
    }

    private void getBasketByUserId(final long userId) {
        final Basket[] basket = basketServiceClient.apiGetBasketProducts(userId);
        Arrays.stream(basket).forEach(basketProduct -> {
            Div productCard = new Div();
            productCard.setClassName("card horizontal");
            Div productImgCard = createBasketImageDiv(basketProduct);
            Div productInfoCard = createBasketInfoDiv(basketProduct);
            productCard.add(productImgCard, productInfoCard);
            add(productCard);
        });
    }

    /**
     * MATERIAL DESIGN INFO
     * <div class="col s12 m7">
     *    <h2 class="header">Horizontal Card</h2>
     *    <div class="card horizontal">
     *      <div class="card-image">
     *        <img src="https://lorempixel.com/100/190/nature/6">
     *      </div>
     *      <div class="card-stacked">
     *        <div class="card-content">
     *          <p>I am a very simple card. I am good at containing small bits of information.</p>
     *        </div>
     *        <div class="card-action">
     *          <a href="#">This is a link</a>
     *        </div>
     *      </div>
     *    </div>
     *  </div>
     */
    private Div createBasketInfoDiv(Basket basket) {

        Div basketInfoDiv = new Div();
        basketInfoDiv.setClassName("card-stacked");

        Div basketContentDiv = new Div();
        basketContentDiv.setClassName("card-content");
        Header cartInfoHeader = new Header();
        cartInfoHeader.setText(basket.getName() + " x " + basket.getQuantity());
        Label priceLabel = new Label();
        priceLabel.setText("€" + basket.getPrice() * basket.getQuantity());
        basketContentDiv.add(cartInfoHeader, priceLabel);

        Div basketActionsDiv = new Div();
        basketActionsDiv.setClassName("card-action");
        final Icon removeButtonIcon = VaadinIcon.MINUS_CIRCLE_O.create();
        Button removeButton = new Button(removeButtonIcon);
        removeButton.getStyle().set("background", BG_COLOR).set("color", TEXT_COLOR).set("height", BUTTON_HEIGHT).set("width", BUTTON_WIDTH);
        removeButton.addClickListener(removeClick -> {
            basketServiceClient.apiDecreaseBasketProductQuantity(basket);
            new Notification("Product is decreased!", 2000).open();
        });
        final Icon addButtonIcon = VaadinIcon.PLUS_CIRCLE_O.create();
        Button addButton = new Button(addButtonIcon);
        addButton.getStyle().set("background", BG_COLOR).set("color", TEXT_COLOR).set("height", BUTTON_HEIGHT).set("width", BUTTON_WIDTH);
        addButton.addClickListener(addClick -> {
            basketServiceClient.apiIncreaseBasketProductQuantity(basket);
            new Notification("Product is increased!", 2000).open();
        });
        basketActionsDiv.add(removeButton, addButton);

        basketInfoDiv.add(basketContentDiv, basketActionsDiv);
        return basketInfoDiv;
    }

    /**
     * MATERIAL DESIGN INFO
     * <div class="col s12 m7">
     *    <h2 class="header">Horizontal Card</h2>
     *    <div class="card horizontal">
     *      <div class="card-image">
     *        <img src="https://lorempixel.com/100/190/nature/6">
     *      </div>
     *      <div class="card-stacked">
     *        <div class="card-content">
     *          <p>I am a very simple card. I am good at containing small bits of information.</p>
     *        </div>
     *        <div class="card-action">
     *          <a href="#">This is a link</a>
     *        </div>
     *      </div>
     *    </div>
     *  </div>
     */
    private Div createBasketImageDiv(Basket basket) {

        Div productImgCard = new Div();
        productImgCard.setClassName("card-image");
        productImgCard.getStyle().set("height", "60px");

        Image productImage = new Image(basket.getImageUrl(), basket.getName());
        productImgCard.add(productImage);

        return productImgCard;
    }

}
