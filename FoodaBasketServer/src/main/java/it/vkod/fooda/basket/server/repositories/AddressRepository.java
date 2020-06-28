package it.vkod.fooda.basket.server.repositories;

import it.vkod.fooda.basket.server.models.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressRepository extends MongoRepository<Address, UUID> {
    Page<Address> findAllByUserId(final UUID userId);
}
