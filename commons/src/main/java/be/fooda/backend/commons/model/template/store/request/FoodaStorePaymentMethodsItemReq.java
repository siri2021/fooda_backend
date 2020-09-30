package be.fooda.backend.commons.model.template.store.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
public class FoodaStorePaymentMethodsItemReq {
    private String title;
    private BigDecimal minOrderAmount;
    private LocalDate expiry;
}