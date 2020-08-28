package be.fooda.backend.product.model.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.*;

import javax.persistence.Embeddable;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class FoodaProductKeyDto extends FoodaAbstractDto {
    private Long storeId;
    private Long productId;
}
