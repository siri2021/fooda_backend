package it.vkod.woo.collector.service.repositories;

import it.vkod.woo.collector.service.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}