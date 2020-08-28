package be.fooda.backend.commons.model.template.product.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class FoodaProductPricesItemReq {
    private BigDecimal amount;
    private Long priceId;
    private String currency;
    private LocalDate expiry;
    private String title;
    private Boolean isDefault;
}