package be.fooda.backend.basket.service;

import be.fooda.backend.basket.model.dto.FoodaBasketUserDto;

import java.util.Optional;

public interface FoodaBasketUserService extends FoodaBasketService<FoodaBasketUserDto> {
    Optional<FoodaBasketUserDto> login(final String login, final String password);

    void logout(final Long userId);

    Boolean exists(final String login);
}
