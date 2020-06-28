package it.vkod.fooda.basket.server.services;

import it.vkod.fooda.basket.server.models.Order;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface OrderService {
    void add(final Order order);
    void edit(final Order order, final UUID id);
    void delete(final UUID id);
    void delete(final Order order);
    Optional<Order> get(final UUID id);
    Page<Order> getAll(final UUID userId);
    Boolean exists(final Order order);
    Boolean exists(final UUID id);
}
