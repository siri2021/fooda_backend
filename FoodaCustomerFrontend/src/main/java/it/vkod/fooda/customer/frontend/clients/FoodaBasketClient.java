package it.vkod.fooda.customer.frontend.clients;

import it.vkod.fooda.customer.frontend.models.basket.req.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Slf4j
@Service
public class FoodaBasketClient {

    @Autowired
    private RestTemplate restTemplate;

    public BasketProduct[] apiGetBasketProducts(final String userId) {
        return restTemplate.getForObject(GatewayClient.getServerUrl() + "/basket/product/select/" + userId, BasketProduct[].class);
    }

    public BasketOrder[] apiGetBasketOrders(final String userId) {
        return restTemplate.getForObject(GatewayClient.getServerUrl() + "/basket/order/select/" + userId, BasketOrder[].class);
    }

    public double apiGetBasketTotalPrice(final String userId) {
        final BasketProduct[] basketProduct = apiGetBasketProducts(userId);
        return Arrays.stream(basketProduct)
                .mapToDouble(b -> b.getQuantity() * b.getPrice())
                .sum();
    }

    public void apiIncreaseBasketProductQuantity(final BasketProduct basketProduct) {
        restTemplate.put(GatewayClient.getServerUrl() + "/basket/product/increase/", basketProduct);
    }

    public void apiDecreaseBasketProductQuantity(final BasketProduct basketProduct) {
        restTemplate.put(GatewayClient.getServerUrl() + "/basket/product/decrease/", basketProduct);
    }

    public void apiAddBasketProduct(final BasketProduct basketProduct) {
        restTemplate.postForObject(GatewayClient.getServerUrl() + "/basket/product/insert/", basketProduct, BasketProduct.class);
    }

    public void apiAddBasketOrder(final BasketOrder basketOrder) {
        restTemplate.postForObject(GatewayClient.getServerUrl() + "/basket/order/insert/", basketOrder, BasketOrder.class);
    }

    public void apiAddBasketAddress(final BasketAddress address) {
        restTemplate.postForObject(GatewayClient.getServerUrl() + "/basket/address/insert/", address, BasketAddress.class);
    }

    public BasketAddress apiGetBasketAddress(final String userId) {
        return restTemplate.getForObject(GatewayClient.getServerUrl() + "/basket/address/select/" + userId, BasketAddress.class);
    }

    public void apiClearBasketProducts(final String userId) {
        restTemplate.delete(GatewayClient.getServerUrl() + "/basket/product/clear/" + userId);
    }

    public void apiClearBasketProductsByStoreId(final String userId, final long storeId) {
        restTemplate.delete(GatewayClient.getServerUrl() + "/basket/product/clear/" + userId + "/store/" + storeId);
    }

}
