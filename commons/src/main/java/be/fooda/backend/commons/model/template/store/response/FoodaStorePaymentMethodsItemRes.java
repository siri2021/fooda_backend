package be.fooda.backend.commons.model.template.store.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Builder

public class FoodaStorePaymentMethodsItemRes {
    private String title;
    private BigDecimal minOrderAmount;
    private LocalDate expiry;
}