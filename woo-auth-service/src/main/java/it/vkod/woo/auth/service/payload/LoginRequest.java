package it.vkod.woo.auth.service.payload;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    @NotBlank
    @Getter
    @Setter
    private String usernameOrEmail;

    @NotBlank
    @Getter @Setter
    private String password;
}
