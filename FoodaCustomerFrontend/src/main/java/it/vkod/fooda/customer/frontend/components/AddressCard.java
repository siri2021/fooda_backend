package it.vkod.fooda.customer.frontend.components;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.value.ValueChangeMode;
import it.vkod.fooda.customer.frontend.models.basket.req.BasketAddressRequest;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;


/**
 * <!-- Registry Card row -->
 * <div class="row">
 *   <div class="col s12 m12">
 *     <div class="card">
 *       <div class="card-content">
 *          <span class="card-title"><h4>Sign up to find out more about Two Lanterns.</h4></span>
 *           <form class="container">
 *             <div class="input-field col m6">
 *               <input id="email" type="email" class="validate">
 *               <label for="email">Email</label>
 *             </div>
 *             <div class="input-field col m6">
 *               <button class="btn waves-effect waves-light" type="submit" name="action">
 *                 Submit <i class="material-icons right">send</i>
 *               </button>
 *             </div>
 *           </form>
 *       </div>
 *     </div>
 *   </div>
 * </div><!-- End of Sign Up Card row -->
 */
@Slf4j
@EqualsAndHashCode(callSuper = true)
@Value
@AllArgsConstructor
@Tag("div")
public class AddressCard extends Div {

    @Getter
    BasketAddressRequest addressBeingEdited;

    public AddressCard div() {
        setClassName("container");

        Binder<BasketAddressRequest> binder = new Binder<>(BasketAddressRequest.class);

        binder.readBean(addressBeingEdited);

        Div row = new Div();
        row.setClassName("row");

        Div column = new Div();
        column.setClassName("col s12 m12");

        Div card = new Div();
        card.setClassName("card");

        Div cardContent = new Div();
        cardContent.setClassName("card-content");

        Span cardTitle = new Span();
        cardTitle.setClassName("card-title");

        H4 cardTitleHeader = new H4("Address Form");
        cardTitle.add(cardTitleHeader);

        FormLayout form = new FormLayout();
        form.setClassName("container");

        // First Name Div
        Div firstNameDiv = new Div();
        firstNameDiv.setClassName("input-field col m6");

        Input firstNameField = new Input(ValueChangeMode.EAGER);
        firstNameField.setId("firstName");
        firstNameField.setClassName("validate");
        firstNameField.addFocusListener(focused -> firstNameField.getElement().setText(""));
        binder.forField(firstNameField).bind(BasketAddressRequest::getFirstName, BasketAddressRequest::setFirstName);

        Label firstNameLabel = new Label();
        firstNameLabel.setFor("firstName");
        firstNameLabel.setText("First Name");

        firstNameDiv.add(firstNameField, firstNameLabel);
        form.add(firstNameDiv);

        // Last Name Div
        Div lastNameDiv = new Div();
        lastNameDiv.setClassName("input-field col m6");

        Input lastNameField = new Input(ValueChangeMode.EAGER);
        lastNameField.setId("lastName");
        lastNameField.setClassName("validate");
        binder.forField(firstNameField).bind(BasketAddressRequest::getLastName, BasketAddressRequest::setLastName);

        Label lastNameLabel = new Label();
        lastNameLabel.setFor("lastName");
        lastNameLabel.setText("Last Name");

        lastNameDiv.add(lastNameField, lastNameLabel);
        form.add(lastNameDiv);

        // Address Div
        Div addressDiv = new Div();
        addressDiv.setClassName("input-field col m6");

        Input addressField = new Input(ValueChangeMode.EAGER);
        addressField.setId("address");
        addressField.setClassName("validate");
        binder.forField(firstNameField).bind(BasketAddressRequest::getAddress, BasketAddressRequest::setAddress);

        Label addressLabel = new Label();
        addressLabel.setFor("address");
        addressLabel.setText("Address");

        addressDiv.add(addressField, addressLabel);
        form.add(addressDiv);

        // Postcode Div
        Div postcodeDiv = new Div();
        postcodeDiv.setClassName("input-field col m6");

        Input postcodeField = new Input(ValueChangeMode.EAGER);
        postcodeField.setId("postcode");
        postcodeField.setClassName("validate");
        binder.forField(firstNameField).bind(BasketAddressRequest::getPostcode, BasketAddressRequest::setPostcode);

        Label postcodeLabel = new Label();
        postcodeLabel.setFor("postcode");
        postcodeLabel.setText("Postcode");

        postcodeDiv.add(postcodeField, postcodeLabel);
        form.add(postcodeDiv);

        // Municipality Div
        Div municipalityDiv = new Div();
        municipalityDiv.setClassName("input-field col m6");

        Input municipalityField = new Input(ValueChangeMode.EAGER);
        municipalityField.setId("municipality");
        municipalityField.setClassName("validate");
        binder.forField(firstNameField).bind(BasketAddressRequest::getMunicipality, BasketAddressRequest::setMunicipality);

        Label municipalityLabel = new Label();
        municipalityLabel.setFor("municipality");
        municipalityLabel.setText("Municipality");

        municipalityDiv.add(municipalityField, municipalityLabel);
        form.add(municipalityDiv);

        // City Div
        Div cityDiv = new Div();
        cityDiv.setClassName("input-field col m6");

        Input cityField = new Input(ValueChangeMode.EAGER);
        cityField.setId("city");
        cityField.setClassName("validate");
        binder.forField(firstNameField).bind(BasketAddressRequest::getCity, BasketAddressRequest::setCity);

        Label cityLabel = new Label();
        cityLabel.setFor("city");
        cityLabel.setText("City");

        cityDiv.add(cityField, cityLabel);
        form.add(cityDiv);

        // Country Div
        Div countryDiv = new Div();
        countryDiv.setClassName("input-field col m6");

        Input countryField = new Input(ValueChangeMode.EAGER);
        countryField.setId("country");
        countryField.setClassName("validate");
        binder.forField(firstNameField).bind(BasketAddressRequest::getCountry, BasketAddressRequest::setCountry);

        Label countryLabel = new Label();
        countryLabel.setFor("country");
        countryLabel.setText("Country");

        countryDiv.add(countryField, countryLabel);
        form.add(countryDiv);

        NativeButton saveButton = new NativeButton("Save", click -> {
            try {
                binder.writeBean(addressBeingEdited);
                log.info("Address: " + addressBeingEdited.getFirstName() + " " + addressBeingEdited.getLastName() + "\n" + addressBeingEdited.getAddress());
            } catch (ValidationException e) {
                log.error(e.getMessage());
            }
        });
        saveButton.setClassName("btn waves-effect waves-light");

        Div saveButtonDiv = new Div();
        saveButtonDiv.setClassName("input-field col m6");

        Html saveButtonIcon = new Html("<i class=\"material-icons right\">Save</i>");
        saveButton.add(saveButtonIcon);
        saveButtonDiv.add(saveButton);

        form.add(saveButtonDiv);
        cardContent.add(form);
        card.add(cardContent);
        column.add(card);
        row.add(column);
        add(row);

        return this;
    }
}
