package be.fooda.backend.commons.model.template.order.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;

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