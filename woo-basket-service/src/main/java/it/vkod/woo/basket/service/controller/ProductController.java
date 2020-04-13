package it.vkod.woo.basket.service.controller;

import it.vkod.woo.basket.service.model.Product;
import it.vkod.woo.basket.service.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = {"", "/"})
    public @NotNull Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public void addProducts(@RequestBody @NotNull Product product) {
        productService.save(product);
    }
}
