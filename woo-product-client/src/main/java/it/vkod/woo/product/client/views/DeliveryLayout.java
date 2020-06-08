package it.vkod.woo.product.client.views;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
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
    private final String sessionId = VaadinSession.getCurrent().getSession().getId();

    public DeliveryLayout(final WooBasketServiceClient basketServiceClient, final MainAppLayout appLayout) {
        this.basketServiceClient = basketServiceClient;
        this.appLayout = appLayout;

        final BasketBilling[] billing = basketServiceClient.apiGetBasketBilling(sessionId);
        final BasketShipping[] delivery = basketServiceClient.apiGetBasketShipping(sessionId);

        BillingCard billingCard;
        DeliveryCard deliveryCard;

//        if (billing != null && delivery != null) {
//            billingCard = new BillingCard(
//                    sessionId,
//                    billing[0].getFirstName(),
//                    billing[0].getLastName(),
//                    billing[0].getEmail(),
//                    billing[0].getPhone(),
//                    billing[0].getAddress(),
//                    billing[0].getPostcode(),
//                    billing[0].getMunicipality(),
//                    billing[0].isDoNotCall()
//            );
//
//            deliveryCard = new DeliveryCard(
//                    sessionId,
//                    delivery[0].getFirstName(),
//                    delivery[0].getLastName(),
//                    delivery[0].getAddress(),
//                    delivery[0].getPostcode(),
//                    delivery[0].getMunicipality()
//            );
//        } else {
//            billingCard = new BillingCard();
//            deliveryCard = new DeliveryCard();
//        }

        billingCard = new BillingCard();
        deliveryCard = new DeliveryCard();

        layoutContent.add(billingCard);
        layoutContent.add(deliveryCard);

        Button save = new Button("Save");
        save.addClickListener(saveEvent(
                BasketBilling.builder()
                        .firstName(billingCard.getFirstName())
                        .lastName(billingCard.getLastName())
                        .phone(billingCard.getPhone())
                        .email(billingCard.getEmail())
                        .address(billingCard.getAddress())
                        .postcode(billingCard.getPostcode())
                        .municipality(billingCard.getMunicipality())
                        .build(),
                BasketShipping.builder()
                        .firstName(deliveryCard.getFirstName())
                        .lastName(deliveryCard.getLastName())
                        .address(deliveryCard.getAddress())
                        .postcode(deliveryCard.getPostcode())
                        .municipality(deliveryCard.getMunicipality())
                        .build()
        ));

        layoutContent.add(save);

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
            billing.setUserId(sessionId);
            basketServiceClient.apiAddBasketBilling(billing);
            delivery.setUserId(sessionId);
            basketServiceClient.apiAddBasketShipping(delivery);
            new Notification("Billing and delivery are saved.", 3000).open();
        };
    }

    @Override
    String getViewName() {
        return getClass().getName();
    }
}