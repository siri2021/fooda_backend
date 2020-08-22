package be.fooda.backend.commons.model.template.store.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class FoodaStoreDeliveryLocationsItemReq {

    @JsonProperty("country")
    private String country;

    @JsonProperty("delivery_cost")
    private Double deliveryCost;

    @JsonProperty("city")
    private String city;

    @JsonProperty("municipality")
    private String municipality;

    @JsonProperty("delivery_time")
    private String deliveryTime;

    @JsonProperty("region")
    private String region;
}