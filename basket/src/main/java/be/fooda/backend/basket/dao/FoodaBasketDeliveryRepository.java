package be.fooda.backend.basket.dao;

import be.fooda.backend.basket.model.dto.FoodaBasketDeliveryDto;
import be.fooda.backend.basket.model.dto.FoodaBasketKeyDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodaBasketDeliveryRepository extends MongoRepository<FoodaBasketDeliveryDto, Long> {
    @Query("{userId: ?0, session: ?1, storeId: ?3}")
    List<FoodaBasketDeliveryDto> findAllByBasketKey(final FoodaBasketKeyDto key);
}
