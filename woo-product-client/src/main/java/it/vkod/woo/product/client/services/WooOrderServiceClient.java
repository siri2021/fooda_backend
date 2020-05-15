package it.vkod.woo.product.client.services;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import it.vkod.woo.product.client.payloads.order.request.WooOrderRequest;
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

    private String getOrderServiceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("woo-order-service", false);
        return instance.getHomePageUrl();
    }

    public WooOrderRequest[] apiGetOrders(final long userId) {
        return rest.getForObject(getOrderServiceUrl() + "api/orders/select/" + userId, WooOrderRequest[].class);
    }

    public void apiAddOrder(final WooOrderRequest orderRequest) {
        rest.postForObject(getOrderServiceUrl() + "api/orders/insert/", orderRequest, WooOrderRequest.class);
    }

}
