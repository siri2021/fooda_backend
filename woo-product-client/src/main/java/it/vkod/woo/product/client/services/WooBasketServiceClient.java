package it.vkod.woo.product.client.services;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import it.vkod.woo.product.client.payloads.Basket;
import it.vkod.woo.product.client.payloads.basketRequest.BasketOrder;
import it.vkod.woo.product.client.payloads.basketRequest.BasketProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

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

    public Set<Basket> apiGetBasketProducts(){
        return rest.getForObject(getBasketServiceUrl() + "api/basket/", Set.class);
    }

    public void apiPostBasketProduct(final Basket basket) {
        rest.postForObject(getBasketServiceUrl() + "api/basket/", basket, Basket.class);
    }

    public BasketProduct[] apiGetCachedBasketProducts() {
        return rest.getForObject(getBasketServiceUrl() + "api/basket/products", BasketProduct[].class);
    }

    public void apiPostCachedBasketProducts(final BasketProduct basketProduct) {
        rest.postForObject(getBasketServiceUrl() + "api/basket/products", basketProduct, BasketProduct.class);
    }

    public void apiPostCachedBasketOrder(final BasketOrder basketOrder) {
        rest.postForObject(getBasketServiceUrl() + "api/basket/orders", basketOrder, BasketOrder.class);
    }
}
