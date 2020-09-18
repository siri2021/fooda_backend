package be.fooda.backend.commons.model.template.store.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class FoodaStoreAddressReq {
    private String number;
    private String country;
    private String city;
    private String street;
    private String doorNo;
    private String municipality;
    private String region;
}