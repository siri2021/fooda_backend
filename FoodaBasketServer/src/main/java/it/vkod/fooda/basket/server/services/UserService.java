package it.vkod.fooda.basket.server.services;

import it.vkod.fooda.basket.server.models.User;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    void add(final User order);
    void edit(final User order, final UUID id);
    void delete(final UUID id);
    void delete(final User order);
    Optional<User> get(final UUID id);
    Page<User> getAll(final UUID userId);
    Boolean exists(final User order);
    Boolean exists(final UUID id);
}
