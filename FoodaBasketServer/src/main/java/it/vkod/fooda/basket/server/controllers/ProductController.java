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

    @GetMapping("getByProductId")
    public Product getProduct(@RequestParam final BigInteger productId) {
        return productService.get(productId).orElse(null);
    }

    @GetMapping("getAll")
    public Page<Product> getProducts(@RequestParam final int page) {
        return productService.get(PageRequest.of(page - 1, 10));
    }

    @GetMapping("getAllByUserId")
    public Page<Product> getProductsByUser(@RequestParam final BigInteger userId, @RequestParam final int page) {
        return productService.get(userId, PageRequest.of(page - 1, 10));
    }

    @PostMapping("add")
    public void addProduct(@RequestBody final Product product) {
        productService.add(product);
    }

    @PutMapping("edit")
    public void editProduct(@RequestBody final Product product) {
        if (productService.exists(product.getProductId()).equals(true))
            productService.edit(product, product.getProductId());
    }

    @PutMapping("increaseByProductId")
    public void increaseProductQuantity(@RequestParam final BigInteger productId) {
        productService.increase(productId);
    }

    @PutMapping("increase")
    public void increaseProductQuantity(@RequestBody final Product product) {
        productService.increase(product);
    }

    @PutMapping("decreaseByProductId")
    public void decreaseProductQuantity(@RequestParam final BigInteger productId) {
        productService.decrease(productId);
    }

    @PutMapping("decrease")
    public void decreaseProductQuantity(@RequestBody final Product product) {
        productService.decrease(product);
    }

    @DeleteMapping("clearByUserId")
    public void clearProducts(@RequestParam final BigInteger userId, @RequestParam final String sessionId) {
        productService.clear(userId, sessionId);
    }

    @DeleteMapping("deleteByProductId")
    public void deleteProduct(@RequestParam final BigInteger productId) {
        productService.delete(productId);
    }

    @DeleteMapping("delete")
    public void deleteProduct(@RequestBody final Product product) {
        productService.delete(product);
    }

}
