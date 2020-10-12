package be.fooda.backend.store.dao;

import be.fooda.backend.store.model.dto.FoodaStoreTypeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodaStoreTypeRepository extends JpaRepository<FoodaStoreTypeDto , Long> {
}
