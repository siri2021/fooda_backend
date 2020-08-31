package be.fooda.backend.commons.model.template.store.response;
import lombok.*;


@NoArgsConstructor
@Data
@Builder
public class FoodaStoreDeliveryCostsItemRes {
    private Double amount;
    private Double minPrice;
    private Double maxPrice;
}