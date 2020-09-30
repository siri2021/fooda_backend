package be.fooda.backend.order.service.mapper;

import be.fooda.backend.commons.model.template.order.request.FoodaOrderProductReq;
import be.fooda.backend.commons.model.template.order.request.FoodaOrderReq;
import be.fooda.backend.commons.model.template.order.response.*;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.order.model.dto.FoodaOrderDto;
import be.fooda.backend.order.model.dto.FoodaOrderPaymentDto;
import be.fooda.backend.order.model.dto.FoodaOrderProductDto;
import be.fooda.backend.order.model.dto.FoodaOrderStatusDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FoodaOrderDtoMapper implements FoodaDtoMapper<FoodaOrderDto, FoodaOrderReq, FoodaOrderRes> {
    @Override
    public FoodaOrderDto requestToDto(FoodaOrderReq foodaOrderReq) {
        return FoodaOrderDto.builder()
                .note(foodaOrderReq.getNote())
                .storeId(foodaOrderReq.getStoreId())
                .userId(foodaOrderReq.getUserId())
                .orderStatus(orderStatus(foodaOrderReq))
                .payments(payments(foodaOrderReq))
                .products(product(foodaOrderReq))
                .requiredTime(foodaOrderReq.getRequiredTime())
                .build();
    }

    private List<FoodaOrderProductDto> product(FoodaOrderReq foodaOrderReq) {
        return foodaOrderReq.getProducts().stream()
                .map(req -> FoodaOrderProductDto.builder()
                        .productId(req.getProductId())
                        .quantity(req.getQuantity())
                        .price(req.getPrice())
                        .build())
                .collect(Collectors.toList());
    }

    private List<FoodaOrderProductDto> product(FoodaOrderRes foodaOrderRes) {
        return foodaOrderRes.getOrderedProducts().stream()
                .map(req -> FoodaOrderProductDto.builder()
                        .productId(req.getProductId())
                        .orderId(foodaOrderRes.getOrderId())
                        .price(req.getPrice())
                        .quantity(req.getQuantity())
                        .build())
                .collect(Collectors.toList());
    }


    private List<FoodaOrderPaymentDto> payments(FoodaOrderReq foodaOrderReq) {
        return foodaOrderReq.getPayments().stream()
                .map(req -> FoodaOrderPaymentDto.builder()
                        .paymentId(req)
                        .build())
                .collect(Collectors.toList());
    }

    private List<FoodaOrderPaymentDto> payments(FoodaOrderRes foodaOrderRes) {
        return foodaOrderRes.getPayments().stream()
                .map(res -> FoodaOrderPaymentDto.builder()
                        .orderPaymentId(res.getOrderPaymentId())
                        .paymentId(res.getPaymentId())
                        .amount(res.getAmount())
                        .build())
                .collect(Collectors.toList());
    }

    private FoodaOrderStatusDto orderStatus(FoodaOrderReq foodaOrderReq) {
        return FoodaOrderStatusDto.builder()
                .orderStatusId(foodaOrderReq.getOrderStatusId())
                .build();
    }

    private FoodaOrderStatusDto orderStatus(FoodaOrderRes foodaOrderRes) {
        return FoodaOrderStatusDto.builder()
                .orderStatusId(foodaOrderRes.getStatus().getOrderStatusId())
                .title(foodaOrderRes.getStatus().getTitle())
                .parent(FoodaOrderStatusDto.builder()
                        .title(foodaOrderRes.getStatus().getParent())
                        .build())
                .build();
    }

    @Override
    public FoodaOrderDto responseToDto(FoodaOrderRes foodaOrderRes) {
        return FoodaOrderDto.builder()
                .note(foodaOrderRes.getNote())
                .externalOrderId(foodaOrderRes.getExternalOrderId())
                .userId(foodaOrderRes.getUserId())
                .storeId(foodaOrderRes.getStore().getStoreId())
                .orderStatus(orderStatus(foodaOrderRes))
                .payments(payments(foodaOrderRes))
                .products(product(foodaOrderRes))
                .requiredTime(foodaOrderRes.getRequiredTime())
                .build();
    }

    @Override
    public FoodaOrderReq dtoToRequest(FoodaOrderDto foodaOrderDto) {
        return FoodaOrderReq.builder()
                .note(foodaOrderDto.getNote())
                .storeId(foodaOrderDto.getStoreId())
                .userId(foodaOrderDto.getUserId())
                .orderStatusId(foodaOrderDto.getOrderStatus().getOrderStatusId())
                .payments(payments(foodaOrderDto))
                .products(products(foodaOrderDto))
                .requiredTime(foodaOrderDto.getRequiredTime())
                .build();
    }

    private Set<FoodaOrderProductReq> products(FoodaOrderDto foodaOrderDto) {
        return foodaOrderDto.getProducts().stream()
                .map(dto -> FoodaOrderProductReq.builder()
                        .price(dto.getPrice())
                        .productId(dto.getProductId())
                        .quantity(dto.getQuantity())
                        .build())
                .collect(Collectors.toSet());
    }

    private Set<Long> payments(FoodaOrderDto foodaOrderDto) {
        return foodaOrderDto.getPayments()
                .stream()
                .map(FoodaOrderPaymentDto::getPaymentId)
                .collect(Collectors.toSet());
    }

    @Override
    public FoodaOrderRes dtoToResponse(FoodaOrderDto foodaOrderDto) {
        return FoodaOrderRes.builder()
                .externalOrderId(foodaOrderDto.getExternalOrderId())
                .productsTotal(productsTotal(foodaOrderDto))
                .note(foodaOrderDto.getNote())
                .registryTime(foodaOrderDto.getRegisteredAt())
                .requiredTime(foodaOrderDto.getRequiredTime())
                .deliveryTime(foodaOrderDto.getDeliveryTime())
                .paymentTime(foodaOrderDto.getPaymentTime())
                .userId(foodaOrderDto.getUserId())
                .store(FoodaOrderStoreRes.builder().storeId(foodaOrderDto.getStoreId()).build())
                .taxTotal(foodaOrderDto.getTaxTotal())
                .deliveryTotal(foodaOrderDto.getDeliveryTotal())
                .status(statusFromDto(foodaOrderDto))
                .payments(paymentsFromDto(foodaOrderDto))
                .orderedProducts(productsFromDto(foodaOrderDto))
                .priceTotal(priceTotal(foodaOrderDto))
                .build();
    }

    private List<FoodaOrderProductRes> productsFromDto(FoodaOrderDto foodaOrderDto) {
        return foodaOrderDto.getProducts()
                .stream()
                .map(dto -> FoodaOrderProductRes.builder()
                        .productId(dto.getProductId())
                        .quantity(dto.getQuantity())
                        .price(dto.getPrice())
                        .build()
                )
                .collect(Collectors.toList());
    }

    private List<FoodaOrderPaymentRes> paymentsFromDto(FoodaOrderDto foodaOrderDto) {
        return foodaOrderDto.getPayments()
                .stream()
                .map(p -> FoodaOrderPaymentRes.builder()
                        .paymentId(p.getPaymentId())
                        .amount(p.getAmount())
                        .orderPaymentId(p.getOrderPaymentId())
                        .build())
                .collect(Collectors.toList());
    }

    private FoodaOrderStatusRes statusFromDto(FoodaOrderDto foodaOrderDto) {
        return FoodaOrderStatusRes.builder()
                .orderStatusId(foodaOrderDto.getOrderStatus().getOrderStatusId())
                .title(foodaOrderDto.getOrderStatus().getTitle())
                .parent(foodaOrderDto.getOrderStatus().getParent().getTitle())
                .build();
    }

    private BigDecimal productsTotal(FoodaOrderDto foodaOrderDto) {
        return BigDecimal.valueOf(foodaOrderDto.getProducts().stream()
                .mapToDouble(prod -> prod.getPrice().doubleValue() * prod.getQuantity())
                .sum());
    }

    private BigDecimal priceTotal(FoodaOrderDto foodaOrderDto) {
        return foodaOrderDto.getDeliveryTotal()
                .add(foodaOrderDto.getProductsTotal()
                        .multiply(BigDecimal.ONE.add(foodaOrderDto.getTaxTotal().divide(BigDecimal.valueOf(100))))
                );
    }
}
