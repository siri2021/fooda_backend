package be.fooda.backend.commons.model.template.store.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@Builder

public class FoodaStorePaymentMethodsItemRes {
    private String title;
    private Double minOrderAmount;
    private LocalDate expiry;
}