package be.fooda.backend.commons.model.template.product.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class FoodaProductPricesItemRes {
    private BigDecimal amount;
    private Long priceId;
    private String currency;
    private LocalDate expiry;
    private String title;
    private Boolean isDefault;
}