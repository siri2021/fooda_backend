package be.fooda.backend.commons.model.template.store.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class FoodaStoreAddressReq {

    private Long addressId;
    private String postcode;
    private String number;
    private String country;
    private String city;
    private String street;
    private String doorNo;
    private String municipality;
    private String region;
}