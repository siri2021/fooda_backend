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
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/product")
public class FoodaProductController {

    @Autowired
    private FoodaProductClient foodaProductClient;

    @Cacheable("/match")
    @GetMapping("search/{keyword}") // api/match/search/{keyword}
    public List<WooProduct> apiMatch(@PathVariable("keyword") final String keyword) {
        List<WooProduct> wooProducts = new ArrayList<>();
        final List<String> activeProductServices = foodaProductClient.apiClientGetServiceUrls("WOOCOMMERCE-SERVER");
        activeProductServices.forEach(url -> {
            final String urlFinal = url + "api/woocommerce/products/search/" + keyword;
            final WooProduct[] matchedProducts = foodaProductClient.apiSearch(urlFinal);
            wooProducts.addAll(Arrays.asList(matchedProducts));
        });
        return wooProducts;
    }

    @Cacheable("/all")
    @GetMapping("all")
    public List<WooProduct> apiAll() {
        List<WooProduct> wooProducts = new ArrayList<>();
        final List<String> activeProductServices = foodaProductClient.apiClientGetServiceUrls("WOOCOMMERCE-SERVER");
        activeProductServices.forEach(url -> {
            final String urlFinal = url + "api/woocommerce/products/page/1";
            final WooProduct[] matchedProducts = foodaProductClient.apiSearch(urlFinal);
            wooProducts.addAll(Arrays.asList(matchedProducts));
        });
        return wooProducts;
    }
}
