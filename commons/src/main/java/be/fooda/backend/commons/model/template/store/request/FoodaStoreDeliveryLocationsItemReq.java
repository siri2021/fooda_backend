package be.fooda.backend.commons.model.template.store.request;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FoodaStoreDeliveryLocationsItemReq {

    private Long municipalityId;

    private Double deliveryTime;

    private BigDecimal minOrderPrice;

    private BigDecimal maxOrderPrice;

    private BigDecimal deliveryCost;

}