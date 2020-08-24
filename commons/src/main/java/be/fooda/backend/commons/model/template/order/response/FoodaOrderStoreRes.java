// FoodaOrderStoreRes.java

package be.fooda.backend.commons.model.template.order.response;

import lombok.*;

@NoArgsConstructor
@Data
public class FoodaOrderStoreRes {
    private long storeID;
    private String name;
    private String logo;
    private FoodaOrderAddressRes address;
    private FoodaOrderContactRes contact;
}
