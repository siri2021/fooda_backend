package it.vkod.woo.product.client.views.mobile;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import it.vkod.woo.product.client.clients.WooBasketServiceClient;
import it.vkod.woo.product.client.pojo.basket.req.BasketProduct;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import java.text.DecimalFormat;
import java.util.Arrays;

import static it.vkod.woo.product.client.views.mobile.CartView.ROUTE;

@Slf4j
@UIScope
@Route(value = ROUTE, layout = MasterView.class)
@SpringComponent
@CssImport("./styles/responsive.css")
public class CartView extends Div {

    @Autowired
    private WooBasketServiceClient basketServiceClient;

    private static final String TOKEN_COOKIE = "token";
    public final static String ROUTE = "mobile-basket";
    private final String BG_COLOR = "#3333FF";
    private final String TEXT_COLOR = "white";
    private final String DEFAULT_FONT_SIZE = "12pt";

    @PostConstruct
    public void init() {
        getBasketByUserId(getTokenCookie().getValue());
    }

    private void getBasketByUserId(final String userId) {
        final BasketProduct[] basket = basketServiceClient.apiGetBasketProducts(userId);
        Arrays.stream(basket).forEach(basketProduct -> {
            Div productCard = new Div();
            productCard.setClassName("card");
            Div productImgCard = createBasketImageDiv(basketProduct);
            Div buttonsDiv = createButtonsDiv(basketProduct);
            productCard.add(productImgCard, buttonsDiv);
            add(productCard);
        });
    }

    private Div createButtonsDiv(BasketProduct basketProduct) {
        Div productContentCard = new Div();
        productContentCard.setClassName("card-content");
        final double subQty = basketProduct.getPrice() * basketProduct.getQuantity();
        Div priceInfoDiv = new Div();
        priceInfoDiv.getStyle()
                .set("text-align", "center")
                .set("font-weight", "bold")
                .set("font-size", DEFAULT_FONT_SIZE)
                .set("display", "inline-block");
        priceInfoDiv.setText(basketProduct.getName() + " x " + basketProduct.getQuantity() + " in total " + new DecimalFormat("##.##").format(subQty) + "€");
        priceInfoDiv.getStyle()
                .set("margin-top", "0")
                .set("margin-bottom", "0")
                .set("height", "38px");
        productContentCard.add(priceInfoDiv);
        return productContentCard;
    }

    private Div createBasketImageDiv(BasketProduct basketProduct) {
        Div productImgCard = new Div();
        productImgCard.setClassName("card-image");
        Image productImage = new Image(basketProduct.getImageUrl(), basketProduct.getName());
        productImage.getStyle()
                .set("height", "150px")
                .set("width", "100%");
        productImgCard.add(productImage, createIncreaseButton(basketProduct), createDecreaseButton(basketProduct));
        return productImgCard;
    }

    @NotNull
    private Button createDecreaseButton(BasketProduct basketProduct) {
        final Icon decreaseQtyButtonIcon = VaadinIcon.MINUS_CIRCLE_O.create();
        decreaseQtyButtonIcon.setSize("32px");
        Button decreaseQtyButton = new Button(decreaseQtyButtonIcon);
        decreaseQtyButton.setClassName("btn-floating halfway-fab waves-effect waves-light blue");
        decreaseQtyButton.getStyle().set("left", "20px");
        decreaseQtyButton.addClickListener(click -> {
            basketServiceClient.apiDecreaseBasketProductQuantity(basketProduct);
            final String notificationMsg = basketProduct.getName() + " is decreased.";
            new Notification(notificationMsg, 1000).open();
        });
        return decreaseQtyButton;
    }

    @NotNull
    private Button createIncreaseButton(BasketProduct basketProduct) {
        final Icon increaseQtyButtonIcon = VaadinIcon.PLUS_CIRCLE_O.create();
        increaseQtyButtonIcon.setSize("32px");
        Button increaseQtyButton = new Button(increaseQtyButtonIcon);
        increaseQtyButton.setClassName("btn-floating halfway-fab waves-effect waves-light blue");
        increaseQtyButton.getStyle().set("right", "20px");
        increaseQtyButton.addClickListener(click -> {
            basketServiceClient.apiIncreaseBasketProductQuantity(basketProduct);
            final String notificationMsg = basketProduct.getName() + " is increased.";
            new Notification(notificationMsg, 1000).open();
        });
        return increaseQtyButton;
    }

    private Cookie getTokenCookie() {
        Cookie[] cookies = VaadinService.getCurrentRequest().getCookies();
        return Arrays.stream(cookies).filter(cookie -> TOKEN_COOKIE.equals(cookie.getName())).findFirst().orElse(null);
    }

}
