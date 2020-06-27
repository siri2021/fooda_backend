package it.vkod.fooda.customer.frontend.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import it.vkod.fooda.customer.frontend.clients.FoodaBasketClient;
import it.vkod.fooda.customer.frontend.models.basket.req.BasketAddress;
import it.vkod.fooda.customer.frontend.views.components.AddressCard;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Slf4j
@Route(value = "delivery", layout = MainAppLayout.class)
@StyleSheet("https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css")
public class DeliveryLayout extends AbstractView {

    @Autowired
    private FoodaBasketClient basketClient;
    @Autowired
    private MainAppLayout app;

    @PostConstruct
    public void init() {
        VerticalLayout layout = new VerticalLayout();
        layout.add(AddressCard.builder()
                .addressBeingEdited(BasketAddress.builder()
                        .id(UUID.randomUUID())
                        .userId(app.getSession().getId())
                        .billing(true)
                        .shipping(true)
                        .build())
                .build());

        add(layout);

        Button save = new Button("Save");
//        save.addClickListener(click -> basketClient.apiAddBasketBilling());

    }

    @Override
    String getViewName() {
        return getClass().getName();
    }
}