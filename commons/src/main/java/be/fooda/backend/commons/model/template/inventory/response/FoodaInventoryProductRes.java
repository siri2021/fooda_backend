package be.fooda.backend.commons.model.template.inventory.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
public class FoodaInventoryProductRes {
    private Long productId;
    private Long storeId;
    private String name;
    private String logo;
}
