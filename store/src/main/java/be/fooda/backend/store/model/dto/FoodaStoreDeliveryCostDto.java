package be.fooda.backend.store.model.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
public class FoodaStoreDeliveryCostDto extends FoodaAbstractDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long storeDeliveryCostId;
    private Double minPrice;
    private Double maxPrice;
    private Double amount;
}
