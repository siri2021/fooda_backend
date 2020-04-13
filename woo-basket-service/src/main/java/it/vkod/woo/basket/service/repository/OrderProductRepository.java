package it.vkod.woo.basket.service.repository;

import it.vkod.woo.basket.service.model.OrderProduct;
import it.vkod.woo.basket.service.model.OrderProductPK;
import org.springframework.data.repository.CrudRepository;

public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductPK> {
}
