package it.vkod.fooda.customer.frontend.views;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import it.vkod.fooda.customer.frontend.clients.WooBasketServiceClient;
import it.vkod.fooda.customer.frontend.clients.WooMatchServiceClient;
import it.vkod.fooda.customer.frontend.components.ProductCard;
import it.vkod.fooda.customer.frontend.models.basket.req.BasketProduct;
import it.vkod.fooda.customer.frontend.models.product.response.ProductResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Precision;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Stream;

@Slf4j
@Route(value = "search", layout = MainAppLayout.class)
@StyleSheet("https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css")
@CssImport("./styles/cards.css")
public class SearchLayout extends AbstractView {

    private final transient WooMatchServiceClient matchServiceClient;
    private final transient WooBasketServiceClient basketServiceClient;
    private final MainAppLayout app;

    private final Div container = new Div();
    private final VerticalLayout layoutContent = new VerticalLayout();
    private transient Stream<ProductResponse> searchedProducts;

    public SearchLayout(WooMatchServiceClient matchServiceClient, WooBasketServiceClient basketServiceClient, MainAppLayout app) {
        this.matchServiceClient = matchServiceClient;
        this.basketServiceClient = basketServiceClient;
        this.app = app;
        container.setClassName("cards-container");

        getSearchText();
        add(layoutContent);
    }

    private void getSearchText() {

        TextField searchTextField = new TextField();
        searchTextField.setValueChangeMode(ValueChangeMode.EAGER);
        searchTextField.getElement().callJsFunction("focus");
        Button searchButton = new Button("Search");
        searchButton.addClickShortcut(Key.ENTER);
        searchButton.addClickListener(click -> {
            searchedProducts = Arrays.stream(matchServiceClient.apiGetMatchFromAllStores(searchTextField.getValue().toLowerCase()));
            searchedProducts.forEach(product -> container.add(mapProductToDiv(product)));
            layoutContent.add(container);
        });

        layoutContent.add(searchTextField, searchButton);
    }


    private Div mapProductToDiv(ProductResponse product) {
        return new ProductCard(
                product.getName(),
                product.getImages().get(0).getSrc(),
                product.getDescription(),
                product.getPrice() != null ? product.getPrice() : Double.parseDouble(product.getRegularPrice()),
                callAddToBasket(product)
        );
    }

    @NotNull
    private ComponentEventListener<ClickEvent<Button>> callAddToBasket(ProductResponse productResponse) {
        return click -> {
            basketServiceClient.apiAddBasketProduct(new BasketProduct(
                    UUID.randomUUID(),
                    app.getSession().getId(),
                    productResponse.getStoreId(),
                    productResponse.getRestUrl(),
                    productResponse.getId(),
                    productResponse.getName(),
                    Precision.round(productResponse.getPrice(), 2),
                    1,
                    productResponse.getImages().get(0).getSrc()));

            final String notificationMsg = productResponse.getName() + " is added.";
            app.getBadge().setCount(app.getBadge().getCount() + 1);
            Notification.show(notificationMsg, 1000, Notification.Position.BOTTOM_CENTER);
        };
    }


    @Override
    String getViewName() {
        return getClass().getName();
    }

}
