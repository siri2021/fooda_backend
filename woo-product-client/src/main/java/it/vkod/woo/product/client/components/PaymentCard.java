package it.vkod.woo.product.client.components;

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
import lombok.EqualsAndHashCode;

import java.text.DecimalFormat;
import java.util.List;

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
@EqualsAndHashCode(callSuper = true)
@Tag("div")
public class PaymentCard extends Div {

    public PaymentCard(final String logo, final double subtotal,
                       final List<String[]> values,
                       final boolean withHeader,
                       final ComponentEventListener<ClickEvent<Button>> confirmEvent) {

        setClassName("card large");

        Div cardContent = new Div();
        cardContent.setClassName("card-content");

        Image i = new Image(logo, "logo");
        i.setMaxHeight("96px");
        i.setClassName("halfway-fab waves-effect waves-light");
        cardContent.add(i);


        final StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder
                .append("<table class=\"responsive-table\">");
        if (withHeader) {
            final String[] headers = values.get(0);
            values.remove(0);
            htmlBuilder
                    .append("<thead>")
                    .append("<tr>");
            for (String header : headers) {
                htmlBuilder
                        .append("<th>")
                        .append(header)
                        .append("</th>");
            }
            htmlBuilder
                    .append("</tr>")
                    .append("</thead>");
        }

        htmlBuilder
                .append("<tbody>");

        for (String[] val : values) {
            htmlBuilder
                    .append("<tr>");

            for (String v : val) {
                htmlBuilder
                        .append("<td>")
                        .append(v)
                        .append("</td>");
            }

            htmlBuilder.append("</tr>");
        }

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
        Button b = new Button("Confirm order with " + new DecimalFormat("##.##").format(subtotal) + "€", c);
        b.setWidthFull();
        b.addClickListener(confirmEvent);

        cardContent.add(i, t, p, b);

        add(cardContent);
    }
}
