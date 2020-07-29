package be.fooda.backend.product.controllers;

import be.fooda.backend.product.models.product.response.ProductResponseList;
import be.fooda.backend.product.services.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.Cacheable;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private ProductClient productClient;


    @Cacheable("/search")
    @GetMapping("search")
    public ProductResponseList searchProductsFromStores(@RequestParam final String keyword, @RequestParam final int page) {
        ProductResponseList list = new ProductResponseList();
        final List<String> activeProductServices = productClient.apiClientGetServiceUrls("WOOCOMMERCE-SERVER");
        activeProductServices.forEach(url -> {
            final ProductResponseList matchedProducts = productClient.search(url + "api/woocommerce/product/search?keyword=" + keyword + "&page=" + page);
            list.addAll(matchedProducts);
        });
        return list;
    }

    @Cacheable("/all")
    @GetMapping("getAll")
    public ProductResponseList getAllProductsFromStores(@RequestParam final int page) {
        ProductResponseList list = new ProductResponseList();
        final List<String> activeProductServices = productClient.apiClientGetServiceUrls("WOOCOMMERCE-SERVER");
        activeProductServices.forEach(url -> {
            final ProductResponseList matchedProducts = productClient.search(url + "api/woocommerce/product/getAllPaged?page=" + page);
            list.addAll(matchedProducts);
        });
        return list;
    }
}
