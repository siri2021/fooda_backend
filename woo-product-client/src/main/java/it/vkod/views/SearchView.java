package it.vkod.views;

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
import it.vkod.payloads.basketRequest.BasketProduct;
import it.vkod.payloads.productResponse.WooProduct;
import it.vkod.services.WooBasketServiceClient;
import it.vkod.services.WooMatchServiceClient;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Arrays;

import static it.vkod.views.SearchView.ROUTE;

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
        searchDiv.setClassName("card-panel blue");
        searchDiv.getStyle().set("margin", "0").set("padding", "0").set("height", "32px");

        TextField searchTextField = new TextField();
        searchTextField.setClassName("white-text");
        searchTextField.getStyle().set("margin", "0").set("padding", "0").set("height", "32px").set("width", "75%");

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
        searchBtn.getStyle().set("margin", "0").set("padding", "0").set("height", "32px").set("width", "25%");
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
        productContentP.setSizeFull();
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
        addButton.setClassName("btn-floating halfway-fab waves-effect waves-light red");
        addButton.addClickListener(click -> {
            basketServiceClient.apiPostCachedBasketProducts(new BasketProduct(wooProduct.getStoreId(), (long) wooProduct.getId(), wooProduct.getName(), wooProduct.getPrice(), wooProduct.getImages().get(0).getSrc()));
            final String notificationMsg = wooProduct.getName() + " from " + wooProduct.getStoreId() + " is added.";
            new Notification(notificationMsg, 2000).open();
        });
        productImgCard.add(productImage, cardTitleSpan, addButton);
        return productImgCard;
    }

}
