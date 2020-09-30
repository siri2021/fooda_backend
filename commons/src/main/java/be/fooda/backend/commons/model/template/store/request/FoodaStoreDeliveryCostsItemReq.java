package be.fooda.backend.commons.model.template.store.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder(toBuilder = true)
public class FoodaStoreDeliveryCostsItemReq {
    private BigDecimal amount;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
}