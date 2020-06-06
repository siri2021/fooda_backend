package it.vkod.woo.product.client.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import it.vkod.woo.product.client.clients.WooBasketServiceClient;
import it.vkod.woo.product.client.pojo.basket.req.BasketProduct;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

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
    private transient Stream<BasketProduct> basketProducts;

    public BasketLayout(final WooBasketServiceClient basketServiceClient, final MainAppLayout appLayout) {
        this.appLayout = appLayout;
        this.basketServiceClient = basketServiceClient;
        Notification.show("Your session ID is " + sessionId, 2000, Notification.Position.BOTTOM_CENTER).open();
        basketProducts = Arrays.stream(basketServiceClient.apiGetBasketProducts(sessionId));
        initializeBasketProducts();
        add(layoutContent);
    }

    /**
     * <div class="row">
     *     <div class="col s12 m6">
     *       <div class="card">
     *         <div class="card-image">
     *           <img src="images/sample-1.jpg">
     *           <span class="card-title">Card Title</span>
     *           <a class="btn-floating halfway-fab waves-effect waves-light red"><i class="material-icons">add</i></a>
     *         </div>
     *         <div class="card-content">
     *           <p>I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.</p>
     *         </div>
     *       </div>
     *     </div>
     *   </div>
     */
    private void initializeBasketProducts() {

        Div row = new Div();
        row.setClassName("row");

        basketProducts.forEach(product -> {
            Div column = new Div();
            column.setClassName("col s12 m6 l4");

            Div productDiv = new Div();
            productDiv.setClassName("card");

            Div productImageDiv = new Div();
            productImageDiv.setClassName("card-image");
            Image image = new Image(product.getImageUrl(), product.getName());
            image.setMaxHeight("150px");
            productImageDiv.add(image);
            Span title = new Span(product.getName());
            title.setClassName("card-title");
            productImageDiv.add(title);
            final String price = (product.getPrice() + "€");
            Button add = new Button(VaadinIcon.PLUS.create());
            add.setClassName("btn-floating halfway-fab waves-effect waves-light blue");
            add.addClickListener(click -> increaseQuantityEvent(product));
            Button del = new Button(VaadinIcon.MINUS.create());
            del.setClassName("btn-floating halfway-fab waves-effect waves-light blue");
            del.getStyle().set("left", "20px");
            del.addClickListener(click -> decreaseQuantityEvent(product));
            productImageDiv.add(add, del);
            productDiv.add(productImageDiv);

            Div contentDiv = new Div();
            contentDiv.setClassName("card-content");
            H3 subtotal = new H3("Subtotal: " + price);
            Paragraph content = new Paragraph();
            content.setText("Product source: " + product.getRestUrl());
            contentDiv.add(subtotal, content);
            productDiv.add(contentDiv);

            column.add(productDiv);
            row.add(column);
        });

        layoutContent.add(row);
    }

    private void initializeBasket(final Stream<BasketProduct> basketProducts) {

        Div row = new Div();
        row.setClassName("row");

        basketProducts.forEach(basketProduct -> {
            Div column = new Div();
            column.setClassName("column");
            Div productCard = new Div();
            productCard.setClassName("product-div");
            Image image = new Image(basketProduct.getImageUrl(), basketProduct.getName());
            image.setClassName("product-img");
            image.setHeight("150px");
            H4 header = new H4(basketProduct.getName());
            Paragraph price = new Paragraph((basketProduct.getPrice() + "€"));
            price.setClassName("product-price");
            Paragraph buttons = new Paragraph();
            buttons.add(createDecreaseButton(basketProduct), createIncreaseButton(basketProduct));

            productCard.add(image, header, price, buttons);
            column.add(productCard);
            row.add(column);
        });

        layoutContent.add(row);
    }

    @NotNull
    private Button createDecreaseButton(BasketProduct basketProduct) {
        final Icon icon = VaadinIcon.MINUS_CIRCLE_O.create();
        icon.setSize("32px");
        Button button = new Button(icon);
        button.setClassName("product-button");
        button.getStyle().set("margin-left", "10px").set("margin-right", "10px").set("width", "20px").set("left", "0%");
        button.addClickListener(click -> {
            decreaseQuantityEvent(basketProduct);
        });
        return button;
    }

    private void decreaseQuantityEvent(BasketProduct basketProduct) {
        basketServiceClient.apiDecreaseBasketProductQuantity(basketProduct);
        final String message = basketProduct.getName() + " is decreased.";
        appLayout.getBadge().setCount(appLayout.getBadge().getCount() - 1);
        new Notification(message, 1000).open();
    }

    @NotNull
    private Button createIncreaseButton(BasketProduct basketProduct) {
        final Icon icon = VaadinIcon.PLUS_CIRCLE_O.create();
        icon.setSize("32px");
        Button button = new Button(icon);
        button.setClassName("product-button");
        button.getStyle().set("margin-left", "10px").set("margin-right", "10px").set("width", "20px").set("right", "0%");
        button.addClickListener(click -> increaseQuantityEvent(basketProduct));
        return button;
    }

    private void increaseQuantityEvent(BasketProduct basketProduct) {
        basketServiceClient.apiIncreaseBasketProductQuantity(basketProduct);
        appLayout.getBadge().setCount(appLayout.getBadge().getCount() + 1);
        final String message = basketProduct.getName() + " is increased.";
        new Notification(message, 1000).open();
    }

    @Override
    String getViewName() {
        return getClass().getName();
    }
}