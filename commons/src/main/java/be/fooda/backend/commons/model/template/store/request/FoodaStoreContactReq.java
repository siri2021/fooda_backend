package be.fooda.backend.commons.model.template.store.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class FoodaStoreContactReq {

    @JsonProperty("call")
    private String call;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("family_name")
    private String familyName;

    @JsonProperty("email")
    private String email;
}