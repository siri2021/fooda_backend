package be.fooda.backend.commons.model.template.store.request;

import lombok.*;
@Data
@Builder
public class FoodaStoreDeliveryLocationsItemReq {
    private String country;
    private Double deliveryCost;
    private String city;
    private String municipality;
    private String deliveryTime;
    private String region;
}