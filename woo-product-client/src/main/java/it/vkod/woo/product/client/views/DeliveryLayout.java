package it.vkod.woo.product.client.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.data.binder.BindingValidationStatus;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.data.validator.StringLengthValidator;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.function.SerializablePredicate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import it.vkod.woo.product.client.clients.WooBasketServiceClient;
import it.vkod.woo.product.client.pojo.basket.req.BasketBilling;
import it.vkod.woo.product.client.pojo.basket.req.BasketShipping;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.stream.Collectors;

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

        final BasketShipping[] shippingList = basketServiceClient.apiGetBasketShipping(sessionId);
        final BasketBilling[] billingList = basketServiceClient.apiGetBasketBilling(sessionId);

        if (billingList.length > 0) {
            initBillingAddress(billingList[0], true);
        } else {
            initBillingAddress(new BasketBilling(), false);
        }

        if (shippingList.length > 0) {
            initDeliveryAddress(shippingList[0], true);
        }

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

    /**
     *  <div class="row">
     *     <div class="col s12 m6">
     *       <div class="card blue darken-1">
     *         <div class="card-content white-text">
     *           <span class="card-title">Card Title</span>
     *           <p>I am a very simple card. I am good at containing small bits of information.
     *           I am convenient because I require little markup to use effectively.</p>
     *         </div>
     *         <div class="card-action">
     *           <a href="#">This is a link</a>
     *           <a href="#">This is a link</a>
     *         </div>
     *       </div>
     *     </div>
     *   </div>
     * @param basketBilling Billing address can be different than delivery, up to customer's choice.
     * @param autoFill if customer wants to delivery to the same address with billing, this is set to true
     */
    private void initBillingAddress(final BasketBilling basketBilling, final boolean autoFill) {

        Div row = new Div();
        row.setClassName("row");

        Div col = new Div();
        col.setClassName("col s12 m6");

        Div card = new Div();
        card.setClassName("card blue darken-1");

        Div cardContent = new Div();
        cardContent.setClassName("card-content");
        Span title = new Span("Billing Address");
        title.setClassName("card-title");
        cardContent.add(title);

        FormLayout layoutWithBinder = new FormLayout();
        Binder<BasketBilling> binder = new Binder<>();

        // Create the fields
        TextField firstName = new TextField();
        firstName.setValueChangeMode(ValueChangeMode.EAGER);
        if (autoFill) firstName.setValue(basketBilling.getFirstName());

        TextField lastName = new TextField();
        lastName.setValueChangeMode(ValueChangeMode.EAGER);
        if (autoFill) lastName.setValue(basketBilling.getLastName());

        TextField phone = new TextField();
        phone.setValueChangeMode(ValueChangeMode.EAGER);
        if (autoFill) phone.setValue(basketBilling.getPhone());

        TextField email = new TextField();
        email.setValueChangeMode(ValueChangeMode.EAGER);
        if (autoFill) email.setValue(basketBilling.getEmail());

        TextField address = new TextField();
        address.setValueChangeMode(ValueChangeMode.EAGER);
        if (autoFill) address.setValue(basketBilling.getAddress());

        TextField postcode = new TextField();
        postcode.setValueChangeMode(ValueChangeMode.EAGER);
        if (autoFill) postcode.setValue(basketBilling.getPostcode());

        TextField municipality = new TextField();
        municipality.setValueChangeMode(ValueChangeMode.EAGER);
        if (autoFill) municipality.setValue(basketBilling.getMunicipality());

        Checkbox doNotCall = new Checkbox("Do not call");
        if (autoFill) doNotCall.setValue(basketBilling.isDoNotCall());

        Button saveButton = new Button("Save");
        Button resetButton = new Button("Reset");

        Checkbox autoFillShipping = new Checkbox("Also send products to this address.");

        layoutWithBinder.addFormItem(firstName, "First name");
        layoutWithBinder.addFormItem(lastName, "Last name");
        layoutWithBinder.addFormItem(email, "E-mail");
        FormLayout.FormItem phoneItem = layoutWithBinder.addFormItem(phone, "Phone");
        phoneItem.add(doNotCall);
        layoutWithBinder.addFormItem(address, "Address");
        layoutWithBinder.addFormItem(postcode, "Postcode");
        layoutWithBinder.addFormItem(municipality, "Municipality");
        layoutWithBinder.addFormItem(autoFillShipping, "Auto-generate");

        SerializablePredicate<String> phoneOrEmailPredicate = value -> !phone.getValue().trim().isEmpty() || !email.getValue().trim().isEmpty();

        // E-mail and phone have specific validators
        Binder.Binding<BasketBilling, String> emailBinding = binder.forField(email)
                .withValidator(phoneOrEmailPredicate, "Both phone and email cannot be empty")
                .withValidator(new EmailValidator("Incorrect email address"))
                .bind(BasketBilling::getEmail, BasketBilling::setEmail);

        Binder.Binding<BasketBilling, String> phoneBinding = binder.forField(phone)
                .withValidator(phoneOrEmailPredicate, "Both phone and email cannot be empty")
                .bind(BasketBilling::getPhone, BasketBilling::setPhone);

        // Trigger cross-field validation when the other field is changed
        email.addValueChangeListener(event -> emailBinding.validate());
        phone.addValueChangeListener(event -> phoneBinding.validate());

        // First name and last name are required fields
        firstName.setRequiredIndicatorVisible(true);
        lastName.setRequiredIndicatorVisible(true);
        address.setRequiredIndicatorVisible(true);
        postcode.setRequiredIndicatorVisible(true);

        binder.forField(firstName)
                .withValidator(new StringLengthValidator("Please add the first name", 1, null))
                .bind(BasketBilling::getFirstName, BasketBilling::setFirstName);
        binder.forField(lastName)
                .withValidator(new StringLengthValidator("Please add the last name", 1, null))
                .bind(BasketBilling::getLastName, BasketBilling::setLastName);
        binder.forField(address)
                .withValidator(new StringLengthValidator("Please add address", 1, null))
                .bind(BasketBilling::getAddress, BasketBilling::setAddress);
        binder.forField(postcode)
                .withValidator(new StringLengthValidator("Please add a postcode", 1, null))
                .bind(BasketBilling::getPostcode, BasketBilling::setPostcode);
        binder.forField(municipality)
                .withValidator(new StringLengthValidator("Please add a municipality", 1, null))
                .bind(BasketBilling::getMunicipality, BasketBilling::setMunicipality);

        // doNotCall don't need any special validators
        binder.bind(doNotCall, BasketBilling::isDoNotCall, BasketBilling::setDoNotCall);

        // Click listeners for the buttons
        saveButton.addClickListener(event -> {
            if (binder.writeBeanIfValid(basketBilling)) {
                basketBilling.setUserId(sessionId);
                basketServiceClient.apiAddBasketBilling(basketBilling);
                if (autoFillShipping.getValue().equals(true)) {
                    basketServiceClient.apiAddBasketShipping(mapAddresses(basketBilling));
                } else {
                    initDeliveryAddress(new BasketShipping(), false);
                }
                new Notification("New billing address is saved.", 3000).open();
            } else {
                BinderValidationStatus<BasketBilling> validate = binder.validate();
                String errorText = validate.getFieldValidationStatuses()
                        .stream().filter(BindingValidationStatus::isError)
                        .map(BindingValidationStatus::getMessage)
                        .map(Optional::get).distinct()
                        .collect(Collectors.joining(", "));
                new Notification("There are errors: " + errorText, 4000).open();
            }
        });

        resetButton.addClickListener(event -> {
            // clear fields by setting null
            binder.readBean(null);
            doNotCall.setValue(false);
        });

        cardContent.add(layoutWithBinder);

        Div cardActions = new Div();
        cardActions.setClassName("card-actions");
        cardActions.add(resetButton, saveButton);

        card.add(cardContent, cardActions);

        layoutContent.add(card);
    }

    private void initDeliveryAddress(final BasketShipping contact, final boolean autoFill) {

        Div row = new Div();
        row.setClassName("row");

        Div col = new Div();
        col.setClassName("col s12 m6");

        Div card = new Div();
        card.setClassName("card");

        Div cardContent = new Div();
        cardContent.setClassName("card-content");
        Span title = new Span("Delivery Address");
        title.setClassName("card-title");
        cardContent.add(title);

        FormLayout layoutWithBinder = new FormLayout();
        Binder<BasketShipping> binder = new Binder<>();

        // Create the fields
        TextField firstName = new TextField();
        firstName.setValueChangeMode(ValueChangeMode.EAGER);
        if (autoFill) firstName.setValue(contact.getFirstName());

        TextField lastName = new TextField();
        lastName.setValueChangeMode(ValueChangeMode.EAGER);
        if (autoFill) lastName.setValue(contact.getLastName());

        TextField address = new TextField();
        address.setValueChangeMode(ValueChangeMode.EAGER);
        if (autoFill) address.setValue(contact.getAddress());

        TextField postcode = new TextField();
        postcode.setValueChangeMode(ValueChangeMode.EAGER);
        if (autoFill) postcode.setValue(contact.getPostcode());

        TextField municipality = new TextField();
        municipality.setValueChangeMode(ValueChangeMode.EAGER);
        if (autoFill) municipality.setValue(contact.getMunicipality());

        Button saveButton = new Button("Save");
        Button resetButton = new Button("Reset");

        layoutWithBinder.addFormItem(firstName, "First name");
        layoutWithBinder.addFormItem(lastName, "Last name");
        layoutWithBinder.addFormItem(address, "Address");
        layoutWithBinder.addFormItem(postcode, "Postcode");
        layoutWithBinder.addFormItem(municipality, "Municipality");

        // First name and last name are required fields
        firstName.setRequiredIndicatorVisible(true);
        lastName.setRequiredIndicatorVisible(true);
        address.setRequiredIndicatorVisible(true);
        postcode.setRequiredIndicatorVisible(true);

        binder.forField(firstName)
                .withValidator(new StringLengthValidator("Please add the first name", 1, null))
                .bind(BasketShipping::getFirstName, BasketShipping::setFirstName);
        binder.forField(lastName)
                .withValidator(new StringLengthValidator("Please add the last name", 1, null))
                .bind(BasketShipping::getLastName, BasketShipping::setLastName);
        binder.forField(address)
                .withValidator(new StringLengthValidator("Please add address", 1, null))
                .bind(BasketShipping::getAddress, BasketShipping::setAddress);
        binder.forField(postcode)
                .withValidator(new StringLengthValidator("Please add a postcode", 1, null))
                .bind(BasketShipping::getPostcode, BasketShipping::setPostcode);
        binder.forField(municipality)
                .withValidator(new StringLengthValidator("Please add a municipality", 1, null))
                .bind(BasketShipping::getMunicipality, BasketShipping::setMunicipality);

        saveButton.getStyle().set("width", "41%");
        saveButton.addClickListener(event -> {
            if (binder.writeBeanIfValid(contact)) {
                contact.setUserId(sessionId);
                basketServiceClient.apiAddBasketShipping(contact);
                new Notification("New shipping address is saved.", 3000).open();
            } else {
                BinderValidationStatus<BasketShipping> validate = binder.validate();
                String errorText = validate.getFieldValidationStatuses()
                        .stream().filter(BindingValidationStatus::isError)
                        .map(BindingValidationStatus::getMessage)
                        .map(Optional::get).distinct()
                        .collect(Collectors.joining(", "));
                new Notification("There are errors: " + errorText, 4000).open();
            }
        });

        resetButton.addClickListener(event -> binder.readBean(null));

        cardContent.add(layoutWithBinder);

        Div cardActions = new Div();
        cardActions.setClassName("card-actions");
        cardActions.add(resetButton, saveButton);

        card.add(cardContent, cardActions);

        layoutContent.add(card);
    }

    @Override
    String getViewName() {
        return getClass().getName();
    }
}