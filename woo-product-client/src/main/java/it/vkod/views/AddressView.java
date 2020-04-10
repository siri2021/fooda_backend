package it.vkod.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import it.vkod.services.WooMatchService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

import static it.vkod.views.AddressView.ROUTE;

@UIScope
@Route(value = ROUTE, layout = MasterView.class)
@SpringComponent
public class AddressView extends Div {

    @Autowired
    private WooMatchService service;

    public final static String ROUTE = "address";

    @PostConstruct
    public void init() {

        setClassName("container-fluid");

        Label label = new Label("Address page .. ");
        add(label);
    }

}
