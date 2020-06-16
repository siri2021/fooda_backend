package it.vkod.fooda.basket.server.repositories;

import it.vkod.fooda.basket.server.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends MongoRepository<Product, UUID> {
    List<Product> findAllByUserId(final String userId);
    boolean existsByUserIdAndStoreIdAndProductId(final String userId, final long storeId, final long productId);
    Product findByUserIdAndStoreIdAndProductId(final String userId, final long storeId, final long productId);
}
