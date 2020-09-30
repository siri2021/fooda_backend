// OrderedProduct.java

package be.fooda.backend.commons.model.template.order.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class FoodaOrderProductRes {
    private Long productId;
    private String name;
    private Integer quantity;
    private BigDecimal price;
    private FoodaOrderVariantRes variant;
    private String type;
}