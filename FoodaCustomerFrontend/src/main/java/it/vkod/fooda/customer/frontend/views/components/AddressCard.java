package it.vkod.fooda.customer.frontend.views.components;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.value.ValueChangeMode;
import it.vkod.fooda.customer.frontend.models.basket.req.BasketAddress;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
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
@Data
@Builder
@Tag("div")
public class AddressCard extends Div {

    @Getter
    private BasketAddress addressBeingEdited;

    public AddressCard init() {

        setClassName("container");

        Binder<BasketAddress> binder = new Binder<>(BasketAddress.class);

        if (addressBeingEdited != null)
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
        binder.forField(firstNameField).bind(BasketAddress::getFirstName, BasketAddress::setFirstName);

        Label firstNameLabel = new Label();
        firstNameLabel.setFor("firstName");
        firstNameLabel.setText("First Name");
        firstNameField.addFocusListener(focused -> firstNameLabel.setText(""));

        firstNameDiv.add(firstNameField, firstNameLabel);
        form.add(firstNameDiv);

        // Last Name Div
        Div lastNameDiv = new Div();
        lastNameDiv.setClassName("input-field col m6");

        Input lastNameField = new Input(ValueChangeMode.EAGER);
        lastNameField.setId("lastName");
        lastNameField.setClassName("validate");
        binder.forField(lastNameField).bind(BasketAddress::getLastName, BasketAddress::setLastName);

        Label lastNameLabel = new Label();
        lastNameLabel.setFor("lastName");
        lastNameLabel.setText("Last Name");

        lastNameDiv.add(lastNameField, lastNameLabel);
        form.add(lastNameDiv);

        // Address Line 1 Div
        Div addressLine1Div = new Div();
        addressLine1Div.setClassName("input-field col m6");

        Input addressLine1Field = new Input(ValueChangeMode.EAGER);
        addressLine1Field.setId("addressLine1");
        addressLine1Field.setClassName("validate");
        binder.forField(addressLine1Field).bind(BasketAddress::getAddressLine1, BasketAddress::setAddressLine1);

        Label addressLine1Label = new Label();
        addressLine1Label.setFor("addressLine1");
        addressLine1Label.setText("Address Line 1");

        addressLine1Div.add(addressLine1Field, addressLine1Label);
        form.add(addressLine1Div);

        // Address Line 2 Div
        Div addressLine2Div = new Div();
        addressLine2Div.setClassName("input-field col m6");

        Input addressLine2Field = new Input(ValueChangeMode.EAGER);
        addressLine2Field.setId("addressLine2");
        addressLine2Field.setClassName("validate");
        binder.forField(addressLine2Field).bind(BasketAddress::getAddressLine2, BasketAddress::setAddressLine2);

        Label addressLine2Label = new Label();
        addressLine2Label.setFor("addressLine2");
        addressLine2Label.setText("Address Line 2");

        addressLine2Div.add(addressLine2Field, addressLine2Label);
        form.add(addressLine2Div);

        // Postcode Div
        Div postcodeDiv = new Div();
        postcodeDiv.setClassName("input-field col m6");

        Input postcodeField = new Input(ValueChangeMode.EAGER);
        postcodeField.setId("postcode");
        postcodeField.setClassName("validate");
        binder.forField(postcodeField).bind(BasketAddress::getPostcode, BasketAddress::setPostcode);

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
        binder.forField(municipalityField).bind(BasketAddress::getMunicipality, BasketAddress::setMunicipality);

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
        binder.forField(cityField).bind(BasketAddress::getCity, BasketAddress::setCity);

        Label cityLabel = new Label();
        cityLabel.setFor("city");
        cityLabel.setText("City");

        cityDiv.add(cityField, cityLabel);
        form.add(cityDiv);

        // City Div
        Div regionDiv = new Div();
        regionDiv.setClassName("input-field col m6");

        Input regionField = new Input(ValueChangeMode.EAGER);
        regionField.setId("region");
        regionField.setClassName("validate");
        binder.forField(regionField).bind(BasketAddress::getCity, BasketAddress::setCity);

        Label regionLabel = new Label();
        regionLabel.setFor("region");
        regionLabel.setText("Region");

        regionDiv.add(regionField, regionLabel);
        form.add(regionDiv);

        // Country Div
        Div countryDiv = new Div();
        countryDiv.setClassName("input-field col m6");

        Input countryField = new Input(ValueChangeMode.EAGER);
        countryField.setId("country");
        countryField.setClassName("validate");
        binder.forField(countryField).bind(BasketAddress::getCountry, BasketAddress::setCountry);

        Label countryLabel = new Label();
        countryLabel.setFor("country");
        countryLabel.setText("Country");

        countryDiv.add(countryField, countryLabel);
        form.add(countryDiv);

        NativeButton saveButton = new NativeButton("Save", click -> {
            try {
                binder.writeBean(addressBeingEdited);
                log.info("Address: " + addressBeingEdited.getFirstName() + " " + addressBeingEdited.getLastName() + " from " + addressBeingEdited.getCity());
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
