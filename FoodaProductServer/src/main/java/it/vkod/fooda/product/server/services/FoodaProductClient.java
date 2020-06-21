package it.vkod.fooda.product.server.services;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Applications;
import it.vkod.fooda.product.server.models.product.response.WooProduct;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FoodaProductClient {

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
//    @HystrixCommand(fallbackMethod = "apiSearchFallback")
    @Async
    @SneakyThrows
    public WooProduct[] apiSearch(final String url) {
        log.info(String.format("Searching products from %s", url));
        return rest.getForObject(url, WooProduct[].class);
    }

    // a fallback method to be called if failure happened
    public WooProduct[] apiSearchFallback(final String url) {
        log.info(String.format("Woo product service is down.. ! %s", url));
        return new WooProduct[]{};
    }

}
