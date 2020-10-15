package be.fooda.backend.store.dao;

import be.fooda.backend.store.model.dto.FoodaStoreDeliveryCostDto;
import be.fooda.backend.store.model.dto.FoodaStoreDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface FoodaStoreDeliveryCostRepository extends JpaRepository<FoodaStoreDeliveryCostDto, Long> {
    @Query("SELECT sdc FROM FoodaStoreDeliveryCostDto sdc WHERE sdc.minPrice = : minPrice AND sdc.maxPrice =: maxPrice")
    List<FoodaStoreDto> findByDeliveryCost(final BigDecimal minPrice, final BigDecimal maxPrice);

    @Query("SELECT sdc FROM FoodaStoreDeliveryCostDto sdc WHERE sdc.minPrice = : minPrice AND sdc.maxPrice =: maxPrice AND sdc.amount = :amount")
    List<FoodaStoreDto> findByDeliveryCost(final BigDecimal minPrice, final BigDecimal maxPrice, final BigDecimal amount);

}
