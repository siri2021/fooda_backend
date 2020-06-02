package it.vkod.woo.product.client.clients;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import it.vkod.woo.product.client.pojo.basket.req.BasketBilling;
import it.vkod.woo.product.client.pojo.basket.req.BasketProduct;
import it.vkod.woo.product.client.pojo.basket.req.BasketShipping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Slf4j
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

    public BasketProduct[] apiGetBasketProducts(final String userId) {
        return rest.getForObject(getBasketServiceUrl() + "api/basket/products/select/" + userId, BasketProduct[].class);
    }

    public double apiGetBasketTotalPrice(final String userId) {
        final BasketProduct[] basketProduct = apiGetBasketProducts(userId);
        return Arrays.stream(basketProduct)
                .mapToDouble(b -> b.getQuantity() * b.getPrice())
                .sum();
    }

    public void apiIncreaseBasketProductQuantity(final BasketProduct basketProduct) {
        rest.put(getBasketServiceUrl() + "api/basket/products/increase/", basketProduct);
    }

    public void apiDecreaseBasketProductQuantity(final BasketProduct basketProduct) {
        rest.put(getBasketServiceUrl() + "api/basket/products/decrease/", basketProduct);
    }

    public void apiAddBasketProduct(final BasketProduct basketProduct) {
        rest.postForObject(getBasketServiceUrl() + "api/basket/products/insert/", basketProduct, BasketProduct.class);
    }

    public void apiAddBasketShipping(final BasketShipping basketShipping) {
        rest.postForObject(getBasketServiceUrl() + "api/basket/shipping/insert/", basketShipping, BasketShipping.class);
    }

    public BasketShipping[] apiGetBasketShipping(final String userId) {
        return rest.getForObject(getBasketServiceUrl() + "api/basket/shipping/select/" + userId, BasketShipping[].class);
    }

    public void apiAddBasketBilling(final BasketBilling basketBilling) {
        rest.postForObject(getBasketServiceUrl() + "api/basket/billing/insert/", basketBilling, BasketBilling.class);
    }

    public BasketBilling[] apiGetBasketBilling(final String userId) {
        return rest.getForObject(getBasketServiceUrl() + "api/basket/billing/select/" + userId, BasketBilling[].class);
    }

    public void apiClearBasketProducts(final String userId) {
        log.info("Basket products from " + userId + " is cleared.");
        rest.delete(getBasketServiceUrl() + "api/basket/products/clear/" + userId);
    }

}
