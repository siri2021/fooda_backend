package it.vkod.woo.collector.service.contollers;

import it.vkod.woo.collector.service.models.Product;
import it.vkod.woo.collector.service.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/collect/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public @NotNull Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public void apiPostProduct(@RequestBody List<Product> productList) {
        productList.forEach(product -> {
            if (!productService.exists(product)) {
                productService.save(product);
            }
        });
    }

    @DeleteMapping
    public void apiDeleteProduct(@RequestBody Product product) {
        productService.delete(product);
    }

    @DeleteMapping("{storeId}")
    public void apiDeleteProductsByStoreId(@PathVariable(name = "storeId") final Long storeId) {
        productService.deleteAllByStoreId(storeId);
    }
}