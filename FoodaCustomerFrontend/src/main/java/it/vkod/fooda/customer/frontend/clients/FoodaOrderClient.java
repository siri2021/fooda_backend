package it.vkod.fooda.customer.frontend.clients;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import it.vkod.fooda.customer.frontend.models.order.req.OrderRequest;
import it.vkod.fooda.customer.frontend.models.order.res.OrderResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class FoodaOrderClient {

    @Autowired
    private RestTemplate rest;

    @Autowired
    private EurekaClient discoveryClient;

    private String getOrderServiceUrl(final long storeId) {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("woocommerce-server-" + storeId, false);
        return instance.getHomePageUrl();
    }

    public OrderResponse apiGetOrderOne(final int orderId, final long storeId) {
        return rest.getForObject(getOrderServiceUrl(storeId) + "api/woocommerce/orders/" + orderId, OrderResponse.class);
    }

    public OrderResponse apiAddOrderWithResponse(final OrderRequest orderRequest, final long storeId) {
        return rest.postForObject(getOrderServiceUrl(storeId) + "api/woocommerce/orders/", orderRequest, OrderResponse.class);
    }

}
