package be.fooda.backend.commons.model.template.basket.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class FoodaBasketPaymentReq {
    private Long userId;
    private String session;
    private Long storeId;
    private Long paymentId;
    private BigDecimal amount;
}
