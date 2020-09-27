package be.fooda.backend.order.service.impl;

import be.fooda.backend.commons.model.template.order.request.FoodaOrderReq;
import be.fooda.backend.commons.model.template.order.response.FoodaOrderRes;
import be.fooda.backend.commons.model.template.order.response.FoodaOrderStoreRes;
import be.fooda.backend.commons.service.mapper.FoodaOrderHttpMapper;
import be.fooda.backend.order.dao.FoodaOrderRepository;
import be.fooda.backend.order.model.dto.FoodaOrderDto;
import be.fooda.backend.order.service.FoodaOrderService;
import be.fooda.backend.order.service.mapper.FoodaOrderDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class FoodaOrderServiceImpl implements FoodaOrderService<FoodaOrderReq, FoodaOrderRes> {

    private final FoodaOrderRepository orderRepository;
    private final FoodaOrderDtoMapper orderDtoMapper;
    private final FoodaOrderHttpMapper orderHttpMapper;

    @Override
    public Optional<FoodaOrderRes> getOrderByKey(Long orderKeyId) {
        return orderRepository.findByOrderKey_OrderKeyId(orderKeyId).map(orderDtoMapper :: dtoToResponse);
    }

    @Override
    public Optional<FoodaOrderRes> getOrderByKey(Long externalOrderId, Long userID, Long storeId) {
        return orderRepository.findByOrderKey_ExternalOrderIdAndOrderKey_UserIdAndOrderKey_StoreId(externalOrderId, userID, storeId)
                              .map(orderDtoMapper :: dtoToResponse);
    }

    @Override
    public Optional<FoodaOrderRes> getOrderByExample(FoodaOrderReq orderReq) {
        return orderRepository.findByExample(orderReq).map(orderDtoMapper:: dtoToResponse) ;
    }

    @Override
    public List<FoodaOrderRes> getAllOrders() {
        List<FoodaOrderDto> results = new ArrayList<>();
        orderRepository.findAll().forEach(results :: add);
        return results.stream()
                      .map(orderDtoMapper :: dtoToResponse)
                      .collect(Collectors.toList());
    }

    @Override
    public List<FoodaOrderRes> getOrdersByStatusId(Long statusId) {
        return orderRepository.findByStatusId(statusId)
                              .stream()
                              .map(orderDtoMapper :: dtoToResponse)
                              .collect(Collectors.toList());
    }

    @Override
    public List<FoodaOrderRes> getOrdersByRequiredTime(LocalDateTime requiredTime) {
        return orderRepository.findByRequiredTime(requiredTime)
                .stream()
                .map(orderDtoMapper :: dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaOrderRes> getOrdersByDeliveryTime(LocalDateTime deliveryTime) {
        return orderRepository.findByDeliveryTime(deliveryTime)
                .stream()
                .map(orderDtoMapper :: dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaOrderRes> getOrdersByPaymentTime(LocalDateTime paymentTime) {
        return orderRepository.findByPaymentTime(paymentTime)
                .stream()
                .map(orderDtoMapper :: dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaOrderRes> getOrdersByPaymentId(Long paymentId) {
        return orderRepository.findByPaymentId(paymentId)
                .stream()
                .map(orderDtoMapper :: dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaOrderRes> getOrdersByPaymentAmount(BigDecimal amount) {
        return orderRepository.findByPaymentAmount(amount)
                .stream()
                .map(orderDtoMapper :: dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaOrderRes> getOrdersByPaymentAmount(BigDecimal minAmount, BigDecimal maxAmount) {
        return orderRepository.findByPaymentAmount(minAmount, maxAmount)
                .stream()
                .map(orderDtoMapper :: dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaOrderRes> getOrdersByStoreId(Long storeId) {
        return orderRepository.findByOrderKey_StoreId(storeId)
                .stream()
                .map(orderDtoMapper :: dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaOrderRes> getOrdersByUserId(Long userId) {
        return orderRepository.findByOrderKey_UserId(userId)
                .stream()
                .map(orderDtoMapper :: dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaOrderRes> getOrdersByProductKey(Long productKey) {

        return orderRepository.findByProductKey(productKey)
                .stream()
                .map(orderDtoMapper :: dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<FoodaOrderRes> addOrder(FoodaOrderReq foodaOrderReq) {
        return Optional.of(orderDtoMapper.dtoToResponse(
                orderRepository.save(orderDtoMapper.requestToDto(foodaOrderReq))));
    }

    @Override
    public Optional<FoodaOrderRes> editOrderByKey(Long orderKeyId, FoodaOrderReq orderREQ) {
        return getOrderByKey(orderKeyId)
                .map(res -> orderHttpMapper
                        .requestToResponse(orderREQ)
                        .toBuilder()
                        .orderKeyId(orderKeyId)
                        .build())
                .map(res -> orderDtoMapper.dtoToResponse(
                        orderRepository.save(
                                orderDtoMapper.responseToDto(res))));
    }

    @Override
    public Optional<FoodaOrderRes> editOrderByKey(Long orderKeyId, Long externalOrderId, Long userID, Long storeId, FoodaOrderReq orderREQ) {
        return getOrderByKey(orderKeyId)
                .map(res -> orderHttpMapper
                        .requestToResponse(orderREQ)
                        .toBuilder()
                        .orderKeyId(orderKeyId)
                        .externalOrderId(externalOrderId)
                        .userId(userID)
                        .store(FoodaOrderStoreRes.builder().storeId(storeId).build())
                        .build())
                .map(res -> orderDtoMapper.dtoToResponse(
                        orderRepository.save(
                                orderDtoMapper.responseToDto(res))));
    }

    @Override
    public Optional<FoodaOrderRes> editOrderByExample(FoodaOrderReq orderReq) {
        return getOrderByExample(orderReq).map(
                res -> orderDtoMapper.dtoToResponse(
                        orderRepository.save(orderDtoMapper.responseToDto(res))));
    }

    @Override
    public Optional<FoodaOrderRes> removeOrderByKey(Long orderKeyId) {
        final Optional<FoodaOrderRes> foundOrder = getOrderByKey(orderKeyId);
        foundOrder.ifPresent(res -> orderRepository.deleteByOrderKey_orderKeyId(orderKeyId));
        final Optional<FoodaOrderRes> oOrderAfterDelete = getOrderByKey(orderKeyId);
        if (oOrderAfterDelete.isEmpty()) {
            return foundOrder;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<FoodaOrderRes> removeOrderByKey(Long externalOrderId, Long userID, Long storeId) {
        final Optional<FoodaOrderRes> foundOrder = getOrderByKey(externalOrderId, userID, storeId);
        foundOrder.ifPresent(res -> orderRepository.deleteByOrderKey_ExternalOrderIdAndOrderKey_UserIdAndOrderKey_StoreId(externalOrderId, userID, storeId));
        final Optional<FoodaOrderRes> oOrderAfterDelete = getOrderByKey(externalOrderId, userID, storeId);
        if (oOrderAfterDelete.isEmpty()) {
            return foundOrder;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<FoodaOrderRes> removeOrderByExample(FoodaOrderReq orderReq) {
        final Optional<FoodaOrderRes> foundOrder = getOrderByExample(orderReq);
        foundOrder.ifPresent(res -> orderRepository.delete(orderDtoMapper.requestToDto(orderReq)));
        final Optional<FoodaOrderRes> oOrderAfterDelete = getOrderByExample(orderReq);
        if (oOrderAfterDelete.isEmpty()) {
            return foundOrder;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Boolean doesOrderExistsByKey(Long orderKeyId) {
        return orderRepository.existsByOrderKey_OrderKeyId(orderKeyId);
    }

    @Override
    public Boolean doesOrderExistsByKey(Long externalOrderId, Long userID, Long storeId) {
        return  orderRepository.existsByOrderKey_ExternalOrderIdAndOrderKey_UserIdAndOrderKey_StoreId(externalOrderId, userID, storeId);
    }

    @Override
    public Boolean doesOrderExistsByExample(FoodaOrderReq orderReq) {
        return orderRepository.exists(Example.of(orderDtoMapper.requestToDto(orderReq)));
    }
}
