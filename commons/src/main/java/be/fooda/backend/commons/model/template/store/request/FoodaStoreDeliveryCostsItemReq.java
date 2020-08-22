package be.fooda.backend.commons.model.template.store.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class FoodaStoreDeliveryCostsItemReq {

    @JsonProperty("amount")
    private Double amount;

    @JsonProperty("min_price")
    private Double minPrice;

    @JsonProperty("max_price")
    private Double maxPrice;
}