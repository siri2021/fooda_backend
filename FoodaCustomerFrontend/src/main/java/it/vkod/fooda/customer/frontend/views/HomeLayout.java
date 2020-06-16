package it.vkod.fooda.customer.frontend.views;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
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
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Slf4j
@Route(value = "", layout = MainAppLayout.class)
@StyleSheet("https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css")
public class HomeLayout extends AbstractView {

    private final transient WooMatchServiceClient matchServiceClient;
    private final transient WooBasketServiceClient basketServiceClient;
    private final MainAppLayout app;

    private final VerticalLayout layoutContent = new VerticalLayout();

    public HomeLayout(WooMatchServiceClient matchServiceClient, WooBasketServiceClient basketServiceClient, MainAppLayout app) {
        this.matchServiceClient = matchServiceClient;
        this.basketServiceClient = basketServiceClient;
        this.app = app;

        initTopSellingProducts();
        add(layoutContent);
    }

    private void initTopSellingProducts() {
        List<ProductResponse> products = Arrays.asList(matchServiceClient.apiGetProductsFromAllStores());
        Collections.shuffle(products);
        Stream<ProductResponse> shuffledProducts = products.stream();
        shuffledProducts.forEach(this::mapProductResponseWithProductCardDiv);
    }

    private void mapProductResponseWithProductCardDiv(ProductResponse productResponse) {
        ProductCard card = new ProductCard(
                productResponse.getName(),
                productResponse.getImages().get(0).getSrc(),
                productResponse.getDescription(),
                productResponse.getPrice() != null ? productResponse.getPrice() : Double.parseDouble(productResponse.getRegularPrice()),
                callAddToBasket(productResponse)
        );

        layoutContent.add(card);
    }

    @NotNull
    private ComponentEventListener<ClickEvent<Button>> callAddToBasket(ProductResponse productResponse) {
        return click -> {

            final BasketProduct productToAdd = new BasketProduct(
                    UUID.randomUUID(),
                    app.getSession().getId(),
                    productResponse.getStoreId(),
                    productResponse.getRestUrl(),
                    productResponse.getId(),
                    productResponse.getName(),
                    Precision.round(productResponse.getPrice(), 2),
                    1,
                    productResponse.getImages().get(0).getSrc());

            basketServiceClient.apiAddBasketProduct(productToAdd);

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
