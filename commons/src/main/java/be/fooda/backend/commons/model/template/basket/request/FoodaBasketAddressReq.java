package be.fooda.backend.commons.model.template.basket.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodaBasketAddressReq {
    private Long userId;
    private String doorNo;
    private String number;
    private String street;
    private String municipality;
    private String postcode;
    private String city;
    private String region;
    private String country;
    private Boolean isBilling;
    private Boolean isDelivery;
}
