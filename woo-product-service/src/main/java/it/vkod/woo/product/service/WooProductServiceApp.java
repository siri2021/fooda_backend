package it.vkod.woo.product.service;

import it.vkod.woo.product.service.models.Store;
import it.vkod.woo.product.service.utils.IpFromUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class WooProductServiceApp {

//    @Value("${store.id}")
//    private String id;
//
//    @Value("${store.url}")
//    private String url;
//
//    @Value("${server.port}")
//    private int port;
//
//    @Value("${store.cs}")
//    private String cs;
//
//    @Value("${store.ck}")
//    private String ck;
//
//    @Value("${store.name}")
//    private String name;
//
//    @Value("${store.desc}")
//    private String desc;

    @Autowired
    private RestTemplate rest;

    private static Logger LOG = LoggerFactory.getLogger(WooProductServiceApp.class);

    public static void main(String[] args) {
        LOG.info("GENERATING SETTINGS FOR WOO-PRODUCT-SERVICE APPLICATION");
        SpringApplication.run(WooProductServiceApp.class, args);
        LOG.info("APPLICATION WOO-PRODUCT-SERVICE IS NOW READY");
    }

//    @Override
//    public void run(String... args) {
//        final boolean storeExists = rest.getForObject("http://localhost:6602/api/stores/exists/" + id, Boolean.class);
//        if (!storeExists) {
//            Store store = new Store(url, IpFromUrl.getIp(url), port, cs, ck, name, desc, LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy hh.mm")), true);
//            final Store postedStore = rest.postForObject("http://localhost:6602/api/stores/", store, Store.class);
//            LOG.info(String.valueOf(postedStore));
//        }
//    }
}