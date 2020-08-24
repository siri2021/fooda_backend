package be.fooda.backend.commons.model.template.store.request;

import lombok.*;

@Data
@Builder
public class FoodaStorePaymentMethodsItemReq {
    private String title;
    private Double minOrderAmount;
    private String expiry;
}