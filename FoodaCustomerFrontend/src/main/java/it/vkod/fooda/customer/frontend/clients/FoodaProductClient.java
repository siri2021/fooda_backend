package it.vkod.fooda.customer.frontend.clients;

import it.vkod.fooda.customer.frontend.models.product.response.ProductResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class FoodaProductClient {

    @Autowired
    private RestTemplate rest;

    public CompletableFuture<ProductResponse[]> apiGetMatchFromAllStores(final String keyword) {
        return CompletableFuture.completedFuture(rest.getForObject(GatewayClient.getServerUrl() + "/product/search/" + keyword, ProductResponse[].class));
    }

    public CompletableFuture<ProductResponse[]> apiGetProductsFromAllStores() {
        return CompletableFuture.completedFuture(rest.getForObject(GatewayClient.getServerUrl() + "/product/all/", ProductResponse[].class));
    }
}
