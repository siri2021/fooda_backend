package be.fooda.backend.commons.model.template.store.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FoodaStoreDeliveryLocationsItemRes {
    private String country;
    private Double deliveryCost;
    private String city;
    private String municipality;
    private String deliveryTime;
    private String region;
}