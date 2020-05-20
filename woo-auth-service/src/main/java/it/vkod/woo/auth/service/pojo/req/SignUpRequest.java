package it.vkod.woo.auth.service.pojo.req;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import javax.validation.constraints.*;

@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SignUpRequest {

    @NotBlank
    @Size(min = 2, max = 255)
    @Getter @Setter
    private String name;

    @NotBlank
    @Size(min = 3, max = 32)
    @Getter @Setter
    private String username;

    @NotBlank
    @Size(max = 255)
    @Email
    @Getter @Setter
    private String email;

    @NotBlank
    @Size(min = 8, max = 32)
    @Getter @Setter
    private String password;
}
