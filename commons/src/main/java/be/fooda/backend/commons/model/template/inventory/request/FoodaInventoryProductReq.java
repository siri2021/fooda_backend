package be.fooda.backend.commons.model.template.inventory.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FoodaInventoryProductReq {
    private Long productId;
    private Long storeId;
    private String name;
    private String logo;
}
