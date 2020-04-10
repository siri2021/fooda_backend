package it.vkod.views;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import it.vkod.services.WooMatchService;
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
    private WooMatchService service;

    public final static String ROUTE = "search";

    @PostConstruct
    public void init() {

        TextField searchTextField = new TextField();
        searchTextField.setWidth("75%");

        setClassName("container-fluid");


        Button searchBtn = new Button("Search", clickEvent -> {
            Arrays.stream(service.apiMatch(searchTextField.getValue())).forEach(wooStore -> {

                Arrays.stream(wooStore.getMatchedProducts()).forEach(wooProduct -> {

                    Div productCard = new Div();
                    productCard.setClassName("card");

                    Div productImgCard = new Div();
                    productImgCard.setClassName("card-image waves-effect waves-block waves-light");
                    Image productImage = new Image(wooProduct.getImages().get(0).getSrc(), wooProduct.getImages().get(0).getAlt());
                    productImage.setClassName("activator");
                    productImage.addClickListener(click -> {
                        final String notificationMsg = wooProduct.getName() + " is added.";
                        new Notification(notificationMsg, 2000).open();
                    });
                    productImgCard.add(productImage);

                    Div productContentCard = new Div();
                    productContentCard.setClassName("card-content");
                    Span productContentSpan = new Span();
                    productContentSpan.setClassName("card-title activator grey-text text-darken-4");
                    productContentSpan.setText(wooProduct.getName());
                    Paragraph productContentP = new Paragraph();
                    productContentP.setText(wooProduct.getDescription());
                    productContentCard.add(productContentSpan, productContentP);

                    productCard.add(productImgCard, productContentCard);
                    add(productCard);
                });

            });
        });
        searchBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        searchBtn.addClickShortcut(Key.ENTER);
        searchBtn.setWidth("24%");

        add(searchBtn, searchTextField);

    }

}
