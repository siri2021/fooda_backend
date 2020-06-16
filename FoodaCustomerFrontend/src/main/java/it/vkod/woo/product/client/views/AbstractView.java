package it.vkod.woo.product.client.views;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import lombok.extern.slf4j.Slf4j;

@Slf4j
abstract class AbstractView extends HorizontalLayout {

    public AbstractView() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        layout.setMargin(false);
        setMargin(false);

        setSizeFull();
        getElement().getStyle().set("overflow", "auto");
    }

    abstract String getViewName();
}