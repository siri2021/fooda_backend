package it.vkod.woo.product.client.views.mobile;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import it.vkod.woo.product.client.clients.WooBasketServiceClient;
import it.vkod.woo.product.client.clients.WooMatchServiceClient;
import it.vkod.woo.product.client.pojo.basket.req.BasketProduct;
import it.vkod.woo.product.client.pojo.product.res.ProductResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Precision;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;
import java.util.Arrays;

@Slf4j
@UIScope
@Route(value = "mobile-search", layout = MasterView.class)
@SpringComponent
@CssImport("./styles/responsive.css")
public class SearchView extends Div {

    @Autowired
    private WooMatchServiceClient matchServiceClient;

    @Autowired
    private WooBasketServiceClient basketServiceClient;

    public SearchView() {
        getSearchText();
    }

    private void getSearchText() {
        Div row = new Div();
        row.setClassName("row");

        Div column = new Div();
        column.setClassName("column");

        TextField searchTextField = new TextField();
        searchTextField.setClassName("search-text");
        searchTextField.setValueChangeMode(ValueChangeMode.EAGER);
        searchTextField.getElement().callJsFunction("focus");
        Button searchButton = new Button("Search");
        searchButton.setClassName("search-button");
        searchButton.addClickShortcut(Key.ENTER);
        searchButton.addClickListener(click -> searchProducts(searchTextField.getValue().toLowerCase()));

        column.add(searchTextField, searchButton);
        row.add(column);
        add(row);
    }

    private void searchProducts(final String search) {
        Div row = new Div();
        row.setClassName("row");

        Arrays
                .stream(matchServiceClient.apiGetMatchFromAllStores(search))
                .forEach(productResponse -> {
                    Div column = new Div();
                    column.setClassName("column");
                    Div productCard = new Div();
                    productCard.setClassName("product-div");
                    Image image = new Image(productResponse.getImages().get(0).getSrc(), productResponse.getImages().get(0).getAlt());
                    image.setClassName("product-img");
                    H4 header = new H4(productResponse.getName());
                    Paragraph price = new Paragraph(String.valueOf(productResponse.getPrice() != null ? productResponse.getPrice() : productResponse.getRegularPrice()) + "€");
                    price.setClassName("product-price");
                    Paragraph description = new Paragraph();
                    final String htmlElementsRegex = "<[^>]*>";
                    description.setText(productResponse.getDescription().replaceAll(htmlElementsRegex, ""));
                    Paragraph buttons = new Paragraph();
                    Button add = new Button("Add to Basket");
                    add.setClassName("product-button");
                    add.addClickListener(callAddToBasket(productResponse));
                    buttons.add(add);

                    productCard.add(image, header, price, description, buttons);
                    column.add(productCard);
                    row.add(column);
                });

        add(row);
    }

    @NotNull
    private ComponentEventListener<ClickEvent<Button>> callAddToBasket(ProductResponse productResponse) {
        return click -> {
            basketServiceClient.apiAddBasketProduct(BasketProduct.builder()
                    .userId(getTokenCookie().getValue())
                    .storeId(productResponse.getStoreId())
                    .restUrl(productResponse.getRestUrl())
                    .productId(productResponse.getId())
                    .name(productResponse.getName())
                    .price(Precision.round(productResponse.getPrice(), 2))
                    .quantity(1)
                    .imageUrl(productResponse.getImages().get(0).getSrc())
                    .build());

            final String notificationMsg = productResponse.getName() + " is added.";
            Notification.show(notificationMsg, 1000, Notification.Position.BOTTOM_CENTER);
        };
    }

    private Cookie getTokenCookie() {
        Cookie[] cookies = VaadinService.getCurrentRequest().getCookies();
        return Arrays.stream(cookies).filter(cookie -> "token".equals(cookie.getName())).findFirst().orElse(null);
    }

}
