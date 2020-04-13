package it.vkod.services;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import it.vkod.payloads.basketRequest.BasketProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WooBasketServiceClient {

    @Autowired
    private RestTemplate rest;

    @Autowired
    private EurekaClient discoveryClient;

    private String getBasketServiceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("woo-basket-service", false);
        return instance.getHomePageUrl();
    }

    public BasketProduct[] apiGetCachedBasketProducts() {
        return rest.getForObject(getBasketServiceUrl() + "api/basket/products", BasketProduct[].class);
    }

    public void apiPostCachedBasketProducts(final BasketProduct basketProduct) {
        rest.postForObject(getBasketServiceUrl() + "api/basket/products", basketProduct, BasketProduct.class);
    }
}
