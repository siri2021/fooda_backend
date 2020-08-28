package be.fooda.backend.commons.model.template.store.request;

import lombok.*;

import java.time.LocalTime;

@Data
@Builder
public class FoodaStoreDeliveryLocationsItemReq {
    private String country;
    private Double deliveryCost;
    private String city;
    private String municipality;
    private LocalTime deliveryTime;
    private String region;
}