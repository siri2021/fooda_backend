package it.vkod.woo.website.generator.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import javax.annotation.PostConstruct;

import static it.vkod.woo.website.generator.views.SiteSettingsView.ROUTE;

@UIScope
@Route(value = ROUTE, layout = MasterView.class)
@SpringComponent
public class SiteSettingsView extends Div {

    public final static String ROUTE = "settings";

    @PostConstruct
    public void init() {

        setClassName("container-fluid");

        Label label = new Label("Address page .. ");
        add(label);
    }

}
