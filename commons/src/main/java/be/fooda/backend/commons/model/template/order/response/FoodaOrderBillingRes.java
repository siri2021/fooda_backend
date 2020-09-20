// FoodaOrderBillingRes.java

package be.fooda.backend.commons.model.template.order.response;

import lombok.*;

@NoArgsConstructor
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class FoodaOrderBillingRes {
    private FoodaOrderAddressRes address;
    private FoodaOrderContactRes contact;
}