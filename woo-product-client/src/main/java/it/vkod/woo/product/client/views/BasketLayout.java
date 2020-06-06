package it.vkod.woo.product.client.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import it.vkod.woo.product.client.clients.WooBasketServiceClient;
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
        initializeBasketProducts();
        add(layoutContent);
    }

    /**
     * <div class="row">
     *     <div class="col s12 m6">
     *       <div class="card small">
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
            productDiv.setClassName("card small");

            Div productImageDiv = new Div();
            productImageDiv.setClassName("card-image");
            Image image = new Image(product.getImageUrl(), product.getName());
//            image.setMaxHeight("150px");
            productImageDiv.add(image);
            Span title = new Span(product.getName());
            title.setClassName("card-title");
            productImageDiv.add(title);
            final String price = (product.getPrice() + "€");
            Button add = new Button(VaadinIcon.PLUS.create());
            add.setClassName("btn-floating halfway-fab waves-effect waves-light blue");
            add.getStyle().set("right", "20px").set("z-index", "999");
            add.addClickListener(click -> increaseQuantityEvent(product));
            Button del = new Button(VaadinIcon.MINUS.create());
            del.setClassName("btn-floating halfway-fab waves-effect waves-light blue");
            del.getStyle().set("left", "20px").set("z-index", "999");
            del.addClickListener(click -> decreaseQuantityEvent(product));
            productImageDiv.add(add, del);
            productDiv.add(productImageDiv);

            Div contentDiv = new Div();
            contentDiv.setClassName("card-content");
            H4 subtotal = new H4("Subtotal: " + price);
            Paragraph content = new Paragraph();
            content.setText("Product source: " + product.getRestUrl());
            contentDiv.add(subtotal, content);
            productDiv.add(contentDiv);

            column.add(productDiv);
            row.add(column);
        });

        layoutContent.add(row);
    }

    private void decreaseQuantityEvent(BasketProduct basketProduct) {
        basketServiceClient.apiDecreaseBasketProductQuantity(basketProduct);
        final String message = basketProduct.getName() + " is decreased.";
        appLayout.getBadge().setCount(appLayout.getBadge().getCount() - 1);
        new Notification(message, 1000).open();
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