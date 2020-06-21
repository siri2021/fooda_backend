package it.vkod.fooda.customer.frontend.views;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import it.vkod.fooda.customer.frontend.clients.FoodaBasketClient;
import it.vkod.fooda.customer.frontend.clients.FoodaProductClient;
import it.vkod.fooda.customer.frontend.models.basket.req.BasketProduct;
import it.vkod.fooda.customer.frontend.models.product.response.ProductResponse;
import it.vkod.fooda.customer.frontend.views.components.ProductCard;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Route(value = "", layout = MainAppLayout.class)
@StyleSheet("https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css")
@CssImport("./styles/cards.css")
public class HomeLayout extends AbstractView {

    @Autowired
    private FoodaProductClient productClient;
    @Autowired
    private FoodaBasketClient basketClient;
    @Autowired
    private MainAppLayout appLayout;

    private final Div container = new Div();

    @PostConstruct
    public void init() {
        container.setClassName("cards-container");
        initTopSellingProducts();
        add(new VerticalLayout(container));
    }

    private void initTopSellingProducts() {
        final CompletableFuture<ProductResponse[]> products = productClient.apiGetProductsFromAllStores();
        Arrays.stream(products.join()).forEach(product -> container.add(mapProductToDiv(product)));
    }

    private Div mapProductToDiv(ProductResponse productResponse) {
        return new ProductCard(
                productResponse.getName(),
                productResponse.getImages().get(0).getSrc(),
                productResponse.getDescription(),
                productResponse.getPrice() != null ? productResponse.getPrice() : Double.parseDouble(productResponse.getRegularPrice()),
                callAddToBasket(productResponse)
        );
    }

    @NotNull
    private ComponentEventListener<ClickEvent<Button>> callAddToBasket(ProductResponse productResponse) {
        return click -> {

            final BasketProduct productToAdd = new BasketProduct(
                    UUID.randomUUID(),
                    appLayout.getSession().getId(),
                    productResponse.getStoreId(),
                    productResponse.getRestUrl(),
                    productResponse.getId(),
                    productResponse.getName(),
                    Math.round(productResponse.getPrice()),
                    1,
                    productResponse.getImages().get(0).getSrc());

            basketClient.apiAddBasketProduct(productToAdd);

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
