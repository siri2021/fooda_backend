package it.vkod.fooda.basket.server.services;

import it.vkod.fooda.basket.server.models.Contact;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface ContactService {
    void add(final Contact order);
    void edit(final Contact order, final UUID id);
    void delete(final UUID id);
    void delete(final Contact order);
    Optional<Contact> get(final UUID id);
    Page<Contact> getAll(final UUID userId);
    Boolean exists(final Contact order);
    Boolean exists(final UUID id);
}
