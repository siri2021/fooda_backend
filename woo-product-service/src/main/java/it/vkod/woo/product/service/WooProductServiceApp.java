package it.vkod.woo.product.service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import it.vkod.woo.product.service.payloads.store.request.WooStoreRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
public class WooProductServiceApp implements CommandLineRunner {

    private static Logger LOG = LoggerFactory.getLogger(WooProductServiceApp.class);

    @Autowired
    private RestTemplate rest;

    @Autowired
    private EurekaClient discoveryClient;

    @Value("${store.id}")
    private long storeId;

    @Value("${store.name}")
    private String name;

    @Value("${store.url}")
    private String url;

    @Value("${store.ck}")
    private String ck;

    @Value("${store.cs}")
    private String cs;

    private String getStoreServiceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("woo-store-service", false);
        return instance.getHomePageUrl();
    }

    public static void main(String[] args) {
        LOG.info("STARTING WOO PRODUCT SERVICE APPLICATION");
        SpringApplication.run(WooProductServiceApp.class, args);
        LOG.info("WOO PRODUCT SERVICE APPLICATION APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) {
        LOG.info(String.format("Adding %s info to database", name));
        rest.postForObject(getStoreServiceUrl() + "api/stores/insert/",
                WooStoreRequest.builder()
                        .storeId(storeId).name(name)
                        .url(url)
                        .consumerKey(ck)
                        .consumerSecret(cs)
                        .build(),
                WooStoreRequest.class);
        LOG.info(String.format("%s is added to database", name));
    }
}