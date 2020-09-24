// FoodaOrderDeliveryRes.java

package be.fooda.backend.commons.model.template.order.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FoodaOrderDeliveryRes {
    private FoodaOrderAddressRes address;
    private FoodaOrderContactRes contact;
}