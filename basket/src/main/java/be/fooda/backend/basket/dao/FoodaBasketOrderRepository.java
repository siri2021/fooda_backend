package be.fooda.backend.basket.dao;

import be.fooda.backend.basket.model.dto.FoodaBasketOrderDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodaBasketOrderRepository extends MongoRepository<FoodaBasketOrderDto, Long> {
    List<FoodaBasketOrderDto> findAllByUserId(final Long userId);
}
