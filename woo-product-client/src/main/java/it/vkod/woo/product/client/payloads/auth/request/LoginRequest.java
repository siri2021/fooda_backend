package it.vkod.woo.product.client.payloads.auth.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class LoginRequest {

    @NonNull
    @Getter
    @Setter
    private String usernameOrEmail;

    @NonNull
    @Getter
    @Setter
    private String password;
}
