package it.vkod.fooda.basket.server.repositories;

import it.vkod.fooda.basket.server.models.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, BigInteger> {
    List<Product> findByUserId(final BigInteger userId, Pageable page);
}
