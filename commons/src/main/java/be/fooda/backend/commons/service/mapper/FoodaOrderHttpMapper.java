package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.order.request.FoodaOrderProductReq;
import be.fooda.backend.commons.model.template.order.request.FoodaOrderReq;
import be.fooda.backend.commons.model.template.order.response.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class FoodaOrderHttpMapper implements FoodaHttpMapper<FoodaOrderReq, FoodaOrderRes> {
    @Override
    public FoodaOrderReq responseToRequest(FoodaOrderRes foodaOrderRes) {
        return FoodaOrderReq.builder()
                .userId(foodaOrderRes.getUserId())
                .storeId(foodaOrderRes.getStore().getStoreId())
                .billingAddressId(foodaOrderRes.getBilling().getAddress().getAddressId())
                .billingContactId(foodaOrderRes.getBilling().getContact().getContactId())
                .deliveryAddressId(foodaOrderRes.getDelivery().getAddress().getAddressId())
                .deliveryContactId(foodaOrderRes.getDelivery().getContact().getContactId())
                .note(foodaOrderRes.getNote())
                .orderStatusId(foodaOrderRes.getStatus().getOrderStatusId())
                .payments(foodaOrderRes.getPayments().stream()
                        .map(FoodaOrderPaymentRes::getOrderPaymentId)
                        .collect(Collectors.toSet()))
                .products(foodaOrderRes.getOrderedProducts().stream()
                        .map(res -> FoodaOrderProductReq.builder()
                                .productId(res.getProductId())
                                .price(res.getPrice())
                                .quantity(res.getQuantity())
                                .build()).collect(Collectors.toSet()))
                .requiredTime(foodaOrderRes.getRequiredTime())
                .build();
    }

    @Override
    public FoodaOrderRes requestToResponse(FoodaOrderReq foodaOrderReq) {
        return FoodaOrderRes.builder()
                .userId(foodaOrderReq.getUserId())
                .store(FoodaOrderStoreRes.builder().storeId(foodaOrderReq.getStoreId()).build())
                .billing(FoodaOrderBillingRes.builder().build())
                .delivery(FoodaOrderDeliveryRes.builder().build())
                .note(foodaOrderReq.getNote())
                .status(FoodaOrderStatusRes.builder().build())
                .payments(foodaOrderReq.getPayments().stream()
                        .map(orderPaymentId -> FoodaOrderPaymentRes.builder().orderPaymentId(orderPaymentId).build())
                        .collect(Collectors.toList()))
                .orderedProducts(foodaOrderReq.getProducts().stream()
                        .map(res -> FoodaOrderProductRes.builder()
                                .productId(res.getProductId())
                                .price(res.getPrice())
                                .quantity(res.getQuantity())
                                .build()).collect(Collectors.toList()))
                .requiredTime(foodaOrderReq.getRequiredTime())
                .build();
    }
}
