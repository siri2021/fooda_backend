package be.fooda.backend.order.model.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.*;

import javax.persistence.Embeddable;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class FoodaOrderKeyDto extends FoodaAbstractDto {
    private Long orderId;
    private Long externalOrderId;
    private Long userId;
    private Long storeId;
}