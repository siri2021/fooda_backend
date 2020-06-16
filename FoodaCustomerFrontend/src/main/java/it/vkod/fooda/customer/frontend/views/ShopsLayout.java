package it.vkod.fooda.customer.frontend.views;

import com.vaadin.flow.router.Route;

@Route(value = "shops", layout = MainAppLayout.class)
public class ShopsLayout extends AbstractView {

    private final transient MainAppLayout app;


    public ShopsLayout(final MainAppLayout app) {
        this.app = app;



    }

    @Override
    String getViewName() {
        return getClass().getName();
    }
}