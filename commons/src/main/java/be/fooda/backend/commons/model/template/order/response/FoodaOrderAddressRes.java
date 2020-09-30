// FoodaOrderAddressRes.java

package be.fooda.backend.commons.model.template.order.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FoodaOrderAddressRes {
    private Long addressId;
    private String number;
    private String street;
    private String municipality;
    private String city;
    private String region;
    private String country;
    private String doorNo;
}