package be.fooda.backend.commons.model.template.store.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FoodaStoreDeliveryCostsItemRes {
    private Double amount;
    private Double minPrice;
    private Double maxPrice;
}