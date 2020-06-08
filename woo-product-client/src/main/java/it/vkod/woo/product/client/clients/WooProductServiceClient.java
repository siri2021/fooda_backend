package it.vkod.woo.product.client.clients;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import it.vkod.woo.product.client.pojo.product.request.ProductRequest;
import it.vkod.woo.product.client.pojo.product.response.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@AllArgsConstructor
@Service
public class WooProductServiceClient {

    private final RestTemplate rest;
    private final EurekaClient discoveryClient;

    private String getOrderServiceUrl(final long storeId) {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("woo-order-service-" + storeId, false);
        return instance.getHomePageUrl();
    }

    public ProductResponse[] apiGetProducts(final int page, final long storeId) {
        return rest.getForObject(getOrderServiceUrl(storeId) + "api/products/" + page, ProductResponse[].class);
    }

    public ProductResponse apiGetProductOne(final int productId, final long storeId) {
        return rest.getForObject(getOrderServiceUrl(storeId) + "api/products/" + productId, ProductResponse.class);
    }

    public void apiAddProduct(final ProductRequest productRequest, final long storeId) {
        rest.postForObject(getOrderServiceUrl(storeId) + "api/products/", productRequest, ProductRequest.class);
    }

    public ProductResponse apiAddProductWithResponse(final ProductRequest productRequest, final long storeId) {
        return rest.postForObject(getOrderServiceUrl(storeId) + "api/products/", productRequest, ProductResponse.class);
    }

}
