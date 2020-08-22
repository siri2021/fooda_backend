package be.fooda.backend.commons.model.template.store.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class FoodaStoreAuthItemReq {

    @JsonProperty("secret")
    private String secret;

    @JsonProperty("expiry")
    private String expiry;

    @JsonProperty("key")
    private String key;
}