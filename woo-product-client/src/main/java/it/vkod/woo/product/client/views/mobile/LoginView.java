package it.vkod.woo.product.client.views.mobile;

import com.vaadin.flow.component.Key;
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
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.function.SerializablePredicate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import it.vkod.woo.product.client.pojo.auth.request.LoginRequest;
import it.vkod.woo.product.client.clients.WooUserServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import static it.vkod.woo.product.client.views.mobile.LoginView.ROUTE;

@Slf4j
@UIScope
@Route(value = ROUTE, layout = MasterView.class)
@SpringComponent
@CssImport("./styles/materialize.min.css")
@CssImport("./styles/custom-card.css")
public class LoginView extends Div {

    @Autowired
    private WooUserServiceClient userServiceClient;

    public final static String ROUTE = "";
    private static final String TOKEN_COOKIE = "token";
    private final String BG_COLOR = "#3333FF";
    private final String TEXT_COLOR = "white";

    @PostConstruct
    public void init() {
        setClassName("container-fluid");

        Div loginFormDiv = new Div();
        loginFormDiv.setClassName("card");
        loginFormDiv.getStyle()
                .set("margin-left", "5px")
                .set("margin-right", "5px")
                .set("margin-top", "60%");

        FormLayout loginLayout = new FormLayout();
        loginLayout.getStyle()
                .set("margin-left", "5px")
                .set("margin-right", "5px");
        Binder<LoginRequest> binder = new Binder<>();

        // The object that will be edited
        LoginRequest loginInfo = new LoginRequest();

        // Create the fields
        TextField username = new TextField();
        username.setAutoselect(true);
        username.getStyle()
                .set("background", TEXT_COLOR)
                .set("color", "black")
                .set("width", "100%");
        username.setValueChangeMode(ValueChangeMode.EAGER);
        TextField password = new TextField();
        password.getStyle()
                .set("background", TEXT_COLOR)
                .set("color", "black")
                .set("width", "100%");
        password.setValueChangeMode(ValueChangeMode.EAGER);

        SerializablePredicate<String> userAndPasswordValidator = value -> !username.getValue().trim().isEmpty() || !password.getValue().trim().isEmpty();

        // username/email and password have specific validators
        Binder.Binding<LoginRequest, String> usernameOrEmailBinding = binder.forField(username)
                .withValidator(userAndPasswordValidator, "Both username/email and password cannot be empty")
                .bind(LoginRequest::getUsernameOrEmail, LoginRequest::setUsernameOrEmail);

        Binder.Binding<LoginRequest, String> passwordBinding = binder.forField(password)
                .withValidator(userAndPasswordValidator, "Both username/email and password cannot be empty")
                .bind(LoginRequest::getPassword, LoginRequest::setPassword);

        // Trigger cross-field validation when the other field is changed
        username.addValueChangeListener(event -> passwordBinding.validate());
        password.addValueChangeListener(event -> usernameOrEmailBinding.validate());

        Button loginButton = new Button("Login");
        loginButton.addClickShortcut(Key.ENTER);
        loginButton.getStyle().set("background", BG_COLOR).set("color", TEXT_COLOR).set("width", "55%");
        loginButton.addClickListener(event -> {
            if (binder.writeBeanIfValid(loginInfo)) {
                final String token = userServiceClient.login(loginInfo);
                new Notification("Login success.", 2000).open();
                if (!token.isEmpty()) {
                    generateTokenCookie(token);
                    UI.getCurrent().navigate("search");
                } else {
                    new Notification("User does not exist, please register first.").open();
                }
            } else {
                BinderValidationStatus<LoginRequest> validate = binder.validate();
                String errorText = validate.getFieldValidationStatuses()
                        .stream().filter(BindingValidationStatus::isError)
                        .map(BindingValidationStatus::getMessage)
                        .map(Optional::get).distinct()
                        .collect(Collectors.joining(", "));
                new Notification("There are errors: " + errorText, 4000).open();
            }
        });

        Button registerButton = new Button("Register");
        registerButton.getStyle().set("background", BG_COLOR).set("color", TEXT_COLOR).set("width", "30%");
        registerButton.addClickListener(event -> UI.getCurrent().navigate("register"));

        loginLayout.addFormItem(username, "Username/Email");
        loginLayout.addFormItem(password, "Password");
        loginFormDiv.add(loginLayout);
        loginFormDiv.add(registerButton, loginButton);
        add(loginFormDiv);
    }

    private void generateTokenCookie(String token) {
        // See if name cookie is already set
        Cookie tokenCookie = getTokenCookie();

        if (tokenCookie != null) {
            String oldToken = tokenCookie.getValue();
            tokenCookie.setValue(token);
            log.info("Updated name in cookie from " + oldToken + " to " + token);
        } else {
            // Create a new cookie
            tokenCookie = new Cookie(TOKEN_COOKIE, token);
            tokenCookie.setComment("Cookie for storing the name of the user");
            log.info("Cookie for storing the name of the user");
        }

        tokenCookie.setMaxAge(600);
        tokenCookie.setPath(VaadinService.getCurrentRequest().getContextPath());
        VaadinService.getCurrentResponse().addCookie(tokenCookie);
    }

    private Cookie getTokenCookie() {
        Cookie[] cookies = VaadinService.getCurrentRequest().getCookies();
        return Arrays.stream(cookies).filter(cookie -> LoginView.TOKEN_COOKIE.equals(cookie.getName())).findFirst().orElse(null);
    }
}
