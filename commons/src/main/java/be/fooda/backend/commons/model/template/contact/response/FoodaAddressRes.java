package be.fooda.backend.commons.model.template.contact.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FoodaAddressRes {
    private Long addressId;
    private Long userId;
    private String doorNo;
    private String number;
    private String street;
    private String municipality;
    private String postcode;
    private String city;
    private String region;
    private String country;
}