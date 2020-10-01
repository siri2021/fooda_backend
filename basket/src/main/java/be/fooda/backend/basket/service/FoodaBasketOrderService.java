package be.fooda.backend.basket.service;

import java.util.List;
import java.util.Optional;

public interface FoodaBasketOrderService<REQ, RES> {

    Optional<RES> getBasketOrderById(final String basketOrderId);

    Optional<RES> getBasketOrderByExample(final REQ req);

    List<RES> getBasketDeliveriesByBasketKey(final Long userId, final String session, final Long storeId);

    List<RES> getBasketDeliveriesByUser(final Long userId, final String session);

    RES addBasketOrderAndReturn(final REQ req);

    Optional<RES> editBasketOrderByIdAndReturn(final String basketOrderId, final REQ req);

    Optional<RES> editBasketOrderByExampleAndReturn(final REQ req);

    Optional<RES> removeBasketOrderByIdAndReturn(final String basketOrderId);

    Optional<RES> removeBasketOrderByExampleAndReturn(final REQ req);

    Boolean doesBasketOrderExistById(final String basketOrderId);

    Boolean doesBasketOrderExistByExample(final REQ req);
}
