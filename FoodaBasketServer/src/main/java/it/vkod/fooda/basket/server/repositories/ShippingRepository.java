package it.vkod.fooda.basket.server.repositories;

import it.vkod.fooda.basket.server.models.Shipping;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ShippingRepository extends MongoRepository<Shipping, UUID> {
    List<Shipping> findAllByUserId(final String userId);
    boolean existsByUserIdAndAddressAndPostcode(final String userId, final String address, final String postcode);
    boolean existsByFirstNameAndLastNameAndUserIdAndAddressAndPostcode(final String firstName, final String lastName, final String userId, final String address, final String postcode);
    Shipping findByUserIdAndAddressAndPostcode(final String userId, final String address, final String postcode);
    Shipping findByFirstNameAndLastNameAndUserIdAndAddressAndPostcode(final String firstName, final String lastName, final String userId, final String address, final String postcode);
}
