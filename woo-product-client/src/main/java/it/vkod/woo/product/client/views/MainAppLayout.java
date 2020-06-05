package it.vkod.woo.product.client.views;

import com.github.appreciated.app.layout.addons.notification.DefaultNotificationHolder;
import com.github.appreciated.app.layout.addons.notification.component.NotificationButton;
import com.github.appreciated.app.layout.component.appbar.AppBarBuilder;
import com.github.appreciated.app.layout.component.applayout.LeftLayouts;
import com.github.appreciated.app.layout.component.builder.AppLayoutBuilder;
import com.github.appreciated.app.layout.component.menu.left.builder.LeftAppMenuBuilder;
import com.github.appreciated.app.layout.component.menu.left.items.LeftNavigationItem;
import com.github.appreciated.app.layout.component.router.AppLayoutRouterLayout;
import com.github.appreciated.app.layout.entity.DefaultBadgeHolder;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.spring.annotation.UIScope;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Push
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
@PWA(name = "Fooda WebApp", shortName = "Fooda")
@Component
@UIScope // optional but useful; allows access to this instance from views, see View1.
public class MainAppLayout extends AppLayoutRouterLayout<LeftLayouts.LeftResponsive> {
    private DefaultNotificationHolder notifications = new DefaultNotificationHolder();
    private DefaultBadgeHolder badge = new DefaultBadgeHolder(5);

    public MainAppLayout() {
        notifications.addClickListener(notification -> {/* ... */});

        final LeftNavigationItem search = new LeftNavigationItem("Search", VaadinIcon.SEARCH.create(), SearchLayout.class);
        final LeftNavigationItem shops = new LeftNavigationItem("Shops", VaadinIcon.SEARCH.create(), SearchLayout.class);
        final LeftNavigationItem delivery = new LeftNavigationItem("Delivery", VaadinIcon.CAR.create(), DeliveryLayout.class);
        final LeftNavigationItem payment = new LeftNavigationItem("Payment", VaadinIcon.HOME.create(), PaymentLayout.class);
        final LeftNavigationItem basket = new LeftNavigationItem("Basket", VaadinIcon.CART.create(), BasketLayout.class);
        badge.bind(basket.getBadge());
        final LeftNavigationItem orders = new LeftNavigationItem("Orders", VaadinIcon.TABLE.create(), OrdersLayout.class);
        init(AppLayoutBuilder.get(LeftLayouts.LeftResponsive.class)
                .withTitle("May the Food be with you!")
                .withAppBar(AppBarBuilder.get().add(new NotificationButton<>(VaadinIcon.BELL, notifications))
                        .build())
                .withAppMenu(LeftAppMenuBuilder.get().add(search, shops, delivery, payment, basket, orders)
                        .build())
                .build());
    }

    public DefaultNotificationHolder getNotifications() {
        return notifications;
    }

    public DefaultBadgeHolder getBadge() {
        return badge;
    }
}
