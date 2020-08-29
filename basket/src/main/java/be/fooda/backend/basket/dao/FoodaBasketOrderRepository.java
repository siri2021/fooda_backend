package be.fooda.backend.basket.dao;

import be.fooda.backend.basket.model.dto.FoodaBasketOrderDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodaBasketOrderRepository extends MongoRepository<FoodaBasketOrderDto, Long> {
    Page<FoodaBasketOrderDto> findAllByUserId(final Long userId, Pageable page);
}
