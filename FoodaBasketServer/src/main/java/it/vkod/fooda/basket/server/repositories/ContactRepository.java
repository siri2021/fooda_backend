package it.vkod.fooda.basket.server.repositories;

import it.vkod.fooda.basket.server.models.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ContactRepository extends MongoRepository<Contact, BigInteger> {
    Page<Contact> findAllByUserId(final BigInteger userId, Pageable page);
}
