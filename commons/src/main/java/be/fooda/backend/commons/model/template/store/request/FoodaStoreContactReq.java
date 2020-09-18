package be.fooda.backend.commons.model.template.store.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class FoodaStoreContactReq {
    private String call;
    private String phoneNumber;
    private String firstName;
    private String familyName;
    private String email;
}