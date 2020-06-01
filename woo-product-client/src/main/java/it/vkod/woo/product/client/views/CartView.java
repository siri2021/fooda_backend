package it.vkod.woo.product.client.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import it.vkod.woo.product.client.pojo.basket.req.BasketProduct;
import it.vkod.woo.product.client.clients.WooBasketServiceClient;
import it.vkod.woo.product.client.pojo.product.res.ProductResponse;
import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import java.util.Arrays;

import static it.vkod.woo.product.client.views.CartView.ROUTE;

@UIScope
@Route(value = ROUTE, layout = MasterView.class)
@SpringComponent
@CssImport("./styles/materialize.min.css")
@CssImport("./styles/custom-card.css")
public class CartView extends Div {

    @Autowired
    private WooBasketServiceClient basketServiceClient;

    private static final String TOKEN_COOKIE = "token";
    public final static String ROUTE = "basket";
    private final String BG_COLOR = "#3333FF";
    private final String TEXT_COLOR = "white";

    @PostConstruct
    public void init() {
        setClassName("container-fluid");
        getBasketByUserId(getTokenCookie().getValue());
    }

    private void getBasketByUserId(final String userId) {
        final BasketProduct[] basket = basketServiceClient.apiGetBasketProducts(userId);
        Arrays.stream(basket).forEach(basketProduct -> add(createBasketImageDiv(basketProduct)));
    }

    private Div createBasketImageDiv(BasketProduct basketProduct) {
        Div productImgCard = new Div();
        productImgCard.setClassName("card-image");
        Image productImage = new Image(basketProduct.getImageUrl(), basketProduct.getName());
        productImage.getStyle()
                .set("height", "150px")
                .set("width", "100%");
        Span cardTitleSpan = new Span();
        cardTitleSpan.setClassName("card-title");
        cardTitleSpan.setText(basketProduct.getName());
        final double subQty = basketProduct.getPrice() * basketProduct.getQuantity();
        final Label basketPriceQtyInfo = new Label(String.valueOf(subQty));
        Div buttonsDiv = new Div();
        buttonsDiv.setClassName("btn-floating halfway-fab waves-effect waves-light blue");
        final Icon addButtonIcon = VaadinIcon.PLUS_CIRCLE_O.create();
        addButtonIcon.setSize("48px");
        Button increaseQtyButton = new Button(addButtonIcon);
        increaseQtyButton.setClassName("btn-floating halfway-fab waves-effect waves-light blue");
        increaseQtyButton.getStyle()
                .set("height", "48px")
                .set("width", "120px");
        increaseQtyButton.addClickListener(click -> {
            basketServiceClient.apiIncreaseBasketProductQuantity(basketProduct);
            basketPriceQtyInfo.setText(String.valueOf(subQty + basketProduct.getPrice()));
            final String notificationMsg = basketProduct.getName() + " is increased.";
            new Notification(notificationMsg, 1000).open();
        });
        final Icon removeButton = VaadinIcon.MINUS_CIRCLE_O.create();
        removeButton.setSize("48px");
        Button decreaseQtyButton = new Button(removeButton);
        decreaseQtyButton.setClassName("btn-floating halfway-fab waves-effect waves-light blue");
        decreaseQtyButton.getStyle()
                .set("height", "48px")
                .set("width", "120px");
        decreaseQtyButton.addClickListener(click -> {
            basketServiceClient.apiDecreaseBasketProductQuantity(basketProduct);
            basketPriceQtyInfo.setText(String.valueOf(subQty - basketProduct.getPrice()));
            final String notificationMsg = basketProduct.getName() + " is decreased.";
            new Notification(notificationMsg, 1000).open();
        });
        buttonsDiv.add(decreaseQtyButton, basketPriceQtyInfo, decreaseQtyButton);
        productImgCard.add(productImage, cardTitleSpan, buttonsDiv);
        return productImgCard;
    }

    private Cookie getTokenCookie() {
        Cookie[] cookies = VaadinService.getCurrentRequest().getCookies();
        return Arrays.stream(cookies).filter(cookie -> TOKEN_COOKIE.equals(cookie.getName())).findFirst().orElse(null);
    }

}
