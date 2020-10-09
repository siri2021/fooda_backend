package be.fooda.backend.commons.model.template.store.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@Builder
public class FoodaStoreDeliveryLocationsItemRes {
    private String country;
    private BigDecimal deliveryCost;
    private String city;
    private String municipality;
    private LocalDateTime deliveryTime;
    private String region;
}