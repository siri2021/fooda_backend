package be.fooda.backend.commons.model.template.inventory.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class FoodaInventoryReq {
    private Long inventoryId;
    private FoodaInventoryProductReq product;
    private String sku;
    private String batchCode;
    private Integer stockQuantity;
}