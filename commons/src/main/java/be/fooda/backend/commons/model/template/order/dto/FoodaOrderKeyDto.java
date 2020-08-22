package be.fooda.backend.commons.model.order;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;

import lombok.*;
import javax.persistance.*;

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