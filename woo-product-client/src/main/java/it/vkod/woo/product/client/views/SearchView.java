package it.vkod.woo.product.client.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import it.vkod.woo.product.client.payloads.basket.request.Basket;
import it.vkod.woo.product.client.payloads.product.response.WooProductResponse;
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

    private final long USER_ID = UniqueID.get();

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
        getSearchText();
    }

    private void getSearchText() {
        Dialog dialog = new Dialog();
        Input input = new Input();
        dialog.add(input);
        dialog.open();
        input.getElement().callJsFunction("focus");
        input.addValueChangeListener(event -> {
            if (event.getValue().contains("#")) {
                dialog.close();
                searchProducts(input.getValue());
            }
        });
    }

    private void searchProducts(final String search) {
        Arrays.stream(matchServiceClient.apiGetMatchFromAllStores(search.replace("#", ""))).forEach(wooProductResponse -> {
            Div productCard = new Div();
            productCard.setClassName("card");
            Div productImgCard = createProductImageDiv(wooProductResponse);
            Div productContentCard = createProductContentDiv(wooProductResponse);
            productCard.add(productImgCard, productContentCard);
            add(productCard);
        });
    }

    private Div createProductContentDiv(WooProductResponse wooProductResponse) {
        Div productContentCard = new Div();
        productContentCard.setClassName("card-content");
        Paragraph productContentP = new Paragraph();
        //match HTML tags
        final String htmlElementsRegex = "<[^>]*>";
        productContentP.setText(wooProductResponse.getDescription().replaceAll(htmlElementsRegex, ""));
        productContentP.getStyle().set("font-weight", "bold").set("font-size", "11pt");
        productContentCard.add(productContentP);
        return productContentCard;
    }

    private Div createProductImageDiv(WooProductResponse wooProductResponse) {
        Div productImgCard = new Div();
        productImgCard.setClassName("card-image");
        Image productImage = new Image(wooProductResponse.getImages().get(0).getSrc(), wooProductResponse.getImages().get(0).getAlt());
        Span cardTitleSpan = new Span();
        cardTitleSpan.setClassName("card-title");
        cardTitleSpan.setText(wooProductResponse.getName());
        final Icon addButtonIcon = VaadinIcon.PLUS_CIRCLE_O.create();
        addButtonIcon.setSize("32px");
        Button addButton = new Button(addButtonIcon);
        addButton.setClassName("btn-floating halfway-fab waves-effect waves-light green");
        addButton.addClickListener(click -> {
            System.out.println("productId -> " + wooProductResponse.getId() + " storeId -> " + wooProductResponse.getStoreId());
            basketServiceClient.apiAddBasketProduct(Basket.builder().userId(USER_ID).storeId(wooProductResponse.getStoreId()).productId(wooProductResponse.getId()).name(wooProductResponse.getName()).price(wooProductResponse.getPrice()).quantity(1).imageUrl(wooProductResponse.getImages().get(0).getSrc()).build());
            final String notificationMsg = wooProductResponse.getName() + " added.";
            new Notification(notificationMsg, 2000).open();
        });
        productImgCard.add(productImage, cardTitleSpan, addButton);
        return productImgCard;
    }

}
