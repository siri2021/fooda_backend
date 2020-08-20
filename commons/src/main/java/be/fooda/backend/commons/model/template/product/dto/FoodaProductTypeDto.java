package be.fooda.backend.commons.model.template.product.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class FoodaProductTypeDto extends FoodaAbstractDto {
    private Long typeId;
    private String title;
}
