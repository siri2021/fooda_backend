package it.vkod.fooda.basket.server.services;

import it.vkod.fooda.basket.server.models.Address;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface AddressService {
    void add(final Address order);
    void edit(final Address order, final UUID id);
    void delete(final UUID id);
    void delete(final Address order);
    Optional<Address> get(final UUID id);
    Page<Address> getAll(final UUID userId);
    Boolean exists(final Address order);
    Boolean exists(final UUID id);
}
