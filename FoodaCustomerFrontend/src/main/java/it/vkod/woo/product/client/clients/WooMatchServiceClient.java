package it.vkod.woo.product.client.clients;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import it.vkod.woo.product.client.pojo.product.response.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@AllArgsConstructor
@Service
public class WooMatchServiceClient {

    private final RestTemplate rest;
    private final EurekaClient discoveryClient;

    private String getProductServiceUrls() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("woo-matching-service", false);
        return instance.getHomePageUrl();
    }

    public ProductResponse[] apiGetMatchFromAllStores(final String keyword) {
        return rest.getForObject(getProductServiceUrls() + "api/match/search/" + keyword, ProductResponse[].class);
    }

    public ProductResponse[] apiGetProductsFromAllStores() {
        return rest.getForObject(getProductServiceUrls() + "api/match/all", ProductResponse[].class);
    }
}
