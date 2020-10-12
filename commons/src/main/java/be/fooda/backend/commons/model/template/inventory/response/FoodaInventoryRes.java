package be.fooda.backend.commons.model.template.inventory.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class FoodaInventoryRes {
    private Long inventoryId;
    private FoodaInventoryProductRes product;
    private String sku;
    private String batchCode;
    private Integer stockQuantity;
}