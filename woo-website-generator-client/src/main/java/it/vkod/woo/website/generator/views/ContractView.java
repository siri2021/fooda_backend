package it.vkod.woo.website.generator.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import javax.annotation.PostConstruct;

import static it.vkod.woo.website.generator.views.ContractView.ROUTE;

@UIScope
@Route(value = ROUTE, layout = MasterView.class)
@SpringComponent
@CssImport("./styles/materialize.min.css")
@CssImport("./styles/custom-card.css")
public class ContractView extends Div {

    public final static String ROUTE = "";

    private final String BG_COLOR = "#FF5733"; // RGB 255, 87, 51
    private final String TEXT_COLOR = "white";
    private final String BUTTON_HEIGHT = "48px";

    @PostConstruct
    public void init() {

        setClassName("container-fluid");

// ACCOUNT INFORMATION
        Div accountCardDiv = new Div();
        accountCardDiv.setClassName("card");
        Div accountForm = new Div();
        accountForm.setClassName("card-content");
        final TextField emailTextField = new TextField("Email");
        emailTextField.setWidthFull();
        accountForm.add(emailTextField);
        final TextField phoneTextField = new TextField("Phone");
        phoneTextField.setWidthFull();
        accountForm.add(phoneTextField);
        final PasswordField passwordTextField = new PasswordField("Password");
        passwordTextField.setWidthFull();
        accountForm.add(passwordTextField);
        final PasswordField passwordConfirmTextField = new PasswordField("Confirm password");
        passwordConfirmTextField.setWidthFull();
        accountForm.add(passwordConfirmTextField);
        accountCardDiv.add(accountForm);
        add(accountCardDiv);

// PROFILE INFORMATION
        Div profileCardDiv = new Div();
        profileCardDiv.setClassName("card");
        Div profileInfoForm = new Div();
        profileInfoForm.setClassName("card-content");
        final TextField firstNameTextField = new TextField("First name");
        firstNameTextField.setWidthFull();
        profileInfoForm.add(firstNameTextField);
        final TextField lastNameTextField = new TextField("Last name");
        lastNameTextField.setWidthFull();
        profileInfoForm.add(lastNameTextField);
        RadioButtonGroup<String> languageGroup = new RadioButtonGroup<>();
        languageGroup.setLabel("Language");
        languageGroup.setItems("English", "Dutch", "French", "Turkish");
        profileInfoForm.add(languageGroup);
        final DatePicker dateOfBirthPicker = new DatePicker("Date of birth");
        dateOfBirthPicker.setWidthFull();
        profileInfoForm.add(dateOfBirthPicker);
        profileCardDiv.add(profileInfoForm);
        add(profileCardDiv);

// STORE CATEGORY
        Div categoryCardDiv = new Div();
        categoryCardDiv.setClassName("card");
        Div categoryForm = new Div();
        categoryForm.setClassName("card-content");
        categoryForm.add(new Checkbox("Culture"));
        categoryForm.add(new Checkbox("Environment"));
        categoryForm.add(new Checkbox("Fashion"));
        categoryForm.add(new Checkbox("Finance"));
        categoryForm.add(new Checkbox("Food", true));
        categoryForm.add(new Checkbox("Politics"));
        categoryForm.add(new Checkbox("Sports"));
        categoryForm.add(new Checkbox("Technology", true));
        categoryCardDiv.add(categoryForm);
        add(categoryCardDiv);

// TERMS AND CONDITIONS
        Div contractCardDiv = new Div();
        contractCardDiv.setClassName("card");
        Div contractForm = new Div();
        contractForm.setClassName("card-content");
        Paragraph paragraph = new Paragraph();
        paragraph.setText("After all has been said and done, I agree that "
                + "my data shall be safely stored for the sole purpose of "
                + "my ultimate enjoyment.");
        contractForm.add(paragraph);
        contractCardDiv.add(contractForm);
        Div contractActionsDiv = new Div();
        contractActionsDiv.setClassName("card-action");
        Button submitButton = new Button("Submit");
        submitButton.getStyle().set("width", "100%").set("background-color", TEXT_COLOR).set("color", BG_COLOR);
        submitButton.setEnabled(false);
        submitButton.addClickListener(e -> Notification.show("Registration Complete! \uD83D\uDC4D",
                4000, Notification.Position.BOTTOM_END));
        Checkbox confirmContractCheckBox = new Checkbox("I agree");
        confirmContractCheckBox.addValueChangeListener(e -> submitButton.setEnabled(e.getValue()));
        confirmContractCheckBox.getStyle().set("background-color", BG_COLOR).set("color", TEXT_COLOR).set("width", "34%");
        contractActionsDiv.add(confirmContractCheckBox, submitButton);
        contractCardDiv.add(contractActionsDiv);
        add(contractCardDiv);

    }

}
