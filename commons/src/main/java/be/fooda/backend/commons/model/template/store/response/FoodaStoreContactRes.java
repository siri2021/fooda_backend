package be.fooda.backend.commons.model.template.store.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FoodaStoreContactRes {
    private String call;
    private String phoneNumber;
    private String firstName;
    private String familyName;
    private String email;
}