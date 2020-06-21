package it.vkod.fooda.customer.frontend.clients;

import it.vkod.fooda.customer.frontend.models.product.response.ProductResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class FoodaProductClient {

    @Autowired
    private RestTemplate rest;

    public ProductResponse[] apiGetMatchFromAllStores(final String keyword) {
        return rest.getForObject(GatewayClient.getServerUrl() + "/product/search/" + keyword, ProductResponse[].class);
    }

    public ProductResponse[] apiGetProductsFromAllStores() {
        return rest.getForObject(GatewayClient.getServerUrl() + "/product/all/", ProductResponse[].class);
    }
}
