package it.vkod.woo.product.client.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import it.vkod.woo.product.client.payloads.basketRequest.BasketProduct;
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
    private WooMatchServiceClient matchServiceClient;

    @Autowired
    private WooBasketServiceClient basketServiceClient;

    public final static String ROUTE = "cart";
    private final String BG_COLOR = "#FF5733";
    private final String TEXT_COLOR = "white";
    private final String BUTTON_HEIGHT = "48px";

    @PostConstruct
    public void init() {

        setClassName("container-fluid");

        Div completeOrderDiv = new Div();
        completeOrderDiv.setClassName("card-panel");
        completeOrderDiv.getStyle().set("margin", "0").set("padding", "0").set("background-color", BG_COLOR);
        Button completeOrderButton = new Button("Complete Order", clickEvent -> {
            new Notification("Order is now completed!", 2000).open();
            // TODO order will be created by a rest call to woo-basket-service ..
        });
        completeOrderButton.setClassName("white-text");
        completeOrderButton.getStyle().set("margin", "0").set("padding", "0").set("height", BUTTON_HEIGHT).set("width", "100%");
        completeOrderDiv.add(completeOrderButton);
        add(completeOrderDiv);

        final BasketProduct[] basketProducts = basketServiceClient.apiGetCachedBasketProducts();

//        final BasketOrder basketOrder = new BasketOrder();


        Arrays.stream(basketProducts).forEach(basketProduct -> {
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
    private Div createBasketInfoDiv(BasketProduct basketProduct) {

        Div basketInfoDiv = new Div();
        basketInfoDiv.setClassName("card-stacked");

        Div basketContentDiv = new Div();
        basketContentDiv.setClassName("card-content");
        Paragraph cardTitleSpan = new Paragraph();
        cardTitleSpan.setText(basketProduct.getName() + " x " + "1");
        basketContentDiv.add(cardTitleSpan);

        Div basketActionsDiv = new Div();
        basketActionsDiv.setClassName("card-action");
        final Icon removeButtonIcon = VaadinIcon.MINUS_CIRCLE_O.create();
        Button removeButton = new Button(removeButtonIcon);
        removeButton.addClickListener(removeClick -> {
            new Notification("Product is decreased!", 2000).open();
            // TODO order will be created by a rest call to woo-basket-service ..
        });
        final Icon addButtonIcon = VaadinIcon.PLUS_CIRCLE_O.create();
        Button addButton = new Button(addButtonIcon);
        addButton.addClickListener(addClick -> {
            new Notification("Product is increased!", 2000).open();
            // TODO order will be created by a rest call to woo-basket-service ..
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
    private Div createBasketImageDiv(BasketProduct basketProduct) {

        Div productImgCard = new Div();
        productImgCard.setClassName("card-image");

        Image productImage = new Image(basketProduct.getPictureUrl(), basketProduct.getName());
        productImgCard.add(productImage);

        return productImgCard;
    }

}
