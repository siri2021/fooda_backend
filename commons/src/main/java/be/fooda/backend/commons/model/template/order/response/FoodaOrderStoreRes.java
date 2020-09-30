// FoodaOrderStoreRes.java

package be.fooda.backend.commons.model.template.order.response;

import lombok.*;

@NoArgsConstructor
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class FoodaOrderStoreRes {
    private Long storeId;
    private String name;
    private String logo;
    private FoodaOrderAddressRes address;
    private FoodaOrderContactRes contact;
}
