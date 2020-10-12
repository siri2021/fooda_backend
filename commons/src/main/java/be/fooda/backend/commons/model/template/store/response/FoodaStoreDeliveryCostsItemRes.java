package be.fooda.backend.commons.model.template.store.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class FoodaStoreDeliveryCostsItemRes {
    private BigDecimal amount;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
}