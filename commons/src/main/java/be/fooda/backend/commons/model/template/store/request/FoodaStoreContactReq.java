package be.fooda.backend.commons.model.template.store.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class FoodaStoreContactReq {
    private Long contactId;
    private String call;
    private String phoneNumber;
    private String firstName;
    private String familyName;
    private String email;
}