package it.vkod.fooda.customer.frontend.clients;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import it.vkod.fooda.customer.frontend.models.product.request.ProductRequest;
import it.vkod.fooda.customer.frontend.models.product.response.ProductResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class WooCommerceClient {

    @Autowired
    private RestTemplate rest;

    @Autowired
    private EurekaClient discoveryClient;

    private String getOrderServiceUrl(final long storeId) {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("woocommerce-server-" + storeId, false);
        return instance.getHomePageUrl();
    }

    public ProductResponse[] apiGetProducts(final int page, final long storeId) {
        return rest.getForObject(getOrderServiceUrl(storeId) + "api/woocommerce/products/" + page, ProductResponse[].class);
    }

    public ProductResponse apiGetProductOne(final int productId, final long storeId) {
        return rest.getForObject(getOrderServiceUrl(storeId) + "api/woocommerce/products/" + productId, ProductResponse.class);
    }

    public void apiAddProduct(final ProductRequest productRequest, final long storeId) {
        rest.postForObject(getOrderServiceUrl(storeId) + "api/woocommerce/products/", productRequest, ProductRequest.class);
    }

    public ProductResponse apiAddProductWithResponse(final ProductRequest productRequest, final long storeId) {
        return rest.postForObject(getOrderServiceUrl(storeId) + "api/woocommerce/products/", productRequest, ProductResponse.class);
    }

}
