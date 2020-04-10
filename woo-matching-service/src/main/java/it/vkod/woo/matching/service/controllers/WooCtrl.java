package it.vkod.woo.matching.service.controllers;

import it.vkod.woo.matching.service.models.WooStore;
import it.vkod.woo.matching.service.models.pojo.WooProduct;
import it.vkod.woo.matching.service.services.WooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.Cacheable;

import java.util.Arrays;

@RestController
public class WooCtrl {

    @Autowired
    private WooService wooService;

    @Cacheable(value = "/match")
    @GetMapping("/api/match/{keyword}")
    public WooStore[] apiMatch(@PathVariable("keyword") final String keyword) {
        final WooStore[] wooStoreCollection = wooService.apiGetActiveStores();
        Arrays.stream(wooStoreCollection).forEach(store -> {
            final String url = "http://localhost:" + store.getPort() + "/wc/search/" + keyword;
            final WooProduct[] matchedProducts = wooService.apiSearch(url);
            store.setMatchedProducts(matchedProducts);
        });
        return wooStoreCollection;
    }

    @Cacheable(value = "/all")
    @GetMapping("/api/match/all")
    public WooStore[] apiGetAll() {
        final WooStore[] wooStoreCollection = wooService.apiGetActiveStores();
        Arrays.stream(wooStoreCollection).forEach(store -> {
            final String url = "http://localhost:" + store.getPort() + "/wc/page/1";
            final WooProduct[] allProductByPage = wooService.apiSearch(url);
            store.setMatchedProducts(allProductByPage);
        });
        return wooStoreCollection;
    }

}
