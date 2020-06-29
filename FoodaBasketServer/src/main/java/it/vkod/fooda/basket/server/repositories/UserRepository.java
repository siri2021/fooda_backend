package it.vkod.fooda.basket.server.repositories;

import it.vkod.fooda.basket.server.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface UserRepository extends MongoRepository<User, BigInteger> {
    boolean existsByUsernameAndPassword(final String userName, final String password);
}
