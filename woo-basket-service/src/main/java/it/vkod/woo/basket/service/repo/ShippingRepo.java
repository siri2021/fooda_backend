package it.vkod.woo.basket.service.repo;

import it.vkod.woo.basket.service.data.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ShippingRepo extends JpaRepository<Shipping, UUID> {
    List<Shipping> findAllByUserId(final String userId);
    boolean existsByUserIdAndAddressAndPostcode(final String userId, final String address, final String postcode);
    boolean existsByFirstNameAndLastNameAndUserIdAndAddressAndPostcode(final String firstName, final String lastName, final String userId, final String address, final String postcode);
    Shipping findByUserIdAndAddressAndPostcode(final String userId, final String address, final String postcode);
    Shipping findByFirstNameAndLastNameAndUserIdAndAddressAndPostcode(final String firstName, final String lastName, final String userId, final String address, final String postcode);
}
