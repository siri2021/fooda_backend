package be.fooda.backend.commons.model.template.store.response;

import lombok.NoArgsConstructor;
import lombok.*;

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
    private String municipality;
    private String region;
}