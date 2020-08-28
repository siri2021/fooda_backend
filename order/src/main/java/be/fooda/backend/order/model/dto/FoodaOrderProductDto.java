package be.fooda.backend.order.model.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import be.fooda.backend.product.model.dto.FoodaProductKeyDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ORDER_PRODUCT")
public class FoodaOrderProductDto extends FoodaAbstractDto{
    private FoodaProductKeyDto productKey;
    private Integer quantity;
    private BigDecimal price;
}