package be.fooda.backend.commons.model.template.store.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Entity
@Table(name = "STORE_DELIVERY_COST")
public class FoodaStoreDeliveryCostDto extends FoodaAbstractDto {
    private Double minPrice;
    private Double maxPrice;
    private Double amount;
}
