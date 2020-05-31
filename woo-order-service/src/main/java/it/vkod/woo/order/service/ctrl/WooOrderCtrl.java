package it.vkod.woo.order.service.ctrl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.icoderman.woocommerce.EndpointBaseType;
import com.icoderman.woocommerce.WooCommerce;
import it.vkod.woo.order.service.payloads.req.WooOrderRequest;
import it.vkod.woo.order.service.payloads.res.WooOrderResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("api/orders")
public class WooOrderCtrl implements OrderCtrl<WooOrderResponse, WooOrderRequest> {

    @Value("${store.id}")
    private long storeId;

    @Autowired
    private WooCommerce woo;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public WooOrderResponse[] apiGetOrdersAll(int page) {
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
    public WooOrderResponse apiGetOrderOne(long id) {
        @SuppressWarnings("unchecked")    // we'll throw an exception from service to simulate a failure
                Map<String, Object> orderMap = woo.get(EndpointBaseType.ORDERS.getValue(), (int) id);
        final WooOrderResponse wooOrderResponse = mapper.convertValue(orderMap, WooOrderResponse.class);
        wooOrderResponse.setStore_id(storeId);
        return wooOrderResponse;
    }

    @Override
    public void apiPostOrderOne(WooOrderRequest order) {
        final Map<String, Object> orderMap = mapper.convertValue(order, new TypeReference<Map<String, Object>>() {
        });
        final Map createdOrder = woo.create(EndpointBaseType.ORDERS.getValue(), orderMap);
        Gson gson = new Gson();
        log.info(gson.toJson(mapper.convertValue(createdOrder, WooOrderResponse.class)));
    }

    @Override
    public void apiPutOrderOne(long id, WooOrderRequest order) {
        final Map<String, Object> orderMap = mapper.convertValue(order, new TypeReference<Map<String, Object>>() {
        });
        woo.update(EndpointBaseType.ORDERS.getValue(), (int) id, orderMap);
    }

    @Override
    public void apiDeleteOrderOne(long id) {
        woo.delete(EndpointBaseType.ORDERS.getValue(), (int) id);
    }
}
