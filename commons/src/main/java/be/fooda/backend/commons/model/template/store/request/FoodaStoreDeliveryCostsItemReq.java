package be.fooda.backend.commons.model.template.store.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class FoodaStoreDeliveryCostsItemReq {
    private Double amount;
    private Double minPrice;
    private Double maxPrice;
}