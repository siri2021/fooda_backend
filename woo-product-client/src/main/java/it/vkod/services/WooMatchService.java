package it.vkod.services;

import it.vkod.models.WooStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class WooMatchService {

    @Autowired
    private RestTemplate rest;

    @Value("${matching.service.all}")
    private String matchingServiceAllUrl;

    @Value("${matching.service.search}")
    private String matchingServiceSearchUrl;

    public WooStore[] apiMatch(@PathVariable("keyword") final String keyword) {
        return rest.getForObject(matchingServiceSearchUrl.replace("{keyword}", keyword), WooStore[].class);
    }

    public WooStore[] apiGetAll() {
        return rest.getForObject(matchingServiceAllUrl, WooStore[].class);
    }

}
