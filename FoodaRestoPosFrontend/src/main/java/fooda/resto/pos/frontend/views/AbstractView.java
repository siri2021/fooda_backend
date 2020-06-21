package fooda.resto.pos.frontend.views;

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

        setMargin(false);
        setSpacing(false);
        setAlignItems(Alignment.CENTER);
        setFlexGrow(1, layout);
    }

    abstract String getViewName();
}