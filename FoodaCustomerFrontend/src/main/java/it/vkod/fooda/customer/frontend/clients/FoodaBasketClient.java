package it.vkod.fooda.customer.frontend.clients;

import it.vkod.fooda.customer.frontend.models.basket.req.BasketBilling;
import it.vkod.fooda.customer.frontend.models.basket.req.BasketOrder;
import it.vkod.fooda.customer.frontend.models.basket.req.BasketProduct;
import it.vkod.fooda.customer.frontend.models.basket.req.BasketShipping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Slf4j
@Service
public class FoodaBasketClient {

    @Autowired
    private RestTemplate rest;

    public BasketProduct[] apiGetBasketProducts(final String userId) {
        return rest.getForObject(GatewayClient.getServerUrl() + "/basket/products/select/" + userId, BasketProduct[].class);
    }

    public BasketOrder[] apiGetBasketOrders(final String userId) {
        return rest.getForObject(GatewayClient.getServerUrl() + "/basket/orders/select/" + userId, BasketOrder[].class);
    }

    public double apiGetBasketTotalPrice(final String userId) {
        final BasketProduct[] basketProduct = apiGetBasketProducts(userId);
        return Arrays.stream(basketProduct)
                .mapToDouble(b -> b.getQuantity() * b.getPrice())
                .sum();
    }

    public void apiIncreaseBasketProductQuantity(final BasketProduct basketProduct) {
        rest.put(GatewayClient.getServerUrl() + "/basket/products/increase/", basketProduct);
    }

    public void apiDecreaseBasketProductQuantity(final BasketProduct basketProduct) {
        rest.put(GatewayClient.getServerUrl() + "/basket/products/decrease/", basketProduct);
    }

    public void apiAddBasketProduct(final BasketProduct basketProduct) {
        rest.postForObject(GatewayClient.getServerUrl() + "/basket/products/insert/", basketProduct, BasketProduct.class);
    }

    public void apiAddBasketOrder(final BasketOrder basketOrder) {
        rest.postForObject(GatewayClient.getServerUrl() + "/basket/orders/insert/", basketOrder, BasketOrder.class);
    }

    public void apiAddBasketShipping(final BasketShipping basketShipping) {
        rest.postForObject(GatewayClient.getServerUrl() + "/basket/shipping/insert/", basketShipping, BasketShipping.class);
    }

    public BasketShipping[] apiGetBasketShipping(final String userId) {
        return rest.getForObject(GatewayClient.getServerUrl() + "/basket/shipping/select/" + userId, BasketShipping[].class);
    }

    public void apiAddBasketBilling(final BasketBilling basketBilling) {
        rest.postForObject(GatewayClient.getServerUrl() + "/basket/billing/insert/", basketBilling, BasketBilling.class);
    }

    public BasketBilling[] apiGetBasketBilling(final String userId) {
        return rest.getForObject(GatewayClient.getServerUrl() + "/basket/billing/select/" + userId, BasketBilling[].class);
    }

    public void apiClearBasketProducts(final String userId) {
        rest.delete(GatewayClient.getServerUrl() + "/basket/products/clear/" + userId);
    }

    public void apiClearBasketProductsByStoreId(final String userId, final long storeId) {
        rest.delete(GatewayClient.getServerUrl() + "/basket/products/clear/" + userId + "/store/" + storeId);
    }

}
