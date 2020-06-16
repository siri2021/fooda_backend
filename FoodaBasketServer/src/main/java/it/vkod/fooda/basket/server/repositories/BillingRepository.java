package it.vkod.fooda.basket.server.repositories;

import it.vkod.fooda.basket.server.models.Billing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BillingRepository extends MongoRepository<Billing, UUID> {
    List<Billing> findAllByUserId(final String userId);
    boolean existsByUserIdAndAddressAndPostcode(final String userId, final String address, final String postcode);
    boolean existsByFirstNameAndLastNameAndUserIdAndAddressAndPostcode(final String firstName, final String lastName, final String userId, final String address, final String postcode);
    Billing findByUserIdAndAddressAndPostcode(final String userId, final String address, final String postcode);
    Billing findByFirstNameAndLastNameAndUserIdAndAddressAndPostcode(final String firstName, final String lastName, final String userId, final String address, final String postcode);
}
