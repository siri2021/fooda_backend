package be.fooda.backend.commons.model.template.store.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Entity
@Table(name = "STORE_DELIVERY_LOCATION")
public class FoodaStoreDeliveryLocationDto extends FoodaAbstractDto {
    private Long municipalityId;
    private LocalTime deliveryTime;
    private Double deliveryCost;
}
