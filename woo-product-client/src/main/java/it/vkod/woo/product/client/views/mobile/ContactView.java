package it.vkod.woo.product.client.views.mobile;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.data.binder.BindingValidationStatus;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.data.validator.StringLengthValidator;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.function.SerializablePredicate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import it.vkod.woo.product.client.clients.WooBasketServiceClient;
import it.vkod.woo.product.client.pojo.basket.req.BasketBilling;
import it.vkod.woo.product.client.pojo.basket.req.BasketShipping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import static it.vkod.woo.product.client.views.mobile.ContactView.ROUTE;

@Slf4j
@UIScope
@Route(value = ROUTE, layout = MasterView.class)
@SpringComponent
@CssImport("./styles/responsive.css")
public class ContactView extends Div {

    @Autowired
    private WooBasketServiceClient basketServiceClient;

    private static final String TOKEN_COOKIE = "token";
    public final static String ROUTE = "mobile-delivery";
    private final String BG_COLOR = "#3333FF";
    private final String TEXT_COLOR = "white";

    @PostConstruct
    public void init() {

        final BasketShipping[] shippingList = basketServiceClient.apiGetBasketShipping(getTokenCookie().getValue());
        final BasketBilling[] billingList = basketServiceClient.apiGetBasketBilling(getTokenCookie().getValue());

        if (billingList.length > 0) {
            createBillingAddressForm(billingList[0], true);
        } else {
            createBillingAddressForm(new BasketBilling(), false);
        }

        if (shippingList.length > 0) {
            createShippingAddressForm(shippingList[0], true);
        }
    }

    private BasketShipping mapShippingWithBillingAddress(final BasketBilling basketBilling) {
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

    private void createBillingAddressForm(final BasketBilling basketBilling, final boolean autoFill) {

        Div addressFormDiv = new Div();
        addressFormDiv.setText("billing address".toUpperCase());
        addressFormDiv.setClassName("card");
        addressFormDiv.getStyle().set("margin-left", "5px").set("margin-right", "5px");

        FormLayout layoutWithBinder = new FormLayout();
        layoutWithBinder.getStyle().set("margin-left", "5px").set("margin-right", "5px");
        Binder<BasketBilling> binder = new Binder<>();

        // Create the fields
        TextField firstName = new TextField();
        firstName.getStyle().set("background", TEXT_COLOR).set("color", "black").set("width", "100%");
        firstName.setValueChangeMode(ValueChangeMode.EAGER);
        if (autoFill) firstName.setValue(basketBilling.getFirstName());

        TextField lastName = new TextField();
        lastName.getStyle().set("background", TEXT_COLOR).set("color", "black").set("width", "100%");
        lastName.setValueChangeMode(ValueChangeMode.EAGER);
        if (autoFill) lastName.setValue(basketBilling.getLastName());

        TextField phone = new TextField();
        phone.getStyle().set("background", TEXT_COLOR).set("color", "black").set("width", "100%");
        phone.setValueChangeMode(ValueChangeMode.EAGER);
        if (autoFill) phone.setValue(basketBilling.getPhone());

        TextField email = new TextField();
        email.getStyle().set("background", TEXT_COLOR).set("color", "black").set("width", "100%");
        email.setValueChangeMode(ValueChangeMode.EAGER);
        if (autoFill) email.setValue(basketBilling.getEmail());

        TextField address = new TextField();
        address.getStyle().set("background", TEXT_COLOR).set("color", "black").set("width", "100%");
        address.setValueChangeMode(ValueChangeMode.EAGER);
        if (autoFill) address.setValue(basketBilling.getAddress());

        TextField postcode = new TextField();
        postcode.getStyle().set("background", TEXT_COLOR).set("color", "black").set("width", "100%");
        postcode.setValueChangeMode(ValueChangeMode.EAGER);
        if (autoFill) postcode.setValue(basketBilling.getPostcode());

        TextField municipality = new TextField();
        municipality.getStyle().set("background", TEXT_COLOR).set("color", "black").set("width", "100%");
        municipality.setValueChangeMode(ValueChangeMode.EAGER);
        if (autoFill) municipality.setValue(basketBilling.getMunicipality());

        Checkbox doNotCall = new Checkbox("Do not call");
        doNotCall.getStyle().set("background", TEXT_COLOR).set("color", "black").set("width", "100%");
        if (autoFill) doNotCall.setValue(basketBilling.isDoNotCall());

        Button saveButton = new Button("Save");
        saveButton.getStyle().set("background", BG_COLOR).set("color", TEXT_COLOR);
        Button resetButton = new Button("Reset");
        resetButton.getStyle().set("background", BG_COLOR).set("color", TEXT_COLOR);

        Checkbox autoFillShipping = new Checkbox("Also send products to this address.");
        autoFillShipping.getStyle().set("background", TEXT_COLOR).set("color", "black").set("width", "100%");

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
        saveButton.getStyle().set("width", "41%");
        saveButton.addClickListener(event -> {
            if (binder.writeBeanIfValid(basketBilling)) {
                basketBilling.setUserId(getTokenCookie().getValue());
                basketServiceClient.apiAddBasketBilling(basketBilling);
                if (autoFillShipping.getValue()) {
                    basketServiceClient.apiAddBasketShipping(mapShippingWithBillingAddress(basketBilling));
                } else {
                    createShippingAddressForm(new BasketShipping(), false);
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

        resetButton.getStyle().set("width", "41%");
        resetButton.addClickListener(event -> {
            // clear fields by setting null
            binder.readBean(null);
            doNotCall.setValue(false);
        });

        addressFormDiv.add(layoutWithBinder);
        addressFormDiv.add(resetButton, saveButton);

        add(addressFormDiv);
    }

    private void createShippingAddressForm(final BasketShipping contact, final boolean autoFill) {

        Div addressFormDiv = new Div();
        addressFormDiv.setText("BasketShipping address".toUpperCase());
        addressFormDiv.setClassName("card");
        addressFormDiv.getStyle().set("margin-left", "5px").set("margin-right", "5px");

        FormLayout layoutWithBinder = new FormLayout();
        layoutWithBinder.getStyle().set("margin-left", "5px").set("margin-right", "5px");
        Binder<BasketShipping> binder = new Binder<>();

        // Create the fields
        TextField firstName = new TextField();
        firstName.getStyle().set("background", TEXT_COLOR).set("color", "black").set("width", "100%");
        firstName.setValueChangeMode(ValueChangeMode.EAGER);
        if (autoFill) firstName.setValue(contact.getFirstName());

        TextField lastName = new TextField();
        lastName.getStyle().set("background", TEXT_COLOR).set("color", "black").set("width", "100%");
        lastName.setValueChangeMode(ValueChangeMode.EAGER);
        if (autoFill) lastName.setValue(contact.getLastName());

        TextField address = new TextField();
        address.getStyle().set("background", TEXT_COLOR).set("color", "black").set("width", "100%");
        address.setValueChangeMode(ValueChangeMode.EAGER);
        if (autoFill) address.setValue(contact.getAddress());

        TextField postcode = new TextField();
        postcode.getStyle().set("background", TEXT_COLOR).set("color", "black").set("width", "100%");
        postcode.setValueChangeMode(ValueChangeMode.EAGER);
        if (autoFill) postcode.setValue(contact.getPostcode());

        TextField municipality = new TextField();
        municipality.getStyle().set("background", TEXT_COLOR).set("color", "black").set("width", "100%");
        municipality.setValueChangeMode(ValueChangeMode.EAGER);
        if (autoFill) municipality.setValue(contact.getMunicipality());

        Button saveButton = new Button("Save");
        saveButton.getStyle().set("background", BG_COLOR).set("color", TEXT_COLOR);
        Button resetButton = new Button("Reset");
        resetButton.getStyle().set("background", BG_COLOR).set("color", TEXT_COLOR);

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
                contact.setUserId(getTokenCookie().getValue());
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

        resetButton.getStyle().set("width", "41%");
        resetButton.addClickListener(event -> binder.readBean(null));

        addressFormDiv.add(layoutWithBinder);
        addressFormDiv.add(resetButton, saveButton);

        add(addressFormDiv);
    }

    private Cookie getTokenCookie() {
        Cookie[] cookies = VaadinService.getCurrentRequest().getCookies();
        return Arrays.stream(cookies).filter(cookie -> TOKEN_COOKIE.equals(cookie.getName())).findFirst().orElse(null);
    }

}
