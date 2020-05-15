package it.vkod.woo.product.client.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Input;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.data.binder.BindingValidationStatus;
import com.vaadin.flow.data.renderer.TextRenderer;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.data.validator.StringLengthValidator;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.function.SerializablePredicate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import it.vkod.woo.product.client.payloads.basketRequest.Contact;
import it.vkod.woo.product.client.services.WooBasketServiceClient;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Optional;
import java.util.stream.Collectors;

import static it.vkod.woo.product.client.views.ContactView.ROUTE;

@UIScope
@Route(value = ROUTE, layout = MasterView.class)
@SpringComponent
public class ContactView extends Div {

    @Autowired
    private WooBasketServiceClient basketServiceClient;

    public final static String ROUTE = "contact";
    private final String BG_COLOR = "#FF5733";
    private final String TEXT_COLOR = "white";
    private final String BUTTON_HEIGHT = "48px";
    private long USER_ID;

    @PostConstruct
    public void init() {
        setClassName("container-fluid");
        setUserIdFromInput();
    }

    private void setUserIdFromInput() {
        Dialog dialog = new Dialog();
        Input input = new Input();
        dialog.add(input);
        dialog.open();
        input.getElement().callJsFunction("focus");
        input.addValueChangeListener(userIdIsEntered -> {
            if (userIdIsEntered.getValue().contains("#")) {
                USER_ID = Long.parseLong(input.getValue().replace("#", ""));
                dialog.close();
                if (!getExistingContacts(USER_ID)) {
                    getAddNewContact();
                } else {
                    getAddMoreContact();
                }
            }
        });
    }

    private boolean getExistingContacts(final long userId) {
        final Contact[] contacts = basketServiceClient.apiGetBasketContacts(userId);
        final boolean hasContactRegistry = contacts.length > 0;
        if (hasContactRegistry) {
            Div registeredAddressesDiv = new Div();
            registeredAddressesDiv.setClassName("card");
            registeredAddressesDiv.getStyle().set("margin-left", "5px").set("margin-right", "5px");

            RadioButtonGroup<Contact> radioGroup = new RadioButtonGroup<>();
            radioGroup.setItems(contacts);
            radioGroup.setRenderer(new TextRenderer<>(c -> c.getFirstName() + " " + c.getLastName() + "\n" + c.getAddress() + "\n" + c.getPostcode()));
            registeredAddressesDiv.add(radioGroup);
            add(registeredAddressesDiv);
        }

        return hasContactRegistry;
    }

    private void getAddMoreContact() {
        Div addMoreContactDiv = new Div();
        addMoreContactDiv.setClassName("card");
        addMoreContactDiv.getStyle().set("margin-left", "5px").set("margin-right", "5px");
        Button addMoreContactButton = new Button("Add more contact");
        addMoreContactButton.getStyle().set("background", BG_COLOR).set("color", TEXT_COLOR);
        addMoreContactButton.addClickListener(addMoreClick -> {
            getAddNewContact();
        });
        addMoreContactDiv.add(addMoreContactButton);
        add(addMoreContactDiv);
    }

    private void getAddNewContact() {

        Div addressFormDiv = new Div();
        addressFormDiv.setClassName("card");
        addressFormDiv.getStyle().set("margin-left", "5px").set("margin-right", "5px");

        FormLayout layoutWithBinder = new FormLayout();
        layoutWithBinder.getStyle().set("margin-left", "5px").set("margin-right", "5px");
        Binder<Contact> binder = new Binder<>();

        // The object that will be edited
        Contact contactBeingEdited = new Contact();

        // Create the fields
        TextField firstName = new TextField();
        firstName.getStyle().set("background", TEXT_COLOR).set("color", "black").set("width", "100%");
        firstName.setValueChangeMode(ValueChangeMode.EAGER);
        TextField lastName = new TextField();
        lastName.getStyle().set("background", TEXT_COLOR).set("color", "black").set("width", "100%");
        lastName.setValueChangeMode(ValueChangeMode.EAGER);
        TextField phone = new TextField();
        phone.getStyle().set("background", TEXT_COLOR).set("color", "black").set("width", "100%");
        phone.setValueChangeMode(ValueChangeMode.EAGER);
        TextField email = new TextField();
        email.getStyle().set("background", TEXT_COLOR).set("color", "black").set("width", "100%");
        email.setValueChangeMode(ValueChangeMode.EAGER);
        TextField address = new TextField();
        address.getStyle().set("background", TEXT_COLOR).set("color", "black").set("width", "100%");
        address.setValueChangeMode(ValueChangeMode.EAGER);
        TextField postcode = new TextField();
        postcode.getStyle().set("background", TEXT_COLOR).set("color", "black").set("width", "100%");
        postcode.setValueChangeMode(ValueChangeMode.EAGER);
        TextField municipality = new TextField();
        municipality.getStyle().set("background", TEXT_COLOR).set("color", "black").set("width", "100%");
        municipality.setValueChangeMode(ValueChangeMode.EAGER);
        TextField region = new TextField();
        region.getStyle().set("background", TEXT_COLOR).set("color", "black").set("width", "100%");
        region.setValueChangeMode(ValueChangeMode.EAGER);
        TextField city = new TextField();
        city.getStyle().set("background", TEXT_COLOR).set("color", "black").set("width", "100%");
        city.setValueChangeMode(ValueChangeMode.EAGER);
        TextField country = new TextField();
        country.getStyle().set("background", TEXT_COLOR).set("color", "black").set("width", "100%");
        country.setValueChangeMode(ValueChangeMode.EAGER);
        Checkbox doNotCall = new Checkbox("Do not call");
        doNotCall.getStyle().set("background", TEXT_COLOR).set("color", "black").set("width", "100%");

        Button saveButton = new Button("Save");
        saveButton.getStyle().set("background", BG_COLOR).set("color", TEXT_COLOR);
        Button resetButton = new Button("Reset");
        resetButton.getStyle().set("background", BG_COLOR).set("color", TEXT_COLOR);

        layoutWithBinder.addFormItem(firstName, "First name");
        layoutWithBinder.addFormItem(lastName, "Last name");
        layoutWithBinder.addFormItem(email, "E-mail");
        FormLayout.FormItem phoneItem = layoutWithBinder.addFormItem(phone, "Phone");
        phoneItem.add(doNotCall);
        layoutWithBinder.addFormItem(address, "Address");
        layoutWithBinder.addFormItem(postcode, "Postcode");
        layoutWithBinder.addFormItem(municipality, "Municipality");
        layoutWithBinder.addFormItem(region, "Region");
        layoutWithBinder.addFormItem(city, "City");
        layoutWithBinder.addFormItem(country, "Country");


        SerializablePredicate<String> phoneOrEmailPredicate = value -> !phone.getValue().trim().isEmpty() || !email.getValue().trim().isEmpty();

        // E-mail and phone have specific validators
        Binder.Binding<Contact, String> emailBinding = binder.forField(email)
                .withValidator(phoneOrEmailPredicate, "Both phone and email cannot be empty")
                .withValidator(new EmailValidator("Incorrect email address"))
                .bind(Contact::getEmail, Contact::setEmail);

        Binder.Binding<Contact, String> phoneBinding = binder.forField(phone)
                .withValidator(phoneOrEmailPredicate, "Both phone and email cannot be empty")
                .bind(Contact::getPhone, Contact::setPhone);

        // Trigger cross-field validation when the other field is changed
        email.addValueChangeListener(event -> phoneBinding.validate());
        phone.addValueChangeListener(event -> emailBinding.validate());

        // First name and last name are required fields
        firstName.setRequiredIndicatorVisible(true);
        lastName.setRequiredIndicatorVisible(true);
        address.setRequiredIndicatorVisible(true);
        postcode.setRequiredIndicatorVisible(true);

        binder.forField(firstName)
                .withValidator(new StringLengthValidator("Please add the first name", 1, null))
                .bind(Contact::getFirstName, Contact::setFirstName);
        binder.forField(lastName)
                .withValidator(new StringLengthValidator("Please add the last name", 1, null))
                .bind(Contact::getLastName, Contact::setLastName);
        binder.forField(address)
                .withValidator(new StringLengthValidator("Please add address", 1, null))
                .bind(Contact::getAddress, Contact::setAddress);
        binder.forField(postcode)
                .withValidator(new StringLengthValidator("Please add a postcode", 1, null))
                .bind(Contact::getPostcode, Contact::setPostcode);
        binder.forField(municipality)
                .withValidator(new StringLengthValidator("Please add a municipality", 1, null))
                .bind(Contact::getMunicipality, Contact::setMunicipality);
        binder.forField(region)
                .withValidator(new StringLengthValidator("Please add a region", 1, null))
                .bind(Contact::getRegion, Contact::setRegion);
        binder.forField(city)
                .withValidator(new StringLengthValidator("Please add a city", 1, null))
                .bind(Contact::getCity, Contact::setCity);
        binder.forField(country)
                .withValidator(new StringLengthValidator("Please add a country", 1, null))
                .bind(Contact::getCountry, Contact::setCountry);

        // doNotCall don't need any special validators
        binder.bind(doNotCall, Contact::isDoNotCall, Contact::setDoNotCall);

        // Click listeners for the buttons
        saveButton.getStyle().set("width", "41%");
        saveButton.addClickListener(event -> {
            if (binder.writeBeanIfValid(contactBeingEdited)) {
                contactBeingEdited.setUserId(USER_ID);
                basketServiceClient.apiAddBasketContact(contactBeingEdited);
                new Notification("New address is saved.", 3000).open();
                UI.getCurrent().getPage().reload();
            } else {
                BinderValidationStatus<Contact> validate = binder.validate();
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

}
