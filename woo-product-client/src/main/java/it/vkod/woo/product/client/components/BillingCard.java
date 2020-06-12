package it.vkod.woo.product.client.components;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.data.binder.BindingValidationStatus;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.data.validator.StringLengthValidator;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.function.SerializablePredicate;
import it.vkod.woo.product.client.pojo.basket.req.BasketBilling;
import lombok.Getter;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <div class="row">
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
 */
@Tag("div")
public class BillingCard extends Div {

    @Getter
    private final Binder<BasketBilling> binder = new Binder<>();

    public BillingCard(BasketBilling basketShipping) {

        setClassName("card");

        Div cardContent = new Div();
        cardContent.setClassName("card-content");
        Span title = new Span("Billing Address");
        title.setClassName("card-title");
        cardContent.add(title);

        FormLayout layoutWithBinder = new FormLayout();

        BasketBilling basketBillingBeingEdited = new BasketBilling();

        TextField firstName = new TextField();
        firstName.setValueChangeMode(ValueChangeMode.EAGER);
        TextField lastName = new TextField();
        lastName.setValueChangeMode(ValueChangeMode.EAGER);
        TextField phone = new TextField();
        phone.setValueChangeMode(ValueChangeMode.EAGER);
        EmailField email = new EmailField();
        email.setValueChangeMode(ValueChangeMode.EAGER);
        Checkbox doNotCall = new Checkbox("Do not call");
        TextField addressLine1 = new TextField();
        addressLine1.setValueChangeMode(ValueChangeMode.EAGER);
        TextField addressLine2 = new TextField();
        addressLine2.setValueChangeMode(ValueChangeMode.EAGER);
        TextField municipality = new TextField();
        municipality.setValueChangeMode(ValueChangeMode.EAGER);
        TextField postcode = new TextField();
        postcode.setValueChangeMode(ValueChangeMode.EAGER);

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
                binder.setBean(basketBillingBeingEdited);
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

        if (basketShipping != null) binder.readBean(basketShipping);

        cardContent.add(layoutWithBinder);
        cardContent.add(actions);
        add(cardContent);
    }

}
