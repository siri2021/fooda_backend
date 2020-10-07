package be.fooda.backend.store.dao;

import be.fooda.backend.store.model.dto.FoodaStoreDeliveryCostDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodaStoreDeliveryCostRepository extends JpaRepository<FoodaStoreDeliveryCostDto, Long> {
}
