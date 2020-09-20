package be.fooda.backend.basket.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FoodaBasketPaymentService<REQ, RES> {

    Optional<RES> getBasketPaymentById(final String basketPaymentId);

    Optional<RES> getBasketPaymentByExample(final REQ req);

    List<RES> getBasketDeliveriesByBasketKey(final Long userId, final String session, final Long storeId);

    List<RES> getBasketDeliveriesByUser(final Long userId, final String session);

    RES addBasketPaymentAndReturn(final REQ req);

    Optional<RES> editBasketPaymentByIdAndReturn(final String basketPaymentId, final REQ req);

    Optional<RES> editBasketPaymentByExampleAndReturn(final REQ req);

    Optional<RES> removeBasketPaymentByIdAndReturn(final String basketPaymentId);

    Optional<RES> removeBasketPaymentByExampleAndReturn(final REQ req);

    Boolean doesBasketPaymentExistById(final String basketPaymentId);

    Boolean doesBasketPaymentExistByExample(final REQ req);
}
