package it.vkod.woo.product.client.views;

import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "basket", layout = MainAppLayout.class)
public class BasketLayout extends AbstractView {

    public BasketLayout(@Autowired MainAppLayout appLayout) {

    }

    @Override
    String getViewName() {
        return getClass().getName();
    }
}