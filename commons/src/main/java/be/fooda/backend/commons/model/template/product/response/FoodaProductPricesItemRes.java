package be.fooda.backend.commons.model.template.product.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@Data
public class FoodaProductPricesItemRes {
    private BigDecimal amount;
    private Long priceId;
    private String currency;
    private LocalDate expiry;
    private String title;
    private Boolean isDefault;
}