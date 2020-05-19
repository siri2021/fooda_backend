package it.vkod.woo.basket.service.repositories;

import it.vkod.woo.basket.service.payloads.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BillingRepo extends JpaRepository<Billing, UUID> {
    List<Billing> findAllByUserId(final String userId);
    boolean existsByUserIdAndAddressAndPostcode(final String userId, final String address, final String postcode);
    boolean existsByFirstNameAndLastNameAndUserIdAndAddressAndPostcode(final String firstName, final String lastName, final String userId, final String address, final String postcode);
    Billing findByUserIdAndAddressAndPostcode(final String userId, final String address, final String postcode);
    Billing findByFirstNameAndLastNameAndUserIdAndAddressAndPostcode(final String firstName, final String lastName, final String userId, final String address, final String postcode);
}
