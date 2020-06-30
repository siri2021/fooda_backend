package it.vkod.fooda.basket.server.repositories;

import it.vkod.fooda.basket.server.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, BigInteger> {
    Optional<User> findByUsername(final String username);
    Boolean existsByUsername(final String username);
}
