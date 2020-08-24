package be.fooda.backend.commons.model.template.order.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Embeddable
public class FoodaOrderKeyDto extends FoodaAbstractDto {
    private Long orderId;
    private Long userId;
    private Long storeId;
    private String sessionId;
}