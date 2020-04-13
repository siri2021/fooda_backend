package it.vkod.woo.basket.service.repository;

import it.vkod.woo.basket.service.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
