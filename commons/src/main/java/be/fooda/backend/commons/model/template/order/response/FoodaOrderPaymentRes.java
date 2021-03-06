// FoodaOrderPaymentRes.java

package be.fooda.backend.commons.model.template.order.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class FoodaOrderPaymentRes {
    private Long orderPaymentId;
    private Long paymentId;
    private String title;
    private String method;
    private BigDecimal amount;
}