package be.fooda.backend.commons.model.template.order.dto;

import be.fooda.backend.commons.model.order.FoodaOrderKeyDto;
import be.fooda.backend.commons.model.template.product.dto.FoodaProductKeyDto;

import lombok.*;
import javax.persistance.*;

@Data
@Builder
@Entity
@Table(name = "ORDER_PRODUCT")
public class FoodaOrderProductDto {
    private FoodaProductKeyDto productKey;
    private Integer quantity;
    private BigDecimal price;
}