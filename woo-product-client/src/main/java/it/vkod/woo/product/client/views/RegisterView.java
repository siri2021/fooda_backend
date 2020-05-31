package it.vkod.woo.product.client.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.BinderValidationStatus;
import com.vaadin.flow.data.binder.BindingValidationStatus;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.function.SerializablePredicate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import it.vkod.woo.product.client.pojo.auth.request.SignUpRequest;
import it.vkod.woo.product.client.clients.WooUserServiceClient;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Optional;
import java.util.stream.Collectors;

import static it.vkod.woo.product.client.views.RegisterView.ROUTE;

@UIScope
@Route(value = ROUTE, layout = MasterView.class)
@SpringComponent
@CssImport("./styles/materialize.min.css")
@CssImport("./styles/custom-card.css")
public class RegisterView extends Div {

    @Autowired
    private WooUserServiceClient userServiceClient;

    public final static String ROUTE = "register";
    private static final String TOKEN_COOKIE = "token";
    private final String BG_COLOR = "#FF5733";
    private final String TEXT_COLOR = "white";
    private final String BUTTON_HEIGHT = "38px";
    private final String ICON_SIZE = "28px";

    @PostConstruct
    public void init() {
        setClassName("container-fluid");

        Div registerFormDiv = new Div();
        registerFormDiv.setClassName("card");
        registerFormDiv.getStyle().set("margin-left", "5px").set("margin-right", "5px").set("margin-top", "60%");

        FormLayout layoutWithBinder = new FormLayout();
        layoutWithBinder.getStyle().set("margin-left", "5px").set("margin-right", "5px");
        Binder<SignUpRequest> binder = new Binder<>();

        // The object that will be edited
        SignUpRequest userInfoBeingEdited = new SignUpRequest();

        // Create the fields
        TextField username = new TextField();
        username.getStyle().set("background", TEXT_COLOR).set("color", "black").set("width", "100%");
        username.setValueChangeMode(ValueChangeMode.EAGER);
        TextField email = new TextField();
        email.getStyle().set("background", TEXT_COLOR).set("color", "black").set("width", "100%");
        email.setValueChangeMode(ValueChangeMode.EAGER);
        TextField password = new TextField();
        password.getStyle().set("background", TEXT_COLOR).set("color", "black").set("width", "100%");
        password.setValueChangeMode(ValueChangeMode.EAGER);

        SerializablePredicate<String> emailPredicate = value -> !email.getValue().trim().isEmpty();

        // E-mail and phone have specific validators
        Binder.Binding<SignUpRequest, String> emailBinding = binder.forField(email)
                .withValidator(emailPredicate, "Both phone and email cannot be empty")
                .withValidator(new EmailValidator("Incorrect email address"))
                .bind(SignUpRequest::getEmail, SignUpRequest::setEmail);

        SerializablePredicate<String> usernameAndPasswordPredicate = value -> !username.getValue().trim().isEmpty() || !password.getValue().trim().isEmpty();

        // username/email and password have specific validators
        Binder.Binding<SignUpRequest, String> usernameBinding = binder.forField(username)
                .withValidator(usernameAndPasswordPredicate, "Both username and password cannot be empty")
                .bind(SignUpRequest::getUsername, SignUpRequest::setUsername);

        Binder.Binding<SignUpRequest, String> passwordBinding = binder.forField(password)
                .withValidator(usernameAndPasswordPredicate, "Both username and password cannot be empty")
                .bind(SignUpRequest::getPassword, SignUpRequest::setPassword);

        // Trigger cross-field validation when the other field is changed
        username.addValueChangeListener(event -> passwordBinding.validate());
        password.addValueChangeListener(event -> usernameBinding.validate());
        email.addValueChangeListener(event -> emailBinding.validate());

        Button registerButton = new Button("Register");
        registerButton.getStyle().set("background", BG_COLOR).set("color", TEXT_COLOR);

        // Click listeners for the buttons
        registerButton.getStyle().set("width", "41%");
        registerButton.addClickListener(event -> {
            if (binder.writeBeanIfValid(userInfoBeingEdited)) {
                userServiceClient.register(userInfoBeingEdited);
                new Notification("New user is saved.", 3000).open();
                UI.getCurrent().getPage().reload();
            } else {
                BinderValidationStatus<SignUpRequest> validate = binder.validate();
                String errorText = validate.getFieldValidationStatuses()
                        .stream().filter(BindingValidationStatus::isError)
                        .map(BindingValidationStatus::getMessage)
                        .map(Optional::get).distinct()
                        .collect(Collectors.joining(", "));
                new Notification("There are errors: " + errorText, 4000).open();
            }
        });

        layoutWithBinder.addFormItem(username, "Username/Email");
        layoutWithBinder.addFormItem(password, "Password");
        layoutWithBinder.addFormItem(email, "E-mail");
        registerFormDiv.add(layoutWithBinder);
        registerFormDiv.add(registerButton);
        add(registerFormDiv);
    }
}
