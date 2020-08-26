package be.fooda.backend.commons.model.template.order.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Entity
@Table(name = "ORDER_PAYMENT")
public class FoodaOrderPaymentDto extends FoodaAbstractDto{
    private Long paymentId;
    private BigDecimal amount;
}