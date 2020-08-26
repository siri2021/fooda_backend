package be.fooda.backend.commons.model.template.store.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FoodaStorePaymentMethodsItemRes {
    private String title;
    private Double minOrderAmount;
    private String expiry;
}