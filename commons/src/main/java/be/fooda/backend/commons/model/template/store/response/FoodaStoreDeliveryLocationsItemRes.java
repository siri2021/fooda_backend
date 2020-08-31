package be.fooda.backend.commons.model.template.store.response;


import lombok.*;

import java.time.LocalTime;

@NoArgsConstructor
@Data
@Builder
public class FoodaStoreDeliveryLocationsItemRes {
    private String country;
    private Double deliveryCost;
    private String city;
    private String municipality;
    private LocalTime deliveryTime;
    private String region;
}