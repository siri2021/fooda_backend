package be.fooda.backend.commons.model.template.order.dto;

@Data
@Builder
@Entity
@Table(name = "ORDER_PAYMENT")
public class FoodaOrderPaymentDto {
    private Long paymentId;
    private BigDecimal amount;
}