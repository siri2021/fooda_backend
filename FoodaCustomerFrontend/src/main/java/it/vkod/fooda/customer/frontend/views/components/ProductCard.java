package it.vkod.fooda.customer.frontend.views.components;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;

/**
 * <div class="card large">
 *     <div class="card-image">
 *     <img src="images/sample-1.jpg">
 *     <span class="card-title">Card Title</span>
 *     <a class="btn-floating halfway-fab waves-effect waves-light red"><i class="material-icons">add</i></a>
 *     </div>
 *     <div class="card-content">
 *     <p>I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.</p>
 *     </div>
 * </div>
 */
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@Tag("div")
public class ProductCard extends Div {

//    private final String imageUrl;
//    private final String title;
//    private final String content;
//    private final double price;
//    private final ComponentEventListener<ClickEvent<Button>> addEvent;

    public ProductCard(final String name, final String imageUrl, final String description, final double price,
                       final ComponentEventListener<ClickEvent<Button>> addEvent) {
//        this.imageUrl = imageUrl;
//        this.title = name;
//        this.content = description;
//        this.price = price;
//        this.addEvent = addEvent;

        setClassName("card");

        Div cardImage = new Div();
        cardImage.setClassName("card-image");
        Image i = new Image(imageUrl, name);
        cardImage.add(i);
        Span s = new Span();
        s.setClassName("card-title");
        s.setText(name);
        cardImage.add(s);
        Button b = new Button("Add to basket " + new DecimalFormat("##.##").format(price) + " €");
        b.addClickListener(addEvent);
        b.setClassName("btn-floating halfway-fab waves-effect waves-light blue");
        b.getStyle().set("z-index", "9999").set("height", "48px").set("width", "50%");
        cardImage.add(b);

        Div cardContent = new Div();
        cardContent.setClassName("card-content");
        Paragraph p = new Paragraph();
        String htmlElementsRegex = "<[^>]*>";
        String desc = description.replaceAll(htmlElementsRegex, "");
        p.setText(desc);
        cardContent.add(p);

        add(cardImage, cardContent);
    }
}
