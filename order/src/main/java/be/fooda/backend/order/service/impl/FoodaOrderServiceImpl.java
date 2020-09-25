package be.fooda.backend.order.service.impl;

import be.fooda.backend.commons.model.template.basket.response.FoodaBasketProductRes;
import be.fooda.backend.commons.model.template.order.request.FoodaOrderReq;
import be.fooda.backend.commons.model.template.order.response.FoodaOrderRes;
import be.fooda.backend.commons.model.template.order.response.FoodaOrderStoreRes;
import be.fooda.backend.commons.service.mapper.FoodaOrderHttpMapper;
import be.fooda.backend.order.dao.FoodaOrderRepository;
import be.fooda.backend.order.model.dto.FoodaOrderDto;
import be.fooda.backend.order.model.dto.FoodaOrderKeyDto;
import be.fooda.backend.order.service.FoodaOrderService;
import be.fooda.backend.order.service.mapper.FoodaOrderDtoMapper;
import lombok.RequiredArgsConstructor;

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
        return orderRepository.findById(orderKeyId).map(orderDtoMapper :: dtoToResponse);
    }

    @Override
    public Optional<FoodaOrderRes> getOrderByKey(Long orderKeyId, Long externalOrderId, Long userID, Long storeId) {
        return orderRepository.findByKey(FoodaOrderKeyDto.builder()
                                                         .orderKeyId(orderKeyId)
                                                         .storeId(storeId)
                                                         .userId(userID)
                                                         .externalOrderId(externalOrderId)
                                                         .build())
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

    @Override//TODO
    public List<FoodaOrderRes> getOrdersByPaymentAmount(BigDecimal minAmount, BigDecimal maxAmount) {
        return null;
    }

    @Override
    public List<FoodaOrderRes> getOrdersByStoreId(Long storeId) {
        return orderRepository.findByPaymentStoreId(storeId)
                .stream()
                .map(orderDtoMapper :: dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaOrderRes> getOrdersByUserId(Long userId) {
        return orderRepository.findByPaymentUserId(userId)
                .stream()
                .map(orderDtoMapper :: dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaOrderRes> getOrdersByProductKey(Long orderKeyId) {
        return orderRepository.findByPaymentProductKey(orderKeyId)
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
        foundOrder.ifPresent(res -> orderRepository.deleteById(orderKeyId));
        final Optional<FoodaOrderRes> oOrderAfterDelete = getOrderByKey(orderKeyId);
        if (oOrderAfterDelete.isEmpty()) {
            return foundOrder;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<FoodaOrderRes> removeOrderByKey(Long orderKeyId, Long externalOrderId, Long userID, Long storeId) {
        return Optional.empty();
    }

    @Override
    public Optional<FoodaOrderRes> removeOrderByExample(FoodaOrderReq orderReq) {
        return Optional.empty();
    }

    @Override
    public Boolean doesOrderExistsByKey(Long orderKeyId) {
        return null;
    }

    @Override
    public Boolean doesOrderExistsByKey(Long orderKeyId, Long externalOrderId, Long userID, Long storeId) {
        return null;
    }

    @Override
    public Boolean doesOrderExistsByExample(FoodaOrderReq orderReq) {
        return null;
    }
}
