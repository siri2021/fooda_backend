package it.vkod.fooda.basket.server.controllers;

import it.vkod.fooda.basket.server.models.Product;
import it.vkod.fooda.basket.server.services.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("basket/product/")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("{productId}")
    public Product getProduct(@PathVariable final BigInteger productId) {
        return productService.get(productId).orElse(null);
    }

    @GetMapping("page/{page}")
    public Page<Product> getProducts(@PathVariable final int page) {
        return productService.get(PageRequest.of(page - 1, 10));
    }

    @GetMapping("{userId}/page/{page}")
    public Page<Product> getProductsByUser(@PathVariable final BigInteger userId, @PathVariable final int page) {
        return productService.get(userId, PageRequest.of(page - 1, 10));
    }

    @PostMapping
    public void addProduct(@RequestBody final Product product) {
        productService.add(product);
    }

    @PutMapping("{productId}")
    public void editProduct(@RequestBody final Product product, @PathVariable final BigInteger productId) {
        if (productService.exists(productId).equals(true))
            productService.edit(product, productId);
    }

    @DeleteMapping("{productId}")
    public void deleteProduct(@PathVariable final BigInteger productId) {
        productService.delete(productId);
    }

    @DeleteMapping
    public void deleteProduct(@RequestBody final Product product) {
        productService.delete(product);
    }

}
