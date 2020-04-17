package it.vkod.woo.website.generator.payloads.authRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignUpRequest {

    @NotBlank
    @Size(min = 4, max = 40)
    @JsonProperty
    private String name;

    @NotBlank
    @Size(min = 3, max = 15)
    @JsonProperty
    private String username;

    @NotBlank
    @Size(max = 40)
    @Email
    @JsonProperty
    private String email;

    @NotBlank
    @Size(min = 6, max = 20)
    @JsonProperty
    private String password;

    public SignUpRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}