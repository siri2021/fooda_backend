package be.fooda.backend.basket.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FoodaBasketDeliveryService<REQ, RES> {

    Optional<RES> getBasketDeliveryById(final String basketDeliveryId);

    Optional<RES> getBasketDeliveryByExample(final REQ req);

    List<RES> getBasketDeliveriesByBasketKey(final Long userId, final String session, final Long storeId);

    List<RES> getBasketDeliveriesByUser(final Long userId, final String session);

    RES addBasketDeliveryAndReturn(final REQ req);

    Optional<RES> editBasketDeliveryByIdAndReturn(final String basketDeliveryId, final REQ req);

    Optional<RES> editBasketDeliveryByExampleAndReturn(final REQ req);

    Optional<RES> removeBasketDeliveryByIdAndReturn(final String basketDeliveryId);

    Optional<RES> removeBasketDeliveryByExampleAndReturn(final REQ req);

    Boolean doesBasketDeliveryExistById(final String basketDeliveryId);

    Boolean doesBasketDeliveryExistByExample(final REQ req);
}
