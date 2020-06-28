package it.vkod.fooda.basket.server.controllers;

import it.vkod.fooda.basket.server.models.Product;
import it.vkod.fooda.basket.server.services.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("basket/product/")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("{productId}")
    public Product getProduct(@PathVariable final UUID id) {
        return productService.get(id).orElse(null);
    }

    @GetMapping("{userId}")
    public Page<Product> getProductsByUser(@PathVariable final UUID userId) {
        return productService.getAll(userId);
    }

    @PostMapping
    public void addProduct(@RequestBody final Product product) {
        product.setId(UUID.randomUUID());
        productService.add(product);
    }

    @PutMapping("{productId}")
    public void editProduct(@RequestBody final Product product, @PathVariable final UUID productId) {
        if (productService.exists(productId))
            productService.edit(product, productId);
    }

    @DeleteMapping("{productId}")
    public void deleteProduct(@PathVariable final UUID productId) {
        productService.delete(productId);
    }

    @DeleteMapping
    public void deleteProduct(@RequestBody final Product product) {
        productService.delete(product);
    }

}
