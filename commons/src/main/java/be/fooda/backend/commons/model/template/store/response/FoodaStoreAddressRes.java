package be.fooda.backend.commons.model.template.store.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FoodaStoreAddressRes {
    private String number;
    private String country;
    private String city;
    private String street;
    private String doorNo;
    private String municipality;
    private String region;
}