package be.fooda.backend.basket.dao;

import be.fooda.backend.basket.model.dto.FoodaBasketPaymentDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodaBasketPaymentRepository extends MongoRepository<FoodaBasketPaymentDto, Long> {
    List<FoodaBasketPaymentDto> findAllByUserId(final Long userId);
}
