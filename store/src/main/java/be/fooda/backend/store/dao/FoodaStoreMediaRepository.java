package be.fooda.backend.store.dao;

import be.fooda.backend.store.model.dto.FoodaStoreMediaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodaStoreMediaRepository extends JpaRepository<FoodaStoreMediaDto, Long> {
}
