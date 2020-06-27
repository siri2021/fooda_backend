package it.vkod.fooda.customer.frontend.views.components;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import it.vkod.fooda.customer.frontend.models.basket.req.BasketAddress;
import it.vkod.fooda.customer.frontend.models.basket.req.BasketPayment;
import it.vkod.fooda.customer.frontend.models.basket.req.BasketProduct;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Stream;

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
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@Tag("div")
public class PaymentCard extends Div {

    private final String logo;
    private final List<BasketProduct> products;
    private final BasketAddress billingAddress;
    private final BasketAddress shippingAddress;
    private BasketPayment payment;
    private final ComponentEventListener<ClickEvent<Button>> confirmEvent;

    public PaymentCard init() {

        setClassName("card large");

        Div cardContent = new Div();
        cardContent.setClassName("card-content");

        Image i = new Image(logo, "logo");
        i.setMaxHeight("96px");
        i.setClassName("halfway-fab waves-effect waves-light");
        cardContent.add(i);

        final StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder
                .append("<table>");

        Stream<String> headers = Stream.of("Product", "Quantity", "Price", "Subtotal");

        htmlBuilder
                .append("<thead>")
                .append("<tr>");

        headers.forEach(header -> htmlBuilder
                .append("<th>")
                .append(header)
                .append("</th>"));

        htmlBuilder
                .append("</tr>")
                .append("</thead>");

        htmlBuilder
                .append("<tbody>");


        products.forEach(product -> htmlBuilder
                .append("<tr>")
                .append("<td>")
                .append(product.getName())
                .append("</td>")
                .append("<td>")
                .append(product.getQuantity())
                .append("</td>")
                .append("<td>")
                .append(product.getPrice())
                .append("</td>")
                .append("<td>").append(new DecimalFormat("##.##").format(product.getQuantity() * product.getPrice())).append("€")
                .append("</td>")
                .append("</tr>"));

        htmlBuilder
                .append("</tbody>")
                .append("</table>");

        Html t = new Html(htmlBuilder.toString());

        ComboBox<String> p = new ComboBox<>();
        p.setItems("Cash on Delivery", "Credit Card on delivery", "Bancontact", "PayPal");
        p.setLabel("Payment Method");
        p.setWidthFull();

        final Icon c = VaadinIcon.CREDIT_CARD.create();
        c.setSize("28px");
        final double sum = products.stream()
                .mapToDouble(product -> product.getQuantity() * product.getPrice())
                .sum();
        Button b = new Button("Confirm order with " + new DecimalFormat("##.##").format(sum) + "€", c);
        b.setWidthFull();
        b.getStyle().set("margin-left", "10px").set("margin-right", "10px");
        b.addClickListener(confirmEvent);

        cardContent.add(i, t, p, b);

        add(cardContent);

        return this;
    }
}
