package be.fooda.backend.basket.dao;

import be.fooda.backend.basket.model.dto.FoodaBasketKeyDto;
import be.fooda.backend.basket.model.dto.FoodaBasketOrderDto;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodaBasketOrderRepository extends MongoRepository<FoodaBasketOrderDto, ObjectId> {
    List<FoodaBasketOrderDto> findAllByBasketKey(final FoodaBasketKeyDto key);

    List<FoodaBasketOrderDto> findAllByBasketKey_UserIdAndBasketKey_Session(final Long userId, final String session);
}
