package it.vkod.fooda.basket.server.repositories;

import it.vkod.fooda.basket.server.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends MongoRepository<Product, UUID> {
    Page<Product> findAllByUserId(final UUID userId);
}
