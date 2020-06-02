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
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.springframework.beans.factory.annotation.Autowired;
import org.vandeseer.easytable.TableDrawer;
import org.vandeseer.easytable.structure.Row;
import org.vandeseer.easytable.structure.Table;
import org.vandeseer.easytable.structure.cell.TextCell;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static it.vkod.woo.product.client.views.mobile.OrderView.ROUTE;
import static java.awt.Color.LIGHT_GRAY;
import static java.awt.Color.WHITE;
import static org.apache.pdfbox.pdmodel.font.PDType1Font.*;
import static org.vandeseer.easytable.settings.HorizontalAlignment.*;
import static org.vandeseer.easytable.settings.VerticalAlignment.TOP;

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

        final OrderResponse order = orderServiceClient.apiGetOrderOne(ORDER_ID, 2);

        generatePdfFromOrder(order);

        searchDiv.add(searchButton);
        add(searchDiv);
    }

    @SneakyThrows
    private void generatePdfFromOrder(final OrderResponse orderResponse) {

        final OrderResponseShipping shipping = orderResponse.getShipping();

        FileInputStream template = new FileInputStream("C:\\Users\\yilma\\IdeaProjects\\fooda\\woo-product-client\\src\\main\\resources\\test\\template.pdf");
        try (PDDocument document = PDDocument.load(template)) {
            PDAcroForm form = document.getDocumentCatalog().getAcroForm();
            PDField field = form.getField("ShippingFirstNameTextBox");
            field.setValue(shipping.getFirst_name());
            field = form.getField("ShippingLastNameTextBox");
            field.setValue(shipping.getLast_name());

            try (PDPageContentStream contentStream = new PDPageContentStream(document, document.getPage(0), PDPageContentStream.AppendMode.APPEND, true)) {

                TableDrawer tableDrawer = TableDrawer.builder()
                        .contentStream(contentStream)
                        .startX(50f)
                        .startY(400f)
                        .table(productsTable(orderResponse))
                        .build();

                tableDrawer.draw();
            }


            document.save("C:\\Users\\yilma\\IdeaProjects\\fooda\\woo-product-client\\src\\main\\resources\\test\\order-" + ORDER_ID + ".pdf");
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private Table productsTable(final OrderResponse orderResponse) {

        final Color BLUE_DARK = new Color(76, 129, 190);
        final Color BLUE_LIGHT_1 = new Color(186, 206, 230);
        final Color BLUE_LIGHT_2 = new Color(218, 230, 242);

        final List<OrderResponseLineItemsItem> orderedProducts = orderResponse.getLine_items();

        final Table.TableBuilder tableBuilder = Table.builder()
                .addColumnsOfWidth(200, 100, 100, 100)
                .fontSize(8)
                .font(HELVETICA)
                .borderColor(WHITE);

        // Add the header row ...
        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("Product").horizontalAlignment(LEFT).borderWidth(1).build())
                .add(TextCell.builder().text("Price").borderWidth(1).build())
                .add(TextCell.builder().text("Quantity").borderWidth(1).build())
                .add(TextCell.builder().text("Subtotal").borderWidth(1).build())
                .backgroundColor(BLUE_DARK)
                .textColor(WHITE)
                .font(HELVETICA_BOLD)
                .fontSize(9)
                .horizontalAlignment(CENTER)
                .build());

        // ... and some data rows
        double grandTotal = 0;
        for (int i = 0; i < orderedProducts.size(); i++) {
            final double total = orderedProducts.get(i).getPrice() * orderedProducts.get(i).getQuantity();
            grandTotal += total;

            tableBuilder.addRow(Row.builder()
                    .add(TextCell.builder().text(orderedProducts.get(i).getName()).horizontalAlignment(LEFT).borderWidth(1).build())
                    .add(TextCell.builder().text(orderedProducts.get(i).getPrice() + " €").borderWidth(1).build())
                    .add(TextCell.builder().text(String.valueOf(orderedProducts.get(i).getQuantity())).borderWidth(1).build())
                    .add(TextCell.builder().text(total + " €").borderWidth(1).build())
                    .backgroundColor(i % 2 == 0 ? BLUE_LIGHT_1 : BLUE_LIGHT_2)
                    .horizontalAlignment(RIGHT)
                    .build());
        }

        // Add a final row
        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("Please DO NOT hesitate to contact us if you recognize any wrong information. " +
                        "To contact us for your requests, please email to tickets@fooda.be ")
                        .colSpan(3)
                        .lineSpacing(1f)
                        .borderWidthTop(1)
                        .textColor(WHITE)
                        .backgroundColor(BLUE_DARK)
                        .fontSize(6)
                        .font(HELVETICA_OBLIQUE)
                        .borderWidth(1)
                        .build())
                .add(TextCell.builder().text(grandTotal + " €").backgroundColor(LIGHT_GRAY)
                        .font(HELVETICA_BOLD_OBLIQUE)
                        .verticalAlignment(TOP)
                        .borderWidth(1)
                        .build())
                .horizontalAlignment(RIGHT)
                .build());

        return tableBuilder.build();
    }

    private Cookie getTokenCookie() {
        Cookie[] cookies = VaadinService.getCurrentRequest().getCookies();
        return Arrays.stream(cookies).filter(cookie -> TOKEN_COOKIE.equals(cookie.getName())).findFirst().orElse(null);
    }

}
