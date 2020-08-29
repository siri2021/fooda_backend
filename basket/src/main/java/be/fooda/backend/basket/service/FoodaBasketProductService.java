package be.fooda.backend.basket.service;

import be.fooda.backend.basket.model.dto.FoodaBasketProductDto;

public interface FoodaBasketProductService extends FoodaBasketService<FoodaBasketProductDto> {
    void increase(final FoodaBasketProductDto product);

    void increase(final Long productId, final Long storeId);

    void decrease(final FoodaBasketProductDto product);

    void decrease(final Long productId, final Long storeId);

    void clear(final Long userId, final String session);
}
