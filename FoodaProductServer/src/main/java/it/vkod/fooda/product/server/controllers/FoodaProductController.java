package it.vkod.fooda.product.server.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.vkod.fooda.product.server.models.product.response.WooProduct;
import it.vkod.fooda.product.server.services.FoodaProductClient;
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

@Slf4j
@RestController
@RequestMapping("api/product")
public class FoodaProductController {

    @Autowired
    private FoodaProductClient foodaProductClient;

    @ApiOperation(httpMethod = "GET", value = "Search products by name, description, tag, category and more..", response = List.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Products are successfully fetched"),
            @ApiResponse(code = 404, message = "Products not found"),
            @ApiResponse(code = 500, message = "The products could not be fetched")
    })
    @Cacheable("/search")
    @GetMapping("search/{keyword}")
    public List<WooProduct[]> apiCallSearch(@PathVariable("keyword") final String keyword) {
        List<WooProduct[]> wooProducts = new ArrayList<>();
        final List<String> activeProductServices = foodaProductClient.apiClientGetServiceUrls("WOOCOMMERCE-SERVER");
        activeProductServices.forEach(url -> {
            final String urlFinal = url + "api/woocommerce/products/search/" + keyword;
            final WooProduct[] matchedProducts = foodaProductClient.apiSearch(urlFinal);
            Collections.addAll(wooProducts, matchedProducts);
        });
        return wooProducts;
    }

    @ApiOperation(httpMethod = "GET", value = "Fetches best selling products", response = List.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Products are successfully fetched"),
            @ApiResponse(code = 404, message = "Products not found"),
            @ApiResponse(code = 500, message = "The products could not be fetched")
    })
    @Cacheable("/all")
    @GetMapping("all")
    public List<WooProduct[]> apiCallGetAll() {
        List<WooProduct[]> wooProducts = new ArrayList<>();
        final List<String> activeProductServices = foodaProductClient.apiClientGetServiceUrls("WOOCOMMERCE-SERVER");
        activeProductServices.forEach(url -> {
            final String urlFinal = url + "api/woocommerce/products/page/1";
            final WooProduct[] matchedProducts = foodaProductClient.apiSearch(urlFinal);
            Collections.addAll(wooProducts, matchedProducts);
        });
        return wooProducts;
    }
}
