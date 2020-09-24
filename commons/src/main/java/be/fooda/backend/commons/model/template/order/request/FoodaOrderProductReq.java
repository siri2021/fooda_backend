package be.fooda.backend.commons.model.template.order.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class FoodaOrderProductReq {
    private Long productId;
    private Integer quantity;
    private BigDecimal price;
}
