package be.fooda.backend.basket.dao;

import be.fooda.backend.basket.model.dto.FoodaBasketKeyDto;
import be.fooda.backend.basket.model.dto.FoodaBasketPaymentDto;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodaBasketPaymentRepository extends MongoRepository<FoodaBasketPaymentDto, ObjectId> {
    List<FoodaBasketPaymentDto> findAllByBasketKey(final FoodaBasketKeyDto key);

    List<FoodaBasketPaymentDto> findAllByBasketKey_UserIdAndBasketKey_Session(final Long userId, final String session);

}
