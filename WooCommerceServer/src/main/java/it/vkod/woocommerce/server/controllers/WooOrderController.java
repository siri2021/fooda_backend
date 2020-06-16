package it.vkod.woocommerce.server.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icoderman.woocommerce.EndpointBaseType;
import com.icoderman.woocommerce.WooCommerce;
import it.vkod.woocommerce.server.models.order.request.WooOrderRequest;
import it.vkod.woocommerce.server.models.order.response.WooOrderResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("api/orders/")
public class WooOrderController implements OrderController<WooOrderResponse, WooOrderRequest> {

    @Value("${store.id}")
    private long storeId;

    private final WooCommerce woo;
    private final ObjectMapper mapper;

    public WooOrderController(WooCommerce woo, ObjectMapper mapper) {
        this.woo = woo;
        this.mapper = mapper;
    }

    @Override
    public WooOrderResponse[] apiGetOrdersAll(final int page) {
        Map<String, String> params = new HashMap<>();
        params.put("per_page", "100");
        params.put("offset", String.valueOf(page));
        @SuppressWarnings("unchecked")    // we'll throw an exception from service to simulate a failure
        final List<Map<String, Object>> orderListMap = woo.getAll(EndpointBaseType.ORDERS.getValue(), params);
        final WooOrderResponse[] wooOrderResponses = mapper.convertValue(orderListMap, WooOrderResponse[].class);
        Arrays.stream(wooOrderResponses).forEach(wooOrderResponse -> wooOrderResponse.setStore_id(storeId));
        return wooOrderResponses;
    }

    @Override
    public WooOrderResponse apiGetOrderOne(final long id) {
        @SuppressWarnings("unchecked")    // we'll throw an exception from service to simulate a failure
                Map<String, Object> orderMap = woo.get(EndpointBaseType.ORDERS.getValue(), (int) id);
        final WooOrderResponse wooOrderResponse = mapper.convertValue(orderMap, WooOrderResponse.class);
        wooOrderResponse.setStore_id(storeId);
        return wooOrderResponse;
    }

    @Override
    public WooOrderResponse apiPostOrderOne(final WooOrderRequest order) {
        final Map<String, Object> orderMap = mapper.convertValue(order, new TypeReference<Map<String, Object>>() {
        });
        @SuppressWarnings("unchecked")    // we'll throw an exception from service to simulate a failure
        final Map<String, Object> createdOrder = woo.create(EndpointBaseType.ORDERS.getValue(), orderMap);

        log.info(createdOrder.toString());

        final WooOrderResponse wooOrderResponse = mapper.convertValue(createdOrder, WooOrderResponse.class);
        wooOrderResponse.setStore_id(storeId);
        return wooOrderResponse;
    }

    @Override
    public void apiPutOrderOne(final long id, final WooOrderRequest order) {
        final Map<String, Object> orderMap = mapper.convertValue(order, new TypeReference<Map<String, Object>>() {
        });
        woo.update(EndpointBaseType.ORDERS.getValue(), (int) id, orderMap);
    }

    @Override
    public void apiDeleteOrderOne(final long id) {
        woo.delete(EndpointBaseType.ORDERS.getValue(), (int) id);
    }
}
