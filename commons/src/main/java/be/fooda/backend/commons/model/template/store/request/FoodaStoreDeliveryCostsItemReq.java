package be.fooda.backend.commons.model.template.store.request;

import lombok.*;

@Data
@Builder
public class FoodaStoreDeliveryCostsItemReq {
    private Double amount;
    private Double minPrice;
    private Double maxPrice;
}