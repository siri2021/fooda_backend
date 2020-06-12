package it.vkod.woo.product.client.views;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import it.vkod.woo.product.client.clients.WooBasketServiceClient;
import it.vkod.woo.product.client.clients.WooMatchServiceClient;
import it.vkod.woo.product.client.components.ProductCard;
import it.vkod.woo.product.client.pojo.basket.req.BasketProduct;
import it.vkod.woo.product.client.pojo.product.response.ProductResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Precision;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.stream.Stream;

@Slf4j
@Route(value = "search", layout = MainAppLayout.class)
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

        setMargin(false);
        setPadding(false);
        setSpacing(false);
        setFlexGrow(1, layoutContent);
    }

    private void getSearchText() {

        TextField searchTextField = new TextField();
        searchTextField.setValueChangeMode(ValueChangeMode.EAGER);
        searchTextField.getElement().callJsFunction("focus");
        Button searchButton = new Button("Search");
        searchButton.addClickShortcut(Key.ENTER);
        searchButton.addClickListener(click -> {
            searchedProducts = Arrays.stream(matchServiceClient.apiGetMatchFromAllStores(searchTextField.getValue().toLowerCase()));
            searchedProducts.forEach(this::mapProductResponseWithProductCardDiv);
        });

        layoutContent.add(searchTextField, searchButton);

        setMargin(false);
        setPadding(false);
        setWidthFull();
        setFlexGrow(0.25, layoutContent);
        add(layoutContent);
    }


    private void mapProductResponseWithProductCardDiv(ProductResponse product) {
        ProductCard card = new ProductCard(
                product.getName(),
                product.getImages().get(0).getSrc(),
                product.getDescription(),
                product.getPrice() != null ? product.getPrice() : Double.parseDouble(product.getRegularPrice()),
                callAddToBasket(product)
        );

        layoutContent.add(card);
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
