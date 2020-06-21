package it.vkod.fooda.customer.frontend.views;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.data.binder.BindingValidationStatus;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.data.validator.StringLengthValidator;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.function.SerializablePredicate;
import com.vaadin.flow.router.Route;
import it.vkod.fooda.customer.frontend.clients.FoodaBasketClient;
import it.vkod.fooda.customer.frontend.models.basket.req.BasketBilling;
import it.vkod.fooda.customer.frontend.models.basket.req.BasketShipping;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Route(value = "delivery", layout = MainAppLayout.class)
@StyleSheet("https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css")
public class DeliveryLayout extends AbstractView {

    private final transient FoodaBasketClient basketServiceClient;
    private final VerticalLayout layout = new VerticalLayout();
    private final MainAppLayout app;

    public DeliveryLayout(final FoodaBasketClient basketServiceClient, final MainAppLayout app) {
        this.basketServiceClient = basketServiceClient;
        this.app = app;

        addBillingCard();
        addShippingCard();

//        layout.add(new AddressCard(new BasketAddressRequest()).div());
        add(layout);
    }

    private void addBillingCard() {

//        final BasketBilling basketBillingBeingEdited = Objects.requireNonNullElse(basketServiceClient.apiGetBasketBilling(app.getSession().getId()), new BasketBilling[]{})[0];

        final BasketBilling basketBillingBeingEdited = new BasketBilling();

        final Binder<BasketBilling> binder = new Binder<>();

        Div card = new Div();
        card.setClassName("card");

        Div cardContent = new Div();
        cardContent.setClassName("card-content");
        Span title = new Span("Billing Address");
        title.setClassName("card-title");
        cardContent.add(title);

        FormLayout layoutWithBinder = new FormLayout();

        TextField firstName = new TextField();
        firstName.setValueChangeMode(ValueChangeMode.EAGER);
//        firstName.setValue(basketBillingBeingEdited.getFirstName());
        TextField lastName = new TextField();
        lastName.setValueChangeMode(ValueChangeMode.EAGER);
//        lastName.setValue(basketBillingBeingEdited.getLastName());
        TextField phone = new TextField();
        phone.setValueChangeMode(ValueChangeMode.EAGER);
//        phone.setValue(basketBillingBeingEdited.getPhone());
        EmailField email = new EmailField();
        email.setValueChangeMode(ValueChangeMode.EAGER);
//        email.setValue(basketBillingBeingEdited.getEmail());
        Checkbox doNotCall = new Checkbox("Do not call");
        TextField addressLine1 = new TextField();
        addressLine1.setValueChangeMode(ValueChangeMode.EAGER);
//        addressLine1.setValue(basketBillingBeingEdited.getAddress());
        TextField addressLine2 = new TextField();
        addressLine2.setValueChangeMode(ValueChangeMode.EAGER);
        TextField municipality = new TextField();
        municipality.setValueChangeMode(ValueChangeMode.EAGER);
//        municipality.setValue(basketBillingBeingEdited.getMunicipality());
        TextField postcode = new TextField();
        postcode.setValueChangeMode(ValueChangeMode.EAGER);
//        postcode.setValue(basketBillingBeingEdited.getPostcode());

        Label infoLabel = new Label();
        NativeButton save = new NativeButton("Save");
        NativeButton reset = new NativeButton("Reset");

        layoutWithBinder.addFormItem(firstName, "First name");
        layoutWithBinder.addFormItem(lastName, "Last name");
        layoutWithBinder.addFormItem(email, "E-mail");
        FormLayout.FormItem phoneItem = layoutWithBinder.addFormItem(phone, "Phone");
        phoneItem.add(doNotCall);
        layoutWithBinder.addFormItem(addressLine1, "Address Line 1");
        layoutWithBinder.addFormItem(addressLine2, "Address Line 2");
        layoutWithBinder.addFormItem(municipality, "Municipality");
        layoutWithBinder.addFormItem(postcode, "Postcode");

        HorizontalLayout actions = new HorizontalLayout();
        actions.add(save, reset);
        save.getStyle().set("margin-right", "10px");

        SerializablePredicate<String> phoneOrEmailPredicate = value -> !phone
                .getValue().trim().isEmpty()
                || !email.getValue().trim().isEmpty();

        // E-mail and phone have specific validators
        Binder.Binding<BasketBilling, String> emailBinding = binder.forField(email)
                .withValidator(phoneOrEmailPredicate,
                        "Both phone and email cannot be empty")
                .withValidator(new EmailValidator("Incorrect email address"))
                .bind(BasketBilling::getEmail, BasketBilling::setEmail);

        Binder.Binding<BasketBilling, String> phoneBinding = binder.forField(phone)
                .withValidator(phoneOrEmailPredicate,
                        "Both phone and email cannot be empty")
                .bind(BasketBilling::getPhone, BasketBilling::setPhone);

// Trigger cross-field validation when the other field is changed
        email.addValueChangeListener(event -> phoneBinding.validate());
        phone.addValueChangeListener(event -> emailBinding.validate());

        firstName.setRequiredIndicatorVisible(true);
        lastName.setRequiredIndicatorVisible(true);

        binder.forField(firstName)
                .withValidator(new StringLengthValidator(
                        "Please add the first name", 1, null))
                .bind(BasketBilling::getFirstName, BasketBilling::setFirstName);
        binder.forField(lastName)
                .withValidator(new StringLengthValidator(
                        "Please add the last name", 1, null))
                .bind(BasketBilling::getLastName, BasketBilling::setLastName);
        binder.forField(addressLine1)
                .withValidator(new StringLengthValidator(
                        "Please add the address", 1, null))
                .bind(BasketBilling::getAddress, BasketBilling::setAddress);
        binder.forField(municipality)
                .withValidator(new StringLengthValidator(
                        "Please add the municipality", 1, null))
                .bind(BasketBilling::getMunicipality, BasketBilling::setMunicipality);
        binder.forField(postcode)
                .withValidator(new StringLengthValidator(
                        "Please add the postcode", 1, null))
                .bind(BasketBilling::getPostcode, BasketBilling::setPostcode);

        save.addClickListener(event -> {
            if (binder.writeBeanIfValid(basketBillingBeingEdited)) {
                basketBillingBeingEdited.setUserId(app.getSession().getId());
                basketBillingBeingEdited.setBillingId(UUID.randomUUID());
                basketServiceClient.apiAddBasketBilling(basketBillingBeingEdited);
                infoLabel.setText("Saved bean values: " + basketBillingBeingEdited);
            } else {
                BinderValidationStatus<BasketBilling> validate = binder.validate();
                String errorText = validate.getFieldValidationStatuses()
                        .stream().filter(BindingValidationStatus::isError)
                        .map(BindingValidationStatus::getMessage)
                        .map(Optional::get).distinct()
                        .collect(Collectors.joining(", "));
                infoLabel.setText("There are errors: " + errorText);
            }
        });
        reset.addClickListener(event -> {
            // clear fields by setting null
            binder.readBean(null);
            infoLabel.setText("");
            doNotCall.setValue(false);
        });

        layoutWithBinder.setResponsiveSteps(
                new FormLayout.ResponsiveStep("25em", 1),
                new FormLayout.ResponsiveStep("32em", 2),
                new FormLayout.ResponsiveStep("40em", 3));

        cardContent.add(layoutWithBinder);
        cardContent.add(actions);
        card.add(cardContent);
        layout.add(card);
    }

    private void addShippingCard() {

//        BasketShipping basketShippingBeingEdited = Objects.requireNonNullElse(basketServiceClient.apiGetBasketShipping(app.getSession().getId()), new BasketShipping[]{})[0];

        BasketShipping basketShippingBeingEdited = new BasketShipping();

        final Binder<BasketShipping> binder = new Binder<>();

        Div card = new Div();
        card.setClassName("card");

        Div cardContent = new Div();
        cardContent.setClassName("card-content");
        Span title = new Span("Delivery Address");
        title.setClassName("card-title");
        cardContent.add(title);

        FormLayout layoutWithBinder = new FormLayout();

        TextField firstName = new TextField();
        firstName.setValueChangeMode(ValueChangeMode.EAGER);
//        firstName.setValue(basketShippingBeingEdited.getFirstName());
        TextField lastName = new TextField();
        lastName.setValueChangeMode(ValueChangeMode.EAGER);
//        lastName.setValue(basketShippingBeingEdited.getLastName());
        TextField addressLine1 = new TextField();
        addressLine1.setValueChangeMode(ValueChangeMode.EAGER);
//        addressLine1.setValue(basketShippingBeingEdited.getAddress());
        TextField addressLine2 = new TextField();
        addressLine2.setValueChangeMode(ValueChangeMode.EAGER);
        TextField municipality = new TextField();
        municipality.setValueChangeMode(ValueChangeMode.EAGER);
//        municipality.setValue(basketShippingBeingEdited.getMunicipality());
        TextField postcode = new TextField();
        postcode.setValueChangeMode(ValueChangeMode.EAGER);
//        postcode.setValue(basketShippingBeingEdited.getPostcode());
        DatePicker deliveryDate = new DatePicker();
        TimePicker deliveryTime = new TimePicker();
        Checkbox doNotCall = new Checkbox("Do not call");
        Label infoLabel = new Label();
        NativeButton save = new NativeButton("Save");
        NativeButton reset = new NativeButton("Reset");

        layoutWithBinder.addFormItem(firstName, "First name");
        layoutWithBinder.addFormItem(lastName, "Last name");
        layoutWithBinder.addFormItem(deliveryDate, "Delivery Date");
        layoutWithBinder.addFormItem(deliveryTime, "Delivery Time");
        layoutWithBinder.addFormItem(addressLine1, "Address Line 1");
        layoutWithBinder.addFormItem(addressLine2, "Address Line 2");
        layoutWithBinder.addFormItem(municipality, "Municipality");
        layoutWithBinder.addFormItem(postcode, "Postcode");

        HorizontalLayout actions = new HorizontalLayout();
        actions.add(save, reset);
        save.getStyle().set("margin-right", "10px");

        firstName.setRequiredIndicatorVisible(true);
        lastName.setRequiredIndicatorVisible(true);

        binder.forField(firstName)
                .withValidator(new StringLengthValidator(
                        "Please add the first name", 1, null))
                .bind(BasketShipping::getFirstName, BasketShipping::setFirstName);
        binder.forField(lastName)
                .withValidator(new StringLengthValidator(
                        "Please add the last name", 1, null))
                .bind(BasketShipping::getLastName, BasketShipping::setLastName);
        binder.forField(addressLine1)
                .withValidator(new StringLengthValidator(
                        "Please add the address", 1, null))
                .bind(BasketShipping::getAddress, BasketShipping::setAddress);
        binder.forField(municipality)
                .withValidator(new StringLengthValidator(
                        "Please add the municipality", 1, null))
                .bind(BasketShipping::getMunicipality, BasketShipping::setMunicipality);
        binder.forField(postcode)
                .withValidator(new StringLengthValidator(
                        "Please add the postcode", 1, null))
                .bind(BasketShipping::getPostcode, BasketShipping::setPostcode);

// Click listeners for the buttons
        save.addClickListener(event -> {
            if (binder.writeBeanIfValid(basketShippingBeingEdited)) {
                basketShippingBeingEdited.setUserId(app.getSession().getId());
                basketShippingBeingEdited.setShippingId(UUID.randomUUID());
                basketServiceClient.apiAddBasketShipping(basketShippingBeingEdited);
                infoLabel.setText("Saved bean values: " + basketShippingBeingEdited);
            } else {
                BinderValidationStatus<BasketShipping> validate = binder.validate();
                String errorText = validate.getFieldValidationStatuses()
                        .stream().filter(BindingValidationStatus::isError)
                        .map(BindingValidationStatus::getMessage)
                        .map(Optional::get).distinct()
                        .collect(Collectors.joining(", "));
                infoLabel.setText("There are errors: " + errorText);
            }
        });
        reset.addClickListener(event -> {
            // clear fields by setting null
            binder.readBean(null);
            infoLabel.setText("");
            doNotCall.setValue(false);
        });

        layoutWithBinder.setResponsiveSteps(
                new FormLayout.ResponsiveStep("25em", 1),
                new FormLayout.ResponsiveStep("32em", 2),
                new FormLayout.ResponsiveStep("40em", 3));

        cardContent.add(layoutWithBinder);
        cardContent.add(actions);
        card.add(cardContent);
        layout.add(card);
    }

    private BasketShipping mapAddresses(final BasketBilling basketBilling) {
        return new BasketShipping(
                UUID.randomUUID(),
                basketBilling.getFirstName(),
                basketBilling.getLastName(),
                basketBilling.getUserId(),
                basketBilling.getAddress(),
                basketBilling.getPostcode(),
                basketBilling.getMunicipality());
    }

    @Override
    String getViewName() {
        return getClass().getName();
    }
}