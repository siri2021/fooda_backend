package it.vkod.woo.product.client.views;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@Route(value = "shops", layout = MainAppLayout.class)
public class ShopsLayout extends AbstractView {

    private final String sessionId = VaadinSession.getCurrent().getSession().getId();
    private final transient MainAppLayout appLayout;

    public ShopsLayout(final MainAppLayout appLayout) {
        this.appLayout = appLayout;
        Notification.show("Your session ID is " + sessionId, 2000, Notification.Position.BOTTOM_CENTER).open();

    }

    @Override
    String getViewName() {
        return getClass().getName();
    }
}