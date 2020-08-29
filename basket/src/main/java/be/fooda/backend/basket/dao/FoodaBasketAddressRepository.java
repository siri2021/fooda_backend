package be.fooda.backend.basket.dao;

import be.fooda.backend.basket.model.dto.FoodaBasketAddressDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodaBasketAddressRepository extends MongoRepository<FoodaBasketAddressDto, Long> {
    Page<FoodaBasketAddressDto> findAllByUserId(final Long userId, Pageable page);
}
