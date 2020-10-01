package be.fooda.backend.basket.service;

import java.util.List;
import java.util.Optional;

public interface FoodaBasketProductService<REQ, RES> {

    Optional<RES> getBasketProductById(final String basketProductId);

    Optional<RES> getBasketProductByExample(final REQ req);

    List<RES> getBasketProductsByBasketKey(final Long userId, final String session, final Long storeId);

    List<RES> getBasketProductsByUser(final Long userId, final String session);

    Optional<RES> addBasketProductAndReturn(final REQ req);

    Optional<RES> editBasketProductByIdAndReturn(final String basketProductId, final REQ req);

    Optional<RES> increaseBasketProductQuantityByIdAndReturn(final String basketProductId, final Integer quantity);

    Optional<RES> decreaseBasketProductQuantityByIdAndReturn(final String basketProductId, final Integer quantity);

    Optional<RES> editBasketProductByExampleAndReturn(final REQ req);

    Optional<RES> removeBasketProductByIdAndReturn(final String basketProductId);

    Optional<RES> removeBasketProductByExampleAndReturn(final REQ req);

    Boolean doesBasketProductExistById(final String basketProductId);

    Boolean doesBasketProductExistByExample(final REQ req);
}
