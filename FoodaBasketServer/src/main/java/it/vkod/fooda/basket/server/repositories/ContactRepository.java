package it.vkod.fooda.basket.server.repositories;

import it.vkod.fooda.basket.server.models.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ContactRepository extends MongoRepository<Contact, UUID> {
    Page<Contact> findAllByUserId(final UUID userId);
}
