package it.vkod.woo.product.client.views;

import com.vaadin.flow.router.Route;

@Route(value = "payment", layout = MainAppLayout.class)
public class PaymentLayout extends AbstractView {
    @Override
    String getViewName() {
        return getClass().getName();
    }
}