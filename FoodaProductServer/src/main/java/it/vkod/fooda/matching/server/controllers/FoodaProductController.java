package it.vkod.fooda.matching.server.controllers;

import it.vkod.fooda.matching.server.models.product.response.WooProduct;
import it.vkod.fooda.matching.server.services.FoodaProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.Cacheable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping("api/product")
public class FoodaProductController {

    @Autowired
    private FoodaProductClient foodaProductClient;

    @Cacheable("/search")
    @GetMapping("search/{keyword}")
    public List<CompletableFuture<WooProduct[]>> apiCallSearch(@PathVariable("keyword") final String keyword) {
        List<CompletableFuture<WooProduct[]>> wooProducts = new ArrayList<>();
        final List<String> activeProductServices = foodaProductClient.apiClientGetServiceUrls("WOOCOMMERCE-SERVER");
        activeProductServices.forEach(url -> {
            final String urlFinal = url + "api/woocommerce/products/search/" + keyword;
            final CompletableFuture<WooProduct[]> matchedProducts = foodaProductClient.apiSearch(urlFinal);
            wooProducts.addAll(Collections.singletonList(matchedProducts));
        });
        return wooProducts;
    }

    @Cacheable("/all")
    @GetMapping("all")
    public List<CompletableFuture<WooProduct[]>> apiCallGetAll() {
        List<CompletableFuture<WooProduct[]>> wooProducts = new ArrayList<>();
        final List<String> activeProductServices = foodaProductClient.apiClientGetServiceUrls("WOOCOMMERCE-SERVER");
        activeProductServices.forEach(url -> {
            final String urlFinal = url + "api/woocommerce/products/page/1";
            final CompletableFuture<WooProduct[]> matchedProducts = foodaProductClient.apiSearch(urlFinal);
            wooProducts.addAll(Collections.singletonList(matchedProducts));
        });
        return wooProducts;
    }
}
