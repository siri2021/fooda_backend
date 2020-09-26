package be.fooda.backend.order.model.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class FoodaOrderPaymentDto extends FoodaAbstractDto {
    @Id
    @GeneratedValue
    private Long orderPaymentId;
    private FoodaOrderKeyDto orderKey;
    private Long paymentId;
    private BigDecimal amount;
}