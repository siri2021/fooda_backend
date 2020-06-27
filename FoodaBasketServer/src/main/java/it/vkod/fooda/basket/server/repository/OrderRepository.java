package it.vkod.fooda.basket.server.repository;

import it.vkod.fooda.basket.server.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
