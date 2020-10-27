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
   @Query("SELECT s FROM FoodaStoreDto s WHERE s.type.id = :storeTypeId")
    List<FoodaStoreDto> findByType(@Param("storeTypeId") final Long storeTypeId);

    @Query("SELECT s FROM FoodaStoreDto s WHERE s.type.title = :storeTypeTitle")
    List<FoodaStoreDto> findByType(@Param("storeTypeTitle") final String storeTypeTitle);


}
