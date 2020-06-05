package it.vkod.woo.product.client.views;

import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "shops", layout = MainAppLayout.class)
public class ShopsLayout extends AbstractView {

    public ShopsLayout(@Autowired MainAppLayout appLayout) {

    }

    @Override
    String getViewName() {
        return getClass().getName();
    }
}