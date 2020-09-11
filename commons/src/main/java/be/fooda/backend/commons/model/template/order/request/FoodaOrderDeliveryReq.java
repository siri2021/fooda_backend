// FoodaOrderDeliveryRes.java

package be.fooda.backend.commons.model.template.order.request;

import lombok.*;

@NoArgsConstructor
@Data
public class FoodaOrderDeliveryReq {
    private Boolean isAddressSameAsBilling;
    private FoodaOrderContactReq contact;
}