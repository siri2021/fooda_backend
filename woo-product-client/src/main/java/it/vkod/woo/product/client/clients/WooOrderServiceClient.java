package it.vkod.woo.product.client.clients;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import it.vkod.woo.product.client.pojo.order.req.OrderRequest;
import it.vkod.woo.product.client.pojo.order.res.OrderResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@AllArgsConstructor
@Service
public class WooOrderServiceClient {

    private final RestTemplate rest;
    private final EurekaClient discoveryClient;

    private String getOrderServiceUrl(final long storeId) {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("woo-order-service-" + storeId, false);
        return instance.getHomePageUrl();
    }

    public OrderResponse apiGetOrderOne(final int orderId, final long storeId) {
        return rest.getForObject(getOrderServiceUrl(storeId) + "api/orders/" + orderId, OrderResponse.class);
    }

    public OrderResponse apiAddOrderWithResponse(final OrderRequest orderRequest, final long storeId) {
        return rest.postForObject(getOrderServiceUrl(storeId) + "api/orders/", orderRequest, OrderResponse.class);
    }

}
