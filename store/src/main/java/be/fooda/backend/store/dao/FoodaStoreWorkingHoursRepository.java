package be.fooda.backend.store.dao;

import be.fooda.backend.store.model.dto.FoodaStoreWorkingHoursDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodaStoreWorkingHoursRepository extends JpaRepository<FoodaStoreWorkingHoursDto, Long> {
}
