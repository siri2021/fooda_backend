package be.fooda.backend.order.model.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.*;

import javax.persistence.*;
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
    private Long orderId;
    private Long paymentId;
    private BigDecimal amount;
}