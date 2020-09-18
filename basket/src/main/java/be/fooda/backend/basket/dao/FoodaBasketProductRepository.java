package be.fooda.backend.basket.dao;

import be.fooda.backend.basket.model.dto.FoodaBasketKeyDto;
import be.fooda.backend.basket.model.dto.FoodaBasketProductDto;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodaBasketProductRepository extends MongoRepository<FoodaBasketProductDto, ObjectId> {
    @Query("{key: ?0}")
    List<FoodaBasketProductDto> findAllByKey(final FoodaBasketKeyDto key);

    @Query("{key.userId: ?0, key.session: ?1}")
    List<FoodaBasketProductDto> findAllByUser(final Long userId, final String session);

    List<FoodaBasketProductDto> findAllByKey_UserIdAndKey_Session(final Long userId, final String session);

}
