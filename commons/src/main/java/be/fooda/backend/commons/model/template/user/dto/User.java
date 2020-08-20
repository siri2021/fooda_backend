package be.fooda.backend.commons.model.template.user.dto;

import be.fooda.backend.commons.service.validator.UniqueLogin;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    @UniqueLogin
    private String login;
    private char[] password;
}
