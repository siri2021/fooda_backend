package it.vkod.woo.product.client.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import it.vkod.woo.product.client.payloads.authRequest.LoginRequest;
import it.vkod.woo.product.client.services.WooUserServiceClient;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

import static it.vkod.woo.product.client.views.LoginView.ROUTE;

@UIScope
@Route(value = ROUTE, layout = MasterView.class)
@SpringComponent
public class LoginView extends Div {

    @Autowired
    private WooUserServiceClient service;

    public final static String ROUTE = "";

    @PostConstruct
    public void init() {

        setClassName("container-fluid");

        LoginForm loginForm = new LoginForm();
        loginForm.addLoginListener(userData -> {
            boolean isAuthenticated = service.login(new LoginRequest(userData.getUsername(), userData.getPassword()));
            if (isAuthenticated) {
                UI.getCurrent().navigate("search");
            } else {
                loginForm.setError(true);
            }
        });

        add(loginForm);

    }

}
