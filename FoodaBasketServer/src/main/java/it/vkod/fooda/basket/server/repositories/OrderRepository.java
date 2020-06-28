package it.vkod.fooda.basket.server.repositories;

import it.vkod.fooda.basket.server.models.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends MongoRepository<Order, UUID> {
    Page<Order> findAllByUserId(final UUID userId);
}
