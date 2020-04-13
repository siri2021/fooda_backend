package it.vkod.woo.matching.service.services;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Applications;
import it.vkod.woo.matching.service.payloads.productResponse.WooProduct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class WooMatchService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WooMatchService.class);

    @Autowired
    private EurekaClient discoveryClient;

    @Autowired
    private RestTemplate rest;

    public List<String> apiGetProductServiceUrls() {
        List<String> urls = new ArrayList<>();
        final Applications applications = discoveryClient.getApplications();
        applications.getRegisteredApplications().forEach(application -> {
            if (application.getName().equals("WOO-PRODUCT-SERVICE")) {
                application.getInstances().forEach(instanceInfo -> urls.add(instanceInfo.getHomePageUrl()));
            }
        });

        return urls;
    }

    // TODO still have issues with Circuit breakers, possibly timeout settings..
//    @HystrixCommand(fallbackMethod = "apiSearchFallback")
    public WooProduct[] apiSearch(final String url) {
        LOGGER.info("Searching products from " + url);
        return rest.getForObject(url, WooProduct[].class);
    }

    // a fallback method to be called if failure happened
    public WooProduct[] apiSearchFallback(final String url) {
        LOGGER.info("Woo product service is down.. !" + url);
        return new WooProduct[]{};
    }

}
