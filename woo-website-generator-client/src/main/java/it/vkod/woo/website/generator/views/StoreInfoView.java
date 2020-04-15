package it.vkod.woo.website.generator.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import javax.annotation.PostConstruct;

import static it.vkod.woo.website.generator.views.StoreInfoView.ROUTE;

@UIScope
@Route(value = ROUTE, layout = MasterView.class)
@SpringComponent
public class StoreInfoView extends Div {

    public final static String ROUTE = "store";

    private final String BG_COLOR = "#FF5733";
    private final String TEXT_COLOR = "white";
    private final String BUTTON_HEIGHT = "48px";

    @PostConstruct
    public void init() {

        setClassName("container-fluid");


    }

}
