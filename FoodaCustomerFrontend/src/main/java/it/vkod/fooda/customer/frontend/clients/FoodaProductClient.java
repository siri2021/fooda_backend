package it.vkod.fooda.customer.frontend.clients;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
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

    @Autowired
    private EurekaClient discoveryClient;

    private String getProductServiceUrls() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("fooda-product-server", false);
        return instance.getHomePageUrl();
    }

    public ProductResponse[] apiGetMatchFromAllStores(final String keyword) {
        return rest.getForObject(getProductServiceUrls() + "api/woocommerce/match/search/" + keyword, ProductResponse[].class);
    }

    public ProductResponse[] apiGetProductsFromAllStores() {
        return rest.getForObject(getProductServiceUrls() + "api/woocommerce/match/all", ProductResponse[].class);
    }
}
