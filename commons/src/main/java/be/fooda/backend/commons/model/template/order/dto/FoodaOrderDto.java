package be.fooda.backend.commons.model.template.order.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.EmbeddedId;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class FoodaOrderDto{
    @EmbeddedId
    private FoodaOrderKeyDto orderKey;
    private FoodaOrderStatusDto orderStatus;
    private String note;
    private LocalDateTime requiredTime;
    private LocalDateTime deliveryTime;
    private LocalDateTime paymentTime;
    private BigDecimal productsTotal;
    private BigDecimal taxTotal;
    private BigDecimal deliveryTotal;
    private BigDecimal priceTotal;
    private List<FoodaOrderPaymentDto> payments;
}