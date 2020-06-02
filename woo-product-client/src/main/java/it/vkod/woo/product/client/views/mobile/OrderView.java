package it.vkod.woo.product.client.views.mobile;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import it.vkod.woo.product.client.clients.WooOrderServiceClient;
import it.vkod.woo.product.client.pojo.order.res.OrderResponse;
import it.vkod.woo.product.client.pojo.order.res.OrderResponseLineItemsItem;
import it.vkod.woo.product.client.pojo.order.res.OrderResponseShipping;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDListBox;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static it.vkod.woo.product.client.views.mobile.OrderView.ROUTE;

@Slf4j
@UIScope
@Route(value = ROUTE, layout = MasterView.class)
@SpringComponent
@CssImport("./styles/materialize.min.css")
@CssImport("./styles/custom-card.css")
public class OrderView extends Div {

    private static final String TOKEN_COOKIE = "token";
    public static final String ROUTE = "order";

    private final String BG_COLOR = "#3333FF"; // RGB 255, 87, 51
    private final String TEXT_COLOR = "white";

    private final int ORDER_ID = 20026;

    @Autowired
    private WooOrderServiceClient orderServiceClient;

    /**
     * Based on Materialize css ..
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

    @PostConstruct
    public void init() {
        if (getTokenCookie() == null)
            UI.getCurrent().navigate("");

        setClassName("container-fluid");

        createPdfDiv();
    }

    private void createPdfDiv() {

        Div searchDiv = new Div();
        searchDiv.setClassName("card");
        searchDiv.getStyle()
                .set("background", BG_COLOR)
                .set("color", TEXT_COLOR)
                .set("height", "48px")
                .set("text-align", "center")
                .set("margin-left", "0")
                .set("margin-right", "0")
                .set("vertical-align", "middle")
                .set("margin-top", "5%");

        Button searchButton = new Button("Generate Demo PDF");
        searchButton.addClickShortcut(Key.ENTER);
        searchButton.getStyle()
                .set("background", BG_COLOR)
                .set("color", TEXT_COLOR)
                .set("margin-left", "0")
                .set("margin-right", "0")
                .set("width", "100%");
        searchButton.addClickListener(click -> {
            try {

                final OrderResponse order = orderServiceClient.apiGetOrderOne(ORDER_ID, 2);
                final OrderResponseShipping shipping = order.getShipping();

                PDDocument document = PDDocument.load(new File("C:\\Users\\yilma\\IdeaProjects\\fooda\\woo-product-client\\src\\main\\resources\\test\\fooda order form.pdf"));
                PDAcroForm form = document.getDocumentCatalog().getAcroForm();
                PDField field = form.getField("ShippingFirstNameTextBox");
                field.setValue(shipping.getFirst_name());
                field = form.getField("ShippingLastNameTextBox");
                field.setValue(shipping.getLast_name());
                PDListBox orderDetails = (PDListBox) form.getField("OrderDetailsListBox");

                for (OrderResponseLineItemsItem product : order.getLine_items()) {
                    orderDetails.setValue(Arrays.asList(product.getName(), String.valueOf(product.getPrice()), String.valueOf(product.getQuantity()), product.getSubtotal()));
                }

                document.save("C:\\Users\\yilma\\IdeaProjects\\fooda\\woo-product-client\\src\\main\\resources\\test\\fooda order form (filled).pdf");
                document.close();
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        });

        searchDiv.add(searchButton);
        add(searchDiv);
    }

    private Cookie getTokenCookie() {
        Cookie[] cookies = VaadinService.getCurrentRequest().getCookies();
        return Arrays.stream(cookies).filter(cookie -> TOKEN_COOKIE.equals(cookie.getName())).findFirst().orElse(null);
    }

}
