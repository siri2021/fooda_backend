package be.fooda.backend.store.dao;

import be.fooda.backend.store.model.dto.FoodaStoreContactDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodaStoreContactRepository extends JpaRepository<FoodaStoreContactDto, Long> {
}
