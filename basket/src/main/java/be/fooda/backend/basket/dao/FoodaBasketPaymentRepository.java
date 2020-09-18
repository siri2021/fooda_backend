package be.fooda.backend.basket.dao;

import be.fooda.backend.basket.model.dto.FoodaBasketKeyDto;
import be.fooda.backend.basket.model.dto.FoodaBasketPaymentDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodaBasketPaymentRepository extends MongoRepository<FoodaBasketPaymentDto, Long> {
    @Query("{userId: ?0, session: ?1, storeId: ?3}")
    List<FoodaBasketPaymentDto> findAllByBasketKey(final FoodaBasketKeyDto key);
}
