package it.vkod.woo.collector.service.repositories;

import it.vkod.woo.collector.service.models.OrderProduct;
import it.vkod.woo.collector.service.models.OrderProductPK;
import org.springframework.data.repository.CrudRepository;

public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductPK> {
}