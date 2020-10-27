package be.fooda.backend.commons.model.template.store.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class FoodaStoreDeliveryLocationsItemRes {
    private Long municipalityId;
    private String city;
    private String region;
    private String country;
    private Double deliveryTime;
    private BigDecimal minOrderPrice;
    private BigDecimal maxOrderPrice;
    private BigDecimal deliveryCost;

}