package be.fooda.backend.product.services;

import be.fooda.backend.commons.model.woocommerce.product.response.ProductResponseList;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Applications;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ProductClient {

    @Autowired
    private EurekaClient discoveryClient;

    @Autowired
    private RestTemplate rest;

    public List<String> apiClientGetServiceUrls(final String serviceName) {
        List<String> urls = new ArrayList<>();
        final Applications applications = discoveryClient.getApplications();
        applications.getRegisteredApplications().forEach(application -> {
            if (application.getName().contains(serviceName)) {
                application.getInstances().forEach(instanceInfo -> urls.add(instanceInfo.getHomePageUrl()));
            }
        });

        return urls;
    }

    // TODO still have issues with Circuit breakers, possibly timeout settings..
//    @HystrixCommand(fallbackMethod = "searchFallback")
    @SneakyThrows
    public ProductResponseList search(final String url) {
        log.info(String.format("Searching products from %s", url));
        return rest.getForObject(url, ProductResponseList.class);
    }

    // a fallback method to be called if failure happened
    public ProductResponseList searchFallback(final String url) {
        log.info(String.format("Woo product service is down.. ! %s", url));
        return new ProductResponseList();
    }

}
