package be.fooda.backend.order.service.impl;

import be.fooda.backend.commons.model.template.order.request.FoodaOrderReq;
import be.fooda.backend.commons.model.template.order.response.FoodaOrderRes;
import be.fooda.backend.commons.model.template.order.response.FoodaOrderStoreRes;
import be.fooda.backend.commons.service.mapper.FoodaOrderHttpMapper;
import be.fooda.backend.order.dao.FoodaOrderRepository;
import be.fooda.backend.order.model.dto.FoodaOrderDto;
import be.fooda.backend.order.service.FoodaOrderService;
import be.fooda.backend.order.service.mapper.FoodaOrderDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FoodaOrderServiceImpl implements FoodaOrderService<FoodaOrderReq, FoodaOrderRes> {

    @Autowired
    private FoodaOrderRepository orderRepository;

    @Autowired
    private FoodaOrderDtoMapper orderDtoMapper;

    @Autowired
    private FoodaOrderHttpMapper orderHttpMapper;

    @Override
    public Optional<FoodaOrderRes> getById(Long orderId) {
        return orderRepository
                .findById(orderId)
                .map(orderDtoMapper::dtoToResponse);
    }

    @Override
    public List<FoodaOrderRes> getAll() {
        return orderRepository
                .findAll()
                .stream()
                .map(orderDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<FoodaOrderRes> getByExample(FoodaOrderReq orderReq) {
        return orderRepository
                .findOne(Example.of(orderDtoMapper.requestToDto(orderReq)))
                .map(orderDtoMapper::dtoToResponse);
    }

    @Override
    public List<FoodaOrderRes> getByStatusId(Long statusId) {
        return orderRepository.findByStatus(statusId)
                .stream()
                .map(orderDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaOrderRes> getByRequiredTime(LocalDateTime requiredTime) {
        return orderRepository.findByRequiredTime(requiredTime)
                .stream()
                .map(orderDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaOrderRes> getByDeliveryTime(LocalDateTime deliveryTime) {
        return orderRepository.findByDeliveryTime(deliveryTime)
                .stream()
                .map(orderDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaOrderRes> getByPaymentTime(LocalDateTime paymentTime) {
        return orderRepository.findByPaymentTime(paymentTime)
                .stream()
                .map(orderDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaOrderRes> getByPaymentId(Long userId, Long paymentId) {
        return orderRepository.findByPayment(userId, paymentId)
                .stream()
                .map(orderDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaOrderRes> getByPaymentAmount(BigDecimal minPrice) {
        return orderRepository.findByPriceMin(minPrice)
                .stream()
                .map(orderDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaOrderRes> getByPaymentAmount(BigDecimal minAmount, BigDecimal maxAmount) {
        return orderRepository.findByPriceRange(minAmount, maxAmount)
                .stream()
                .map(orderDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaOrderRes> getByStoreId(Long storeId) {
        return orderRepository.findByStore(storeId)
                .stream()
                .map(orderDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaOrderRes> getByUserId(Long userId) {
        return orderRepository.findByUser(userId)
                .stream()
                .map(orderDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<FoodaOrderRes> add(FoodaOrderReq foodaOrderReq) {
        return Optional.of(orderDtoMapper.dtoToResponse(
                orderRepository.save(orderDtoMapper.requestToDto(foodaOrderReq))));
    }

    @Override
    public Optional<FoodaOrderRes> editById(Long orderId, FoodaOrderReq orderREQ) {
        return getById(orderId)
                .map(res -> orderHttpMapper
                        .requestToResponse(orderREQ)
                        .toBuilder()
                        .externalOrderId(res.getExternalOrderId())
                        .userId(res.getUserId())
                        .store(FoodaOrderStoreRes.builder().storeId(res.getStore().getStoreId()).build())
                        .build())
                .map(res -> orderDtoMapper.dtoToResponse(
                        orderRepository.save(
                                orderDtoMapper.responseToDto(res))));
    }

    @Override
    public Optional<FoodaOrderRes> editByExample(FoodaOrderReq orderReq) {
        return getByExample(orderReq).map(
                res -> orderDtoMapper.dtoToResponse(
                        orderRepository.save(orderDtoMapper.responseToDto(res))));
    }

    @Override
    public Optional<FoodaOrderRes> removeById(Long orderId) {
        final Optional<FoodaOrderRes> foundOrder = getById(orderId);
        foundOrder.ifPresent(res -> orderRepository.deleteById(orderId));
        final Optional<FoodaOrderRes> oOrderAfterDelete = getById(orderId);
        if (oOrderAfterDelete.isEmpty()) {
            return foundOrder;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<FoodaOrderRes> removeByUserId(Long userId) {
        final List<FoodaOrderDto> foundOrders = orderRepository.findByUser(userId);

        if (!foundOrders.isEmpty()) {
            foundOrders.forEach(dto -> removeById(dto.getOrderId()));
        }
        final List<FoodaOrderDto> ordersAfterDeletion = orderRepository.findByUser(userId);
        return ordersAfterDeletion.isEmpty()
                ? foundOrders.stream()
                .map(orderDtoMapper::dtoToResponse)
                .collect(Collectors.toList())
                : Collections.emptyList();
    }

    @Override
    public Optional<FoodaOrderRes> removeByExample(FoodaOrderReq orderReq) {
        final Optional<FoodaOrderRes> foundOrder = getByExample(orderReq);
        foundOrder.ifPresent(res -> orderRepository.delete(orderDtoMapper.requestToDto(orderReq)));
        final Optional<FoodaOrderRes> oOrderAfterDelete = getByExample(orderReq);
        if (oOrderAfterDelete.isEmpty()) {
            return foundOrder;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Boolean existsById(Long orderId) {
        return orderRepository.existsById(orderId);
    }

    @Override
    public Boolean existsByExample(FoodaOrderReq orderReq) {
        return orderRepository.exists(Example.of(orderDtoMapper.requestToDto(orderReq)));
    }
}
