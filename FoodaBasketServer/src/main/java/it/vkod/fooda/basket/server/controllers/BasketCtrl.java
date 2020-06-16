package it.vkod.fooda.basket.server.controllers;

import it.vkod.fooda.basket.server.models.Product;
import it.vkod.fooda.basket.server.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Arrays;

@Slf4j
@RestController
@RequestMapping("api/basket/products/")
public class BasketCtrl {

    @Autowired
    private ProductRepository repo;

    @PostMapping("insert")
    public void apiPostInsertProduct(@NotNull @RequestBody final Product product) {
        if (repo.existsByUserIdAndStoreIdAndProductId(product.getUserId(), product.getStoreId(), product.getProductId())) {
            apiPutIncreaseBasketProductQuantity(product);
        } else {
            repo.save(product);
            log.info("Product added: " + product.toString());
        }
    }

    @PutMapping("increase")
    public void apiPutIncreaseBasketProductQuantity(@NotNull @RequestBody final Product product) {
        final Product existingProduct = repo.findByUserIdAndStoreIdAndProductId(product.getUserId(), product.getStoreId(), product.getProductId());
        existingProduct.setQuantity(existingProduct.getQuantity() + 1);
        repo.save(existingProduct);
        log.info("Product quantity increased: " + product.toString());
    }

    @PutMapping("decrease")
    public void apiPutDecreaseBasketProductQuantity(@NotNull @RequestBody final Product product) {
        final Product existingProduct = repo.findByUserIdAndStoreIdAndProductId(product.getUserId(), product.getStoreId(), product.getProductId());
        if (existingProduct.getQuantity() > 0) {
            existingProduct.setQuantity(existingProduct.getQuantity() - 1);
            repo.save(existingProduct);
        } else {
            apiDeleteBasketProduct(product);
            log.info("Product quantity decreased: " + product.toString());
        }
    }

    @DeleteMapping("delete")
    public void apiDeleteBasketProduct(@NotNull @RequestBody final Product product) {
        repo.delete(product);
    }

    @DeleteMapping("clear/{user_id}")
    public void apiClearBasketProducts(@PathVariable("user_id") final String userId) {
        final Product[] product = apiGetBasketProducts(userId);
        Arrays.stream(product).forEach(this::apiDeleteBasketProduct);
    }

    @DeleteMapping("clear/{user_id}/store/{store_id}")
    public void apiClearBasketProducts(@PathVariable("user_id") final String userId, @PathVariable("user_id") final long storeId) {
        final Product[] product = apiGetBasketProducts(userId);
        Arrays.stream(product)
                .filter(b -> b.getStoreId() == storeId)
                .forEach(this::apiDeleteBasketProduct);
    }

    @GetMapping("select/{user_id}")
    public Product[] apiGetBasketProducts(@PathVariable("user_id") final String userId) {
        return repo.findAllByUserId(userId).toArray(Product[]::new);
    }
}
