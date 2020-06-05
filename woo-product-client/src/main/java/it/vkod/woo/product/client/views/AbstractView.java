package it.vkod.woo.product.client.views;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;

abstract class AbstractView extends HorizontalLayout {
	
    public AbstractView() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        layout.setMargin(false);
        setMargin(false);

        add(getProgress());

        setSizeFull();
        getElement().getStyle().set("overflow", "auto");
    }

    public ProgressBar getProgress() {

        final String view = getViewName();

        ProgressBar progress = new ProgressBar();
        progress.setMin(0);
        progress.setMax(100);
        progress.setHeight("30px");
        progress.setWidthFull();
        progress.getStyle()
                .set("position", "absolute")
                .set("bottom", "0");

        if (view.equals("") || view.equals("shops")) {
            progress.setValue(25);
        } else if (view.equals("basket")) {
            progress.setValue(50);
        } else if (view.equals("delivery")) {
            progress.setValue(75);
        } else if (view.equals("payment")) {
            progress.setValue(100);
        }

        return progress;
    }

    abstract String getViewName();
}