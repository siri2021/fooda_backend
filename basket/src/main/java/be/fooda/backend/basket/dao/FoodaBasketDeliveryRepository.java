package be.fooda.backend.basket.dao;

import be.fooda.backend.basket.model.dto.FoodaBasketDeliveryDto;
import be.fooda.backend.basket.model.dto.FoodaBasketKeyDto;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodaBasketDeliveryRepository extends MongoRepository<FoodaBasketDeliveryDto, ObjectId> {
    List<FoodaBasketDeliveryDto> findAllByBasketKey(final FoodaBasketKeyDto key);

    List<FoodaBasketDeliveryDto> findAllByBasketKey_UserIdAndBasketKey_Session(final Long userId, final String session);

}
