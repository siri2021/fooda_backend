package it.vkod.woo.product.client.pojo.auth.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthResponse {

    @Getter
    @Setter
    private String accessToken;
    @Getter
    @Setter
    private String tokenType = "Bearer";
}
