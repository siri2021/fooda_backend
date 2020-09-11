// FoodaOrderBillingRes.java

package be.fooda.backend.commons.model.template.order.request;

import lombok.*;

@NoArgsConstructor
@Data
public class FoodaOrderBillingReq {
    private FoodaOrderAddressReq address;
    private FoodaOrderContactReq contact;
}