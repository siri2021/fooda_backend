package it.vkod.fooda.basket.server.repositories;

import it.vkod.fooda.basket.server.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends MongoRepository<Order, UUID> {
    List<Order> findAllByUserId(final String userId);
}
