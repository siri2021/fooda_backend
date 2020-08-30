package be.fooda.backend.commons.model.template.basket.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class FoodaBasketAddressRes {
    private Long addressId;
    private String doorNo;
    private String number;
    private String street;
    private String postCode;
    private String municipality;
    private String city;
    private String region;
    private String country;
}
