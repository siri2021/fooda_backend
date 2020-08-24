package be.fooda.backend.commons.model.template.product.request;

import java.math.BigDecimal;

import lombok.*;

@Data
@Builder
public class FoodaProductPricesItemReq {
    private BigDecimal amount;
    private Long priceId;
    private String currency;
    private String expiry;
    private String title;
    private Boolean isDefault;
}