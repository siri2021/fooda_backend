package it.vkod.woo.matching.service.controllers;

import it.vkod.woo.matching.service.payloads.productResponse.WooProduct;
import it.vkod.woo.matching.service.services.WooMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.Cacheable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/match")
public class WooMatchController {

    @Autowired
    private WooMatchService wooMatchService;

    @GetMapping("urls")
    public List<String> apiGetProductServiceUrls() {
        return wooMatchService.apiGetProductServiceUrls();
    }

    @Cacheable("/match")
    @GetMapping("{keyword}")
    public List<WooProduct> apiMatch(@PathVariable("keyword") final String keyword) {
        List<WooProduct> wooProducts = new ArrayList<>();
        final List<String> activeProductServices = apiGetProductServiceUrls();
        activeProductServices.forEach(url -> {
            final String urlFinal = url + "api/products/search/" + keyword;
            final WooProduct[] matchedProducts = wooMatchService.apiSearch(urlFinal);
            wooProducts.addAll(Arrays.asList(matchedProducts));
        });
        return wooProducts;
    }
}
