package be.fooda.backend.commons.model.template.store.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class FoodaStoreContactRes {

    private Long contactId;
    private String call;
    private String phoneNumber;
    private String firstName;
    private String familyName;
    private String email;
}