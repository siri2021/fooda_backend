package it.vkod.fooda.basket.server.services;

import it.vkod.fooda.basket.server.models.Product;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    void add(final Product order);
    void edit(final Product order, final UUID id);
    void delete(final UUID id);
    void delete(final Product order);
    Optional<Product> get(final UUID id);
    Page<Product> getAll(final UUID userId);
    Boolean exists(final Product order);
    Boolean exists(final UUID id);
}
