package be.fooda.backend.store.service;

import java.math.BigDecimal;
import java.util.List;

public interface FoodaStoreDeliveryCostService<REQ,RES> {
    List<RES> getStoreByDeliveryCost(final BigDecimal minPrice, final BigDecimal maxPrice, BigDecimal amount);

    List<RES> getStoreByDeliveryCost(final BigDecimal minPrice, final BigDecimal maxPrice);
}
