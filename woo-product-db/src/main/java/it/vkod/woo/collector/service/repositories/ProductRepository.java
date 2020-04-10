package it.vkod.woo.collector.service.repositories;


import it.vkod.woo.collector.service.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

    boolean existsByNameAndStoreId(String name, Long storeId);

    Iterable<Product> findAllByStoreId(Long storeId);
}