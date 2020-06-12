package it.vkod.woo.product.client.components;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.data.binder.BindingValidationStatus;
import com.vaadin.flow.data.validator.StringLengthValidator;
import com.vaadin.flow.data.value.ValueChangeMode;
import it.vkod.woo.product.client.pojo.basket.req.BasketShipping;
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
public class DeliveryCard extends Div {

    @Getter
    private final Binder<BasketShipping> binder = new Binder<>();

    public DeliveryCard(BasketShipping basketShipping) {

        setClassName("card");

        Div cardContent = new Div();
        cardContent.setClassName("card-content");
        Span title = new Span("Delivery Address");
        title.setClassName("card-title");
        cardContent.add(title);

        FormLayout layoutWithBinder = new FormLayout();

        BasketShipping basketShippingBeingEdited = new BasketShipping();

        TextField firstName = new TextField();
        firstName.setValueChangeMode(ValueChangeMode.EAGER);
        TextField lastName = new TextField();
        lastName.setValueChangeMode(ValueChangeMode.EAGER);
        TextField addressLine1 = new TextField();
        addressLine1.setValueChangeMode(ValueChangeMode.EAGER);
        TextField addressLine2 = new TextField();
        addressLine2.setValueChangeMode(ValueChangeMode.EAGER);
        TextField municipality = new TextField();
        municipality.setValueChangeMode(ValueChangeMode.EAGER);
        TextField postcode = new TextField();
        postcode.setValueChangeMode(ValueChangeMode.EAGER);
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
                binder.setBean(basketShippingBeingEdited);
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

        if (basketShipping != null) binder.readBean(basketShipping);

        cardContent.add(layoutWithBinder);
        cardContent.add(actions);
        add(cardContent);
    }

}
