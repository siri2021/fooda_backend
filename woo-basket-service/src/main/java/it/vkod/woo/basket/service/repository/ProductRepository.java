package it.vkod.woo.basket.service.repository;

import it.vkod.woo.basket.service.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
