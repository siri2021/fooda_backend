package be.fooda.backend.order.service.impl;

import be.fooda.backend.commons.model.template.order.request.FoodaOrderReq;
import be.fooda.backend.commons.model.template.order.response.FoodaOrderRes;
import be.fooda.backend.order.service.FoodaOrderService;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class FoodaOrderServiceImpl implements FoodaOrderService<FoodaOrderReq, FoodaOrderRes> {
    @Override
    public Optional<FoodaOrderRes> getOrderByKey(Long orderKey) {
        return Optional.empty();
    }

    @Override
    public Optional<FoodaOrderRes> getOrderByKey(Long orderId, Long externalOrderId, Long userID, Long storeId) {
        return Optional.empty();
    }

    @Override
    public Optional<FoodaOrderRes> getOrderByExample(Long orderReq) {
        return Optional.empty();
    }

    @Override
    public List<FoodaOrderRes> getAllOrders() {
        return null;
    }

    @Override
    public List<FoodaOrderRes> getOrdersByStatusId(Long statusId) {
        return null;
    }

    @Override
    public List<FoodaOrderRes> getOrdersByNote(String name) {
        return null;
    }

    @Override
    public List<FoodaOrderRes> getOrdersByRequiredTime(LocalDateTime requiredTime) {
        return null;
    }

    @Override
    public List<FoodaOrderRes> getOrdersByDeliveryTime(LocalDateTime deliveryTime) {
        return null;
    }

    @Override
    public List<FoodaOrderRes> getOrdersByPaymentTime(LocalDateTime paymentTime) {
        return null;
    }

    @Override
    public List<FoodaOrderRes> getOrdersByPaymentId(Long paymentId) {
        return null;
    }

    @Override
    public List<FoodaOrderRes> getOrdersByPaymentAmount(BigDecimal amount) {
        return null;
    }

    @Override
    public List<FoodaOrderRes> getOrdersByStoreId(Long storeId) {
        return null;
    }

    @Override
    public List<FoodaOrderRes> getOrdersByUserId(Long userId) {
        return null;
    }

    @Override
    public List<FoodaOrderRes> getOrdersBySessionId(Long sessionId) {
        return null;
    }

    @Override
    public List<FoodaOrderRes> getOrdersByProductKey(Long productKey) {
        return null;
    }

    @Override
    public Optional<FoodaOrderRes> addOrder(FoodaOrderReq foodaOrderReq) {
        return Optional.empty();
    }

    @Override
    public Optional<FoodaOrderRes> editOrderByKey(Long orderId, Long externalOrderId, Long userID, Long storeId) {
        return Optional.empty();
    }

    @Override
    public Optional<FoodaOrderRes> editOrderByExample(FoodaOrderReq orderReq) {
        return Optional.empty();
    }

    @Override
    public Optional<FoodaOrderRes> removeOrderByKey(Long orderId, Long externalOrderId, Long userID, Long storeId) {
        return Optional.empty();
    }

    @Override
    public Optional<FoodaOrderRes> removeOrderByExample(FoodaOrderReq orderReq) {
        return Optional.empty();
    }

    @Override
    public Boolean doesOrderExistsByKey(Long orderKey) {
        return null;
    }

    @Override
    public Boolean doesOrderExistsByKey(Long orderId, Long externalOrderId, Long userID, Long storeId) {
        return null;
    }

    @Override
    public Boolean doesOrderExistsByExample(FoodaOrderReq orderReq) {
        return null;
    }
}
