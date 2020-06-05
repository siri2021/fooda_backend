package it.vkod.woo.product.client.views;

import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "delivery", layout = MainAppLayout.class)
public class DeliveryLayout extends AbstractView {

    public DeliveryLayout(@Autowired MainAppLayout appLayout) {

    }

    @Override
    String getViewName() {
        return getClass().getName();
    }
}