package it.vkod.fooda.customer.frontend.views;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import it.vkod.fooda.customer.frontend.clients.WooBasketServiceClient;
import it.vkod.fooda.customer.frontend.clients.WooOrderServiceClient;
import it.vkod.fooda.customer.frontend.models.order.res.OrderResponse;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Route(value = "orders", layout = MainAppLayout.class)
@StyleSheet("https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css")
public class OrdersLayout extends VerticalLayout {

    private final transient WooBasketServiceClient basketServiceClient;
    private final transient WooOrderServiceClient orderServiceClient;

    private final String sessionId = VaadinSession.getCurrent().getSession().getId();
    private final VerticalLayout layoutContent = new VerticalLayout();
    private final transient List<OrderResponse> actualOrders;

    public OrdersLayout(final WooBasketServiceClient basketServiceClient, final WooOrderServiceClient orderServiceClient) {

        this.basketServiceClient = basketServiceClient;
        this.orderServiceClient = orderServiceClient;

        this.actualOrders = mapOrders();

        Notification.show("Your session ID is " + sessionId, 2000, Notification.Position.BOTTOM_CENTER).open();

        createOrdersDiv();

        add(layoutContent);

        setMargin(false);
        setPadding(false);
        setSpacing(false);
        setAlignItems(Alignment.STRETCH);
        setFlexGrow(1, layoutContent);
        setSizeFull();
    }

    private List<OrderResponse> mapOrders() {
        return Arrays
                .stream(basketServiceClient.apiGetBasketOrders(sessionId))
                .map(basketOrder -> orderServiceClient.apiGetOrderOne((int) basketOrder.getOrderId(), basketOrder.getStoreId()))
                .collect(Collectors.toList());
    }

    private void createOrdersDiv() {

        Grid<OrderResponse> grid = getGrid();
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.setSizeFull();
        grid.appendHeaderRow();
        grid.appendFooterRow();

        layoutContent.add(grid);
    }

    private Grid<OrderResponse> getGrid() {
        Grid<OrderResponse> grid = new Grid<>();
        grid.setItems(actualOrders);
        grid.addColumn(OrderResponse::getId).setHeader("Order");
        grid.addColumn(OrderResponse::getDate_created).setHeader("Date");
        grid.addColumn(OrderResponse::getTotal).setHeader("Total");
        grid.addColumn(OrderResponse::getStatus).setHeader("Status");
        return grid;
    }

}
