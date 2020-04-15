package it.vkod.woo.product.client.views;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import it.vkod.woo.product.client.payloads.basketRequest.BasketProduct;
import it.vkod.woo.product.client.payloads.productResponse.WooProduct;
import it.vkod.woo.product.client.services.WooBasketServiceClient;
import it.vkod.woo.product.client.services.WooMatchServiceClient;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Arrays;

import static it.vkod.woo.product.client.views.SearchView.ROUTE;

@UIScope
@Route(value = ROUTE, layout = MasterView.class)
@SpringComponent
@CssImport("./styles/materialize.min.css")
@CssImport("./styles/custom-card.css")
public class SearchView extends Div {

    @Autowired
    private WooMatchServiceClient matchServiceClient;

    @Autowired
    private WooBasketServiceClient basketServiceClient;

    public final static String ROUTE = "search";

    private final String BG_COLOR = "#FF5733"; // RGB 255, 87, 51
    private final String TEXT_COLOR = "white";
    private final String BUTTON_HEIGHT = "48px";

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

        setClassName("container-fluid");

        Div searchDiv = new Div();
        searchDiv.setClassName("card-panel");
        searchDiv.getStyle().set("margin", "0").set("padding", "0").set("background-color", BG_COLOR);

        TextField searchTextField = new TextField();
        searchTextField.setClassName("white-text");
        searchTextField.getStyle().set("margin", "0").set("padding", "0").set("height", BUTTON_HEIGHT).set("width", "75%").set("background-color", BG_COLOR);

        Button searchBtn = new Button("Search", clickEvent -> {

            Arrays.stream(matchServiceClient.apiGetMatchFromAllStores(searchTextField.getValue())).forEach(wooProduct -> {
                Div productCard = new Div();
                productCard.setClassName("card");
                Div productImgCard = createProductImageDiv(wooProduct);
                Div productContentCard = createProductContentDiv(wooProduct);
                productCard.add(productImgCard, productContentCard);
                add(productCard);
            });

        });

        searchBtn.addClickShortcut(Key.ENTER);
        searchBtn.setClassName("white-text");
        searchBtn.getStyle().set("margin", "0").set("padding", "0").set("height", BUTTON_HEIGHT).set("width", "25%").set("background-color", BG_COLOR);
        searchDiv.add(searchTextField, searchBtn);

        add(searchDiv);

    }

    private Div createProductContentDiv(WooProduct wooProduct) {
        Div productContentCard = new Div();
        productContentCard.setClassName("card-content");
        Paragraph productContentP = new Paragraph();
        //match HTML tags
        final String htmlElementsRegex = "<[^>]*>";
        productContentP.setText(wooProduct.getDescription().replaceAll(htmlElementsRegex, ""));
        productContentP.getStyle().set("font-weight", "bold").set("font-size", "11pt");
        productContentCard.add(productContentP);
        return productContentCard;
    }

    private Div createProductImageDiv(WooProduct wooProduct) {
        Div productImgCard = new Div();
        productImgCard.setClassName("card-image");
        Image productImage = new Image(wooProduct.getImages().get(0).getSrc(), wooProduct.getImages().get(0).getAlt());
        Span cardTitleSpan = new Span();
        cardTitleSpan.setClassName("card-title");
        cardTitleSpan.setText(wooProduct.getName());
        final Icon addButtonIcon = VaadinIcon.PLUS_CIRCLE_O.create();
        addButtonIcon.setSize("32px");
        Button addButton = new Button(addButtonIcon);
        addButton.setClassName("btn-floating halfway-fab waves-effect waves-light green");
        addButton.addClickListener(click -> {
            basketServiceClient.apiPostCachedBasketProducts(new BasketProduct(wooProduct.getStoreId(), (long) wooProduct.getId(), wooProduct.getName(), wooProduct.getPrice(), wooProduct.getImages().get(0).getSrc()));
            final String notificationMsg = wooProduct.getName() + " from " + wooProduct.getStoreId() + " is added.";
            new Notification(notificationMsg, 2000).open();
        });
        productImgCard.add(productImage, cardTitleSpan, addButton);
        return productImgCard;
    }

}
