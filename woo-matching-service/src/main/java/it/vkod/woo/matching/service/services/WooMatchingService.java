package it.vkod.woo.matching.service.services;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Applications;
import it.vkod.woo.matching.service.pojo.product.res.WooProduct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class WooMatchingService {

    private final EurekaClient discoveryClient;
    private final RestTemplate rest;

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
