// FoodaOrderAddressRes.java

package be.fooda.backend.commons.model.template.order.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
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