// FoodaOrderDeliveryRes.java

package be.fooda.backend.commons.model.template.order.response;

import lombok.*;

@NoArgsConstructor
@Data
public class FoodaOrderDeliveryRes {
    private String addressSameAsBilling;
    private FoodaOrderContactRes contact;
}