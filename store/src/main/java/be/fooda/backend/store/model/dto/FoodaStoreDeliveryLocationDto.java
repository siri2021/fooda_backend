package be.fooda.backend.store.model.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "STORE_DELIVERY_LOCATION")
public class FoodaStoreDeliveryLocationDto extends FoodaAbstractDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long storeDeliveryLocationId;

    private Long municipalityId;
    private Integer deliveryTime;
    private Double deliveryCost;
}
