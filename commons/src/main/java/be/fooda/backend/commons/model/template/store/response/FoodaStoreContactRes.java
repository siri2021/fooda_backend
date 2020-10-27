package be.fooda.backend.commons.model.template.store.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class FoodaStoreContactRes {

    private Long contactId;
    private String call;
    private String phoneNumber;
    private String firstName;
    private String familyName;
    private String email;
}