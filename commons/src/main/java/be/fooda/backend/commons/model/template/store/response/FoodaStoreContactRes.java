package be.fooda.backend.commons.model.template.store.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class FoodaStoreContactRes {
    private Long storeContactId;
    private String call;
    private String phoneNumber;
    private String firstName;
    private String familyName;
    private String email;
}