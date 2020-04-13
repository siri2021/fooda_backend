package it.vkod.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import it.vkod.services.WooMatchServiceClient;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

import static it.vkod.views.PaymentView.ROUTE;

@UIScope
@Route(value = ROUTE, layout = MasterView.class)
@SpringComponent
public class PaymentView extends Div {

    @Autowired
    private WooMatchServiceClient service;

    public final static String ROUTE = "payment";

    @PostConstruct
    public void init() {

        setClassName("container-fluid");

        Label label = new Label("Payment page .. ");
        add(label);


    }

}