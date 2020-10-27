package be.fooda.backend.store.dao;

import be.fooda.backend.store.model.dto.FoodaStoreDeliveryLocationDto;
import be.fooda.backend.store.model.dto.FoodaStoreDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodaStoreDeliveryLocationRepository extends JpaRepository<FoodaStoreDeliveryLocationDto , Long> {
    @Query("SELECT sdl FROM FoodaStoreDeliveryLocationDto sdl WHERE sdl.municipalityId = :municipalityId")
    List<FoodaStoreDeliveryLocationDto> findByDeliveryLocation(@Param("municipalityId") final Long municipalityId);

    @Query("SELECT sdl FROM FoodaStoreDeliveryLocationDto sdl WHERE sdl.deliveryTime = :timeAsMinutes")
    List<FoodaStoreDeliveryLocationDto> findByDeliveryTime(@Param("timeAsMinutes") final Integer timeAsMinutes);
}
