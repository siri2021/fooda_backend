package it.vkod.woo.basket.service.repositories;

import it.vkod.woo.basket.service.payloads.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ContactRepo extends JpaRepository<Contact, UUID> {
    List<Contact> findAllByUserId(final long userId);
    boolean existsByUserIdAndAddressAndPostcode(final long userId, final String address, final String postcode);
    Contact findByUserIdAndAddressAndPostcode(final long userId, final String address, final String postcode);
}
