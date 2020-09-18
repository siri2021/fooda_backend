package be.fooda.backend.basket.dao;

import be.fooda.backend.basket.model.dto.FoodaBasketKeyDto;
import be.fooda.backend.basket.model.dto.FoodaBasketProductDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodaBasketProductRepository extends MongoRepository<FoodaBasketProductDto, Long> {
    @Query("{userId: ?0, session: ?1, storeId: ?3}")
    List<FoodaBasketProductDto> findAllByBasketKey(final FoodaBasketKeyDto key);
}
