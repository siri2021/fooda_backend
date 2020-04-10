package it.vkod.woo.collector.service.services;

import it.vkod.woo.collector.service.models.Product;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface ProductService {

    @NotNull Iterable<Product> getAllProducts();

    Product getProduct(@Min(value = 1L, message = "Invalid product ID.") long id);

    Product save(Product product);

    void delete(Product product);

    void deleteAllByStoreId(@Min(value = 1L, message = "Invalid store ID.") long storeId);

    boolean exists(Product product);

}