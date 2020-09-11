package be.fooda.backend.commons.model.template.store.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
public class FoodaStoreDeliveryCostsItemRes {
    private Double amount;
    private Double minPrice;
    private Double maxPrice;
}