package it.vkod.woo.auth.service.payload;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class JwtAuthenticationResponse {

    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    @Getter
    @Setter
    private String accessToken;

    @Getter
    @Setter
    private String tokenType = "Bearer";
}
