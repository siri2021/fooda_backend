package be.fooda.backend.commons.model.template.store.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class FoodaStoreDeliveryLocationsItemRes {
    private String country;
    private Double deliveryCost;
    private String city;
    private String municipality;
    private LocalDateTime deliveryTime;
    private String region;
}