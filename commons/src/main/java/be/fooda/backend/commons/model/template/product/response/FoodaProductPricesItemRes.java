package be.fooda.backend.commons.model.template.product.response;

import java.math.BigDecimal;

import lombok.*;

@NoArgsConstructor
@Data
public class FoodaProductPricesItemRes {
    private BigDecimal amount;
    private Long priceId;
    private String currency;
    private String expiry;
    private String title;
    private Boolean isDefault;
}