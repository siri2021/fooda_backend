package be.fooda.backend.commons.model.template.store.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class FoodaStoreAddressRes {

    private Long addressId;
    private String number;
    private String country;
    private String city;
    private String street;
    private String doorNo;
    private String postcode;
    private String municipality;
    private String region;
}