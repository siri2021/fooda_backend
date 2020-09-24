package be.fooda.backend.order.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FoodaOrderService <REQ, RES>{

    Optional<RES> getOrderByKey(final Long orderKey);

    Optional<RES> getOrderByKey(final Long orderId, final Long externalOrderId, final Long userID, final Long storeId);

    Optional<RES> getOrderByExample(final REQ orderReq);

    List<RES> getAllOrders();

    List<RES> getOrdersByStatusId(final Long statusId);

    List<RES> getOrdersByRequiredTime(final LocalDateTime requiredTime);

    List<RES> getOrdersByDeliveryTime(final LocalDateTime deliveryTime);

    List<RES> getOrdersByPaymentTime(final LocalDateTime paymentTime);

    List<RES> getOrdersByPaymentId(final Long paymentId);

    List<RES> getOrdersByPaymentAmount(final BigDecimal amount);

    List<RES> getOrdersByPaymentAmount(final BigDecimal minAmount, final BigDecimal maxAmount);

    List<RES> getOrdersByStoreId(final Long storeId);

    List<RES> getOrdersByUserId(final Long userId);

    List<RES> getOrdersByProductKey(final Long productKey);

    Optional<RES> addOrder(final REQ req);

    Optional<RES> editOrderByKey(final Long orderKey, REQ orderREQ);

    Optional<RES> editOrderByKey(final Long orderId, final Long externalOrderId, final Long userID, final Long storeId, REQ orderREQ);

    Optional<RES> editOrderByExample(final REQ orderReq);

    Optional<RES> removeOrderByKey(final Long orderId, final Long externalOrderId, final Long userID, final Long storeId);

    Optional<RES> removeOrderByKey(final Long orderKey);

    Optional<RES> removeOrderByExample(final REQ orderReq);

    Boolean doesOrderExistsByKey(final Long orderKey);

    Boolean doesOrderExistsByKey(final Long orderId, final Long externalOrderId, final Long userID, final Long storeId);

    Boolean doesOrderExistsByExample(final REQ orderReq);

}
