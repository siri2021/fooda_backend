package it.vkod.woo.basket.service.service;

import it.vkod.woo.basket.service.model.Product;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface ProductService {

    @NotNull Iterable<Product> getAllProducts();

    Product getProduct(@Min(value = 1L, message = "Invalid product ID.") long id);

    Product save(Product product);

    boolean existsByIdAndStoreId(final long id, final long storeId);
}
