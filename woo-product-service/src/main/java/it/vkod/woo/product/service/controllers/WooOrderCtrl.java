package it.vkod.woo.product.service.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icoderman.woocommerce.EndpointBaseType;
import com.icoderman.woocommerce.WooCommerce;
import it.vkod.woo.product.service.payloads.orderRequest.WooOrderRequest;
import it.vkod.woo.product.service.payloads.orderResponse.WooOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/orders")
public class WooOrderCtrl implements OrderCtrl<WooOrderResponse, WooOrderRequest> {

    @Value("${store.id}")
    private long storeId;

    @Autowired
    private WooCommerce wooCommerceService;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public WooOrderResponse[] apiGetOrdersAll(int page) {
        Map<String, String> params = new HashMap<>();
        params.put("per_page", "100");
        params.put("offset", String.valueOf(page));
        @SuppressWarnings("unchecked")    // we'll throw an exception from service to simulate a failure
        final List<Map<String, Object>> productListMap = wooCommerceService.getAll(EndpointBaseType.ORDERS.getValue(), params);
        final WooOrderResponse[] wooOrderResponses = mapper.convertValue(productListMap, WooOrderResponse[].class);
        Arrays.stream(wooOrderResponses).forEach(wooOrderResponse -> wooOrderResponse.setStoreId(storeId));
        return wooOrderResponses;
    }

    @Override
    public WooOrderResponse apiGetOrderOne(long id) {
        @SuppressWarnings("unchecked")    // we'll throw an exception from service to simulate a failure
                Map<String, Object> productMap = wooCommerceService.get(EndpointBaseType.ORDERS.getValue(), (int) id);
        final WooOrderResponse wooOrderResponse = mapper.convertValue(productMap, WooOrderResponse.class);
        wooOrderResponse.setStoreId(storeId);
        return wooOrderResponse;
    }

    @Override
    public void apiPostOrderOne(WooOrderRequest order) {
        final Map<String, Object> orderMap = mapper.convertValue(order, new TypeReference<Map<String, Object>>() {
        });
        wooCommerceService.create(EndpointBaseType.ORDERS.getValue(), orderMap);
    }

    @Override
    public void apiPutOrderOne(long id, WooOrderRequest order) {
        final Map<String, Object> orderMap = mapper.convertValue(order, new TypeReference<Map<String, Object>>() {
        });
        wooCommerceService.update(EndpointBaseType.ORDERS.getValue(), (int) id, orderMap);
    }

    @Override
    public void apiDeleteOrderOne(long id) {
        wooCommerceService.delete(EndpointBaseType.ORDERS.getValue(), (int) id);
    }
}
