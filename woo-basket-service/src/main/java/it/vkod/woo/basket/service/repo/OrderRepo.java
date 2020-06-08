package it.vkod.woo.basket.service.repo;

import it.vkod.woo.basket.service.data.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepo extends JpaRepository<Order, UUID> {
    List<Order> findAllByUserId(final String userId);
}
