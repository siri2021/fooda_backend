package be.fooda.backend.order.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public interface FoodaOrderService <REQ, RES>{

    Optional<RES> getById(final Long orderId);

    List<RES> getAll();

    Optional<RES> getByExample(final REQ orderReq);

    List<RES> getByStatusId(final Long statusId);

    List<RES> getByRequiredTime(final LocalDateTime requiredTime);

    List<RES> getByDeliveryTime(final LocalDateTime deliveryTime);

    List<RES> getByPaymentTime(final LocalDateTime paymentTime);

    List<RES> getByPaymentId(final Long userId, final Long paymentId);

    List<RES> getByPaymentAmount(final BigDecimal amount);

    List<RES> getByPaymentAmount(final BigDecimal minAmount, final BigDecimal maxAmount);

    List<RES> getByStoreId(final Long storeId);

    List<RES> getByUserId(final Long userId);

    Optional<RES> add(final REQ req);

    Optional<RES> editById(final Long orderId, REQ orderREQ);

    Optional<RES> editByExample(final REQ orderReq);

    Optional<RES> removeById(final Long orderId);

    List<RES> removeByUserId(final Long userId);

    Optional<RES> removeByExample(final REQ orderReq);

    Boolean existsById(final Long orderId);

    Boolean existsByExample(final REQ orderReq);

}
