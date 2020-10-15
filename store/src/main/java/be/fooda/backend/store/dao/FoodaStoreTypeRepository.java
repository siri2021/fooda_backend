package be.fooda.backend.store.dao;

import be.fooda.backend.store.model.dto.FoodaStoreDto;
import be.fooda.backend.store.model.dto.FoodaStoreTypeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodaStoreTypeRepository extends JpaRepository<FoodaStoreTypeDto , Long> {
    List<FoodaStoreDto> findByType(final FoodaStoreTypeDto type);

    @Query("SELECT s FROM FoodaStoreDto s WHERE s.type.title = :title")
    List<FoodaStoreDto> findByType(@Param("title") final String title);
}
