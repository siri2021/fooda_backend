package be.fooda.backend.store.dao;

import be.fooda.backend.store.model.dto.FoodaStoreDeliveryLocationDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodaStoreDeliveryLocationRepository extends JpaRepository<FoodaStoreDeliveryLocationDto , Long> {
}
