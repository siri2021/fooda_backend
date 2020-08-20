package be.fooda.backend.commons.model.template.product.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Embeddable
public class FoodaProductKeyDto extends FoodaAbstractDto {
    private Long storeId;
    private Long productId;
}
