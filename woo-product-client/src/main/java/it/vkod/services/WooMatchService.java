package it.vkod.services;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import it.vkod.models.WooStore;
import it.vkod.models.response.WooProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class WooMatchService {

    @Autowired
    private RestTemplate rest;

    @Autowired
    private EurekaClient discoveryClient;

    private String getMatchingServiceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("woo-matching-service", false);
        return instance.getHomePageUrl();
    }

    public WooProduct[] apiGetMatchFromAllStores(final String keyword) {
        return rest.getForObject(getMatchingServiceUrl() + "api/match/" + keyword, WooProduct[].class);
    }
}
