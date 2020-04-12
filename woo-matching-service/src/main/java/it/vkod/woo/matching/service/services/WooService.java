package it.vkod.woo.matching.service.services;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Applications;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import it.vkod.woo.matching.service.models.WooStore;
import it.vkod.woo.matching.service.models.pojo.WooProduct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class WooService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WooService.class);

    @Autowired
    private EurekaClient discoveryClient;

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

    private String storeServiceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("woo-store-db", false);
        return instance.getHomePageUrl();
    }

    @Autowired
    private RestTemplate rest;

    /* TODO : CIRCUIT BREAKER DOES NOT WORK ..
    STH WRONG WITH HYSTRIX FALLBACK .. WHEN I ACTIVATE THE CODE A LINE BELOW, IT RETURNS WOOPRODUCT AUTOMATICALY NULL
    @HystrixCommand(fallbackMethod = "apiSearchFallback")
*/

    //    @HystrixCommand(fallbackMethod = "apiSearchFallback")
    public WooProduct[] apiSearch(final String url) {
        LOGGER.info("Searching products from " + url);
        return rest.getForObject(url, WooProduct[].class);
    }

    public WooStore[] apiGetActiveStores() {
//        final String STORES_URL = "http://localhost:6602/api/stores/all";
        final String STORES_URL = storeServiceUrl() + "api/stores/all";
        LOGGER.info("WooCommerce Stores Endpoint: " + STORES_URL);
        return rest.getForObject(STORES_URL, WooStore[].class);
    }

    // a fallback method to be called if failure happened
    public WooProduct[] apiSearchFallback(final String url) {
        LOGGER.info("Woo product service is down.. !" + url);
        return new WooProduct[]{};
    }

}
