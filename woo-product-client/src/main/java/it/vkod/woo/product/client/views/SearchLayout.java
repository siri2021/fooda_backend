package it.vkod.woo.product.client.views;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import it.vkod.woo.product.client.clients.WooBasketServiceClient;
import it.vkod.woo.product.client.clients.WooMatchServiceClient;
import it.vkod.woo.product.client.pojo.basket.req.BasketProduct;
import it.vkod.woo.product.client.pojo.product.res.ProductResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Precision;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.stream.Stream;

@Slf4j
@Route(value = "", layout = MainAppLayout.class)
@StyleSheet("https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css")
public class SearchLayout extends AbstractView {

    private final transient WooMatchServiceClient matchServiceClient;
    private final transient WooBasketServiceClient basketServiceClient;
    private final MainAppLayout appLayout;

    private final String sessionId = VaadinSession.getCurrent().getSession().getId();
    private final VerticalLayout layoutContent = new VerticalLayout();
    private transient Stream<ProductResponse> searchedProducts;

    public SearchLayout(WooMatchServiceClient matchServiceClient, WooBasketServiceClient basketServiceClient, MainAppLayout appLayout) {
        this.matchServiceClient = matchServiceClient;
        this.basketServiceClient = basketServiceClient;
        this.appLayout = appLayout;
        Notification.show("Your session ID is " + sessionId, 2000, Notification.Position.BOTTOM_CENTER).open();
        getSearchText();
    }

    private void getSearchText() {

        TextField searchTextField = new TextField();
        searchTextField.setValueChangeMode(ValueChangeMode.EAGER);
        searchTextField.setMinWidth("60%");
        searchTextField.getElement().callJsFunction("focus");
        Button searchButton = new Button("Search");
        searchButton.addClickShortcut(Key.ENTER);
        searchButton.setMinWidth("40%");
        searchButton.addClickListener(click -> initProducts(searchTextField.getValue().toLowerCase()));

        layoutContent.add(searchTextField, searchButton);
        add(layoutContent);
    }

    /**
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
    private void initProducts(final String search) {

        searchedProducts = Arrays.stream(matchServiceClient.apiGetMatchFromAllStores(search));

        Div row = new Div();
        row.setClassName("row");

        searchedProducts.forEach(productResponse -> {
            Div column = new Div();
            column.setClassName("col s12 m6 l4");

            Div productDiv = new Div();
            productDiv.setClassName("card");

            Div productImageDiv = new Div();
            productImageDiv.setClassName("card-image");
            Image image = new Image(productResponse.getImages().get(0).getSrc(), productResponse.getImages().get(0).getAlt());
            productImageDiv.add(image);
            Span title = new Span(productResponse.getName());
            title.setClassName("card-title");
            productImageDiv.add(title);
            final String price = (productResponse.getPrice() != null ? productResponse.getPrice() : productResponse.getRegularPrice()) + "€";
            Button add = new Button(price);
            add.setClassName("btn-floating halfway-fab waves-effect waves-light blue");
            add.addClickListener(callAddToBasket(productResponse));
            productImageDiv.add(add);
            productDiv.add(productImageDiv);

            Div contentDiv = new Div();
            contentDiv.setClassName("card-content");
            Paragraph content = new Paragraph();
            final String htmlElementsRegex = "<[^>]*>";
            content.setText(productResponse.getDescription().replaceAll(htmlElementsRegex, ""));
            contentDiv.add(content);
            productDiv.add(contentDiv);

            column.add(productDiv);
            row.add(column);
        });

        layoutContent.add(row);
    }

    @NotNull
    private ComponentEventListener<ClickEvent<Button>> callAddToBasket(ProductResponse productResponse) {
        return click -> {
            basketServiceClient.apiAddBasketProduct(BasketProduct.builder()
                    .userId(sessionId)
                    .storeId(productResponse.getStoreId())
                    .restUrl(productResponse.getRestUrl())
                    .productId(productResponse.getId())
                    .name(productResponse.getName())
                    .price(Precision.round(productResponse.getPrice(), 2))
                    .quantity(1)
                    .imageUrl(productResponse.getImages().get(0).getSrc())
                    .build());

            final String notificationMsg = productResponse.getName() + " is added.";
            appLayout.getBadge().setCount(appLayout.getBadge().getCount() + 1);
            Notification.show(notificationMsg, 1000, Notification.Position.BOTTOM_CENTER);
        };
    }


    @Override
    String getViewName() {
        return getClass().getName();
    }

}
