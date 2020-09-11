package be.fooda.backend.basket.dao;

import be.fooda.backend.basket.model.dto.FoodaBasketDeliveryDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodaBasketDeliveryRepository extends MongoRepository<FoodaBasketDeliveryDto, Long> {
    List<FoodaBasketDeliveryDto> findAllByUserId(final Long userId);
}
