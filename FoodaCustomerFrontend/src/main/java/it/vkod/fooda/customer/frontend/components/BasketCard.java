package it.vkod.fooda.customer.frontend.components;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.VaadinIcon;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

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
@Builder(toBuilder = true)
@Getter
@EqualsAndHashCode(callSuper = true)
@Tag("div")
public class BasketCard extends Div {

    private final String imageUrl;
    private final String name;
    private final String content;
    private final double price;
    private final ComponentEventListener<ClickEvent<Button>> increaseEvent;
    private final ComponentEventListener<ClickEvent<Button>> decreaseEvent;

    public BasketCard(final String name, final String imageUrl, final String description, final double price,
                      final ComponentEventListener<ClickEvent<Button>> increaseEvent, final ComponentEventListener<ClickEvent<Button>> decreaseEvent) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.content = description;
        this.price = price;
        this.increaseEvent = increaseEvent;
        this.decreaseEvent = decreaseEvent;

        setClassName("card small");

        Div productImageDiv = new Div();
        productImageDiv.setClassName("card-image");
        Image i = new Image(imageUrl, name);
        productImageDiv.add(i);
        Span t = new Span(name);
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
        H4 subtotal = new H4("Subtotal: " + price + "€");
        Paragraph c = new Paragraph();
        c.setText("Product source: " + description);
        contentDiv.add(subtotal, c);
        add(contentDiv);
    }
}
