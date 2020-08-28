package be.fooda.backend.commons.model.template.store.request;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
public class FoodaStorePaymentMethodsItemReq {
    private String title;
    private Double minOrderAmount;
    private LocalDate expiry;
}