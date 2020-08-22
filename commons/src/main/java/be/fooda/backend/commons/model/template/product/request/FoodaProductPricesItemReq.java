package be.fooda.backend.commons.model.template.product.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class FoodaProductPricesItemReq {

    @JsonProperty("amount")
    private Double amount;

    @JsonProperty("price_id")
    private Integer priceId;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("expiry")
    private String expiry;

    @JsonProperty("title")
    private String title;
}