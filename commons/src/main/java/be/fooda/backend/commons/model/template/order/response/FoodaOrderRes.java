// FoodaOrderRes.java

package be.fooda.backend.commons.model.template.order.response;

import lombok.*;

@NoArgsConstructor
@Data
public class FoodaOrderRes {
    private long customerID;
    private FoodaOrderBillingRes billing;
    private FoodaOrderDeliveryRes delivery;
    private FoodaSubOrderRes[] orders;
}