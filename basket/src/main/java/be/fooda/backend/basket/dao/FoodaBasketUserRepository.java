package be.fooda.backend.basket.dao;

import be.fooda.backend.basket.model.dto.FoodaBasketUserDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodaBasketUserRepository extends MongoRepository<FoodaBasketUserDto, Long> {
    Optional<FoodaBasketUserDto> findByLogin(final String login);

    Boolean existsByLogin(final String login);
}
