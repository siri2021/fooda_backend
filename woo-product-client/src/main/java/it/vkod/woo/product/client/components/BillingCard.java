package it.vkod.woo.product.client.components;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import lombok.EqualsAndHashCode;
import lombok.Getter;

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
@EqualsAndHashCode(callSuper = true)
@Tag("div")
public class BillingCard extends Div {

    @Getter
    private final String userId;
    @Getter
    private String firstName;
    @Getter
    private String lastName;
    @Getter
    private String email;
    @Getter
    private String phone;
    @Getter
    private String address;
    @Getter
    private String postcode;
    @Getter
    private String municipality;
    @Getter
    private boolean doNotCall;

    public BillingCard() {
        this("", "", "", "", "", "", "", "", false);
    }

    public BillingCard(String userId, String firstName, String lastName, String email, String phone, String address, String postcode, String municipality, boolean doNotCall) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.postcode = postcode;
        this.municipality = municipality;
        this.doNotCall = doNotCall;

        initForm();
    }

    private void initForm() {
        setClassName("card");

        Div cardContent = new Div();
        cardContent.setClassName("card-content");
        Span title = new Span("Billing Address");
        title.setClassName("card-title");
        cardContent.add(title);

        FormLayout layoutWithBinder = new FormLayout();

        TextField firstNameField = new TextField();
        firstNameField.setValue(firstName);
        firstNameField.addValueChangeListener(e -> firstName = firstNameField.getValue());
        TextField lastNameField = new TextField();
        lastNameField.setValue(lastName);
        lastNameField.addValueChangeListener(e -> lastName = lastNameField.getValue());
        TextField phoneField = new TextField();
        phoneField.setValue(phone);
        phoneField.addValueChangeListener(e -> phone = phoneField.getValue());
        EmailField emailField = new EmailField();
        emailField.setValue(email);
        emailField.addValueChangeListener(e -> email = emailField.getValue());
        TextField addressField = new TextField();
        addressField.setValue(address);
        addressField.addValueChangeListener(e -> address = addressField.getValue());
        TextField postcodeField = new TextField();
        postcodeField.setValue(postcode);
        postcodeField.addValueChangeListener(e -> postcode = postcodeField.getValue());
        TextField municipalityField = new TextField();
        municipalityField.setValue(municipality);
        municipalityField.addValueChangeListener(e -> municipality = municipalityField.getValue());
        Checkbox doNotCallField = new Checkbox("Do not call");
        doNotCallField.setValue(doNotCall);
        doNotCallField.addValueChangeListener(e -> doNotCall = doNotCallField.getValue());

        layoutWithBinder.addFormItem(firstNameField, "First name");
        layoutWithBinder.addFormItem(lastNameField, "Last name");
        layoutWithBinder.addFormItem(emailField, "E-mail");
        FormLayout.FormItem phoneItem = layoutWithBinder.addFormItem(phoneField, "Phone");
        phoneItem.add(doNotCallField);
        layoutWithBinder.addFormItem(addressField, "Address");
        layoutWithBinder.addFormItem(postcodeField, "Postcode");
        layoutWithBinder.addFormItem(municipalityField, "Municipality");

        firstNameField.setRequiredIndicatorVisible(true);
        lastNameField.setRequiredIndicatorVisible(true);
        addressField.setRequiredIndicatorVisible(true);
        postcodeField.setRequiredIndicatorVisible(true);

        cardContent.add(layoutWithBinder);
        add(cardContent);
    }


}
