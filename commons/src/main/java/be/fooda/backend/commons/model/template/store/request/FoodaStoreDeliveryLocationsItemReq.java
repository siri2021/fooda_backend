package be.fooda.backend.commons.model.template.store.request;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class FoodaStoreDeliveryLocationsItemReq {
    private String country;
    private BigDecimal deliveryCost;
    private String city;
    private String municipality;
    private LocalDateTime deliveryTime;
    private String region;
}