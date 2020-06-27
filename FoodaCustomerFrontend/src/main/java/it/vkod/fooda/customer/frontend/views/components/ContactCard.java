package it.vkod.fooda.customer.frontend.views.components;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.value.ValueChangeMode;
import it.vkod.fooda.customer.frontend.models.basket.req.BasketContact;
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
public class ContactCard extends Div {

    @Getter
    private BasketContact contactBeingEdited;

    public ContactCard init() {

        setClassName("container");

        Binder<BasketContact> binder = new Binder<>(BasketContact.class);

        if (contactBeingEdited != null)
            binder.readBean(contactBeingEdited);

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

        H4 cardTitleHeader = new H4("Contact Form");
        cardTitle.add(cardTitleHeader);

        FormLayout form = new FormLayout();
        form.setClassName("container");

        // First Name Div
        Div firstNameDiv = new Div();
        firstNameDiv.setClassName("input-field col m6");

        Input firstNameField = new Input(ValueChangeMode.EAGER);
        firstNameField.setId("firstName");
        firstNameField.setClassName("validate");
        binder.forField(firstNameField).bind(BasketContact::getFirstName, BasketContact::setFirstName);

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
        binder.forField(lastNameField).bind(BasketContact::getLastName, BasketContact::setLastName);

        Label lastNameLabel = new Label();
        lastNameLabel.setFor("lastName");
        lastNameLabel.setText("Last Name");

        lastNameDiv.add(lastNameField, lastNameLabel);
        form.add(lastNameDiv);

        // Email Div
        Div addressLine1Div = new Div();
        addressLine1Div.setClassName("input-field col m6");

        Input addressLine1Field = new Input(ValueChangeMode.EAGER);
        addressLine1Field.setId("email");
        addressLine1Field.setClassName("validate");
        binder.forField(addressLine1Field).bind(BasketContact::getEmail, BasketContact::setEmail);

        Label addressLine1Label = new Label();
        addressLine1Label.setFor("email");
        addressLine1Label.setText("Email");

        addressLine1Div.add(addressLine1Field, addressLine1Label);
        form.add(addressLine1Div);

        NativeButton saveButton = new NativeButton("Save", click -> {
            try {
                binder.writeBean(contactBeingEdited);
                log.info("Address: " + contactBeingEdited.getFirstName() + " " + contactBeingEdited.getLastName());
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
