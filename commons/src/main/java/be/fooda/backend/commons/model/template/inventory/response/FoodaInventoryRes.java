package be.fooda.backend.commons.model.template.inventory.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FoodaInventoryRes {
    private Long inventoryId;
    private FoodaInventoryProductRes product;
    private String sku;
    private String batchCode;
    private Integer stockQuantity;
}