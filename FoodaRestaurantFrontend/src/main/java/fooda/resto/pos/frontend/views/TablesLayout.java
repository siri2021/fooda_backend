package fooda.resto.pos.frontend.views;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Route(value = "tables", layout = MainAppLayout.class)
@StyleSheet("https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css")
@CssImport("./styles/cards.css")
public class TablesLayout extends AbstractView {

    private final MainAppLayout app;

    private final Div container = new Div();

    public TablesLayout(MainAppLayout app) {
        this.app = app;
        container.setClassName("cards-container");

        add(new VerticalLayout(container));
    }

    @Override
    String getViewName() {
        return getClass().getName();
    }

}
