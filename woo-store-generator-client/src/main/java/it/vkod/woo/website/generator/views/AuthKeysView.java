package it.vkod.woo.website.generator.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import javax.annotation.PostConstruct;

import static it.vkod.woo.website.generator.views.AuthKeysView.ROUTE;

@UIScope
@Route(value = ROUTE, layout = MasterView.class)
@SpringComponent
public class AuthKeysView extends Div {

    public final static String ROUTE = "keys";


    /**
     * MATERIAL DESIGN PATTERN
     * <div class="card-panel teal">
     *   <span class="white-text">I am a very simple card. I am good at containing small bits of information.
     *   I am convenient because I require little markup to use effectively. I am similar to what is called a panel in other frameworks.
     *   </span>
     * </div>
     */
    @PostConstruct
    public void init() {

        setClassName("container-fluid");

        Div keysDiv = new Div();
        keysDiv.setClassName("card");
        Div keysContentDiv = new Div();
        keysContentDiv.setClassName("card-panel");
        Label consumerKeyLabel = new Label("Consumer key is: 12312bn1rkb2h4v1j4vh12jb41k24b1jb2");
        Label consumerSecretLabel = new Label("Consumer secret is: wNr5w9ef8wer7wr678UGNwe78fw6fe7we6fWH8UD");
        keysContentDiv.add(consumerKeyLabel, consumerSecretLabel);
        keysDiv.add(keysContentDiv);
        add(keysDiv);

    }

}