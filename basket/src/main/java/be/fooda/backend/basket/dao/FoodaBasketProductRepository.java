package be.fooda.backend.basket.dao;

import be.fooda.backend.basket.model.dto.FoodaBasketProductDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodaBasketProductRepository extends MongoRepository<FoodaBasketProductDto, Long> {
    List<FoodaBasketProductDto> findAllByUserId(final Long userId);
}
