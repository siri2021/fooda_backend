package it.vkod.fooda.customer.frontend.views.components;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.VaadinIcon;
import it.vkod.fooda.customer.frontend.models.basket.req.BasketProduct;
import lombok.Builder;
import lombok.EqualsAndHashCode;

/**
 * <div class="card small">
 *     <div class="card-image">
 *     <img src="images/sample-1.jpg">
 *     <span class="card-title">Card Title</span>
 *     <a class="btn-floating halfway-fab waves-effect waves-light blue"><i class="material-icons">add</i></a>
 *     </div>
 *     <div class="card-content">
 *     <p>I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.</p>
 *     </div>
 * </div>
 */
@Builder
@EqualsAndHashCode(callSuper = true)
@Tag("div")
public class BasketCard extends Div {

    private final BasketProduct product;
    private final ComponentEventListener<ClickEvent<Button>> increaseEvent;
    private final ComponentEventListener<ClickEvent<Button>> decreaseEvent;

    public BasketCard init() {

        setClassName("card");

        Div productImageDiv = new Div();
        productImageDiv.setClassName("card-image");
        Image i = new Image(product.getImage(), product.getName());
        productImageDiv.add(i);
        Span t = new Span(product.getName());
        t.setClassName("card-title");
        productImageDiv.add(t);
        Button add = new Button(VaadinIcon.PLUS.create());
        add.setClassName("btn-floating halfway-fab waves-effect waves-light blue");
        add.getStyle().set("right", "20px").set("z-index", "9999");
        add.addClickListener(increaseEvent);
        Button del = new Button(VaadinIcon.MINUS.create());
        del.setClassName("btn-floating halfway-fab waves-effect waves-light blue");
        del.getStyle().set("left", "20px").set("z-index", "9999");
        del.addClickListener(decreaseEvent);
        productImageDiv.add(add, del);
        add(productImageDiv);

        Div contentDiv = new Div();
        contentDiv.setClassName("card-content");
        H4 subtotal = new H4("Subtotal: " + product.getPrice() + "€");
        Paragraph c = new Paragraph();
        c.setText("Product source: " + product.getRestUrl());
        contentDiv.add(subtotal, c);
        add(contentDiv);

        return this;
    }
}
