package be.fooda.backend.commons.model.template.store.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class FoodaStorePaymentMethodsItemReq {

    @JsonProperty("title")
    private String title;

    @JsonProperty("min_order_amount")
    private Double minOrderAmount;

    @JsonProperty("expiry")
    private String expiry;
}