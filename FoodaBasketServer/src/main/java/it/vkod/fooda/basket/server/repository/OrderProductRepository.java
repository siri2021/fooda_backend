package it.vkod.fooda.basket.server.repository;

import it.vkod.fooda.basket.server.model.OrderProduct;
import it.vkod.fooda.basket.server.model.OrderProductPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductPK> {
}
