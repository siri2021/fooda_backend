package it.vkod.woo.product.client.clients;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import it.vkod.woo.product.client.pojo.order.req.OrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class WooOrderServiceClient {

    @Autowired
    private RestTemplate rest;

    @Autowired
    private EurekaClient discoveryClient;

    private String getOrderServiceUrl(final long storeId) {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("woo-order-service-" + storeId, false);
        return instance.getHomePageUrl();
    }

    public OrderRequest[] apiGetOrders(final int page, final long storeId) {
        return rest.getForObject(getOrderServiceUrl(storeId) + "api/orders/" + page, OrderRequest[].class);
    }

    public void apiAddOrder(final OrderRequest orderRequest, final long storeId) {
        rest.postForObject(getOrderServiceUrl(storeId) + "api/orders/", orderRequest, OrderRequest.class);
    }

}
