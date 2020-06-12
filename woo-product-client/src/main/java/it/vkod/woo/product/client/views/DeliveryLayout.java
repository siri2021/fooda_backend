package it.vkod.woo.product.client.views;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.server.WrappedSession;
import it.vkod.woo.product.client.clients.WooBasketServiceClient;
import it.vkod.woo.product.client.components.BillingCard;
import it.vkod.woo.product.client.components.DeliveryCard;
import it.vkod.woo.product.client.pojo.basket.req.BasketBilling;
import it.vkod.woo.product.client.pojo.basket.req.BasketShipping;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Route(value = "delivery", layout = MainAppLayout.class)
@StyleSheet("https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css")
public class DeliveryLayout extends AbstractView {

    private final transient WooBasketServiceClient basketServiceClient;
    private final MainAppLayout appLayout;
    private final VerticalLayout layoutContent = new VerticalLayout();
    final WrappedSession session = VaadinSession.getCurrent().getSession();

    public DeliveryLayout(final WooBasketServiceClient basketServiceClient, final MainAppLayout appLayout) {
        this.basketServiceClient = basketServiceClient;
        this.appLayout = appLayout;

//        final BasketBilling[] billing = basketServiceClient.apiGetBasketBilling(session.getId());
//        final BasketShipping[] delivery = basketServiceClient.apiGetBasketShipping(session.getId());

        BillingCard billingCard = new BillingCard(null);
        DeliveryCard deliveryCard = new DeliveryCard(null);

        layoutContent.add(billingCard);
        layoutContent.add(deliveryCard);

        Button save = new Button("Save");
        save.addClickListener(saveEvent(billingCard.getBinder().getBean(), deliveryCard.getBinder().getBean()));
        save.setWidthFull();

        layoutContent.add(save);

        setMargin(false);
        setPadding(false);
        setSpacing(false);
        setFlexGrow(1, layoutContent);

        add(layoutContent);
    }

    private BasketShipping mapAddresses(final BasketBilling basketBilling) {
        return BasketShipping.builder()
                .firstName(basketBilling.getFirstName())
                .lastName(basketBilling.getLastName())
                .userId(basketBilling.getUserId())
                .address(basketBilling.getAddress())
                .postcode(basketBilling.getPostcode())
                .municipality(basketBilling.getMunicipality())
                .address(basketBilling.getAddress())
                .build();
    }


    private ComponentEventListener<ClickEvent<Button>> saveEvent(BasketBilling billing, BasketShipping delivery) {
        return event -> {
            billing.setUserId(session.getId());
            basketServiceClient.apiAddBasketBilling(billing);
            delivery.setUserId(session.getId());
            basketServiceClient.apiAddBasketShipping(delivery);
            new Notification("Billing and delivery are saved.", 3000).open();
        };
    }

    @Override
    String getViewName() {
        return getClass().getName();
    }
}