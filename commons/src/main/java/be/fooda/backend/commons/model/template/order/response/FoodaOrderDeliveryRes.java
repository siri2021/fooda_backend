// FoodaOrderDeliveryRes.java

package be.fooda.backend.commons.model.template.order.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class FoodaOrderDeliveryRes {
    private FoodaOrderAddressRes address;
    private FoodaOrderContactRes contact;
}