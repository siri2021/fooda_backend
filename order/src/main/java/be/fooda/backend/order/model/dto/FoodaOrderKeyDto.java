package be.fooda.backend.order.model.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class FoodaOrderKeyDto extends FoodaAbstractDto {
    @Id
    private Long orderKeyId;
    private Long externalOrderId;
    private Long userId;
    private Long storeId;
}