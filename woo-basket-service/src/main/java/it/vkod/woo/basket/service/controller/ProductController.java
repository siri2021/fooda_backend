package it.vkod.woo.basket.service.controller;

import it.vkod.woo.basket.service.model.Product;
import it.vkod.woo.basket.service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/basket/products")
public class ProductController {

    @Autowired
    private ProductService service;

//    public ProductController(ProductService service) {
//        this.service = service;
//    }

    @GetMapping(value = {"", "/"})
    public @NotNull Iterable<Product> getProducts() {
        return service.getAllProducts();
    }

    @PostMapping
    public void addProducts(@RequestBody @NotNull Product product) {
        if (service.save(product) != null) {
            System.out.println(product.getName() + " is added.");
        } else {
            System.out.println(product.getName() + " already exists.");
        }
    }
}
