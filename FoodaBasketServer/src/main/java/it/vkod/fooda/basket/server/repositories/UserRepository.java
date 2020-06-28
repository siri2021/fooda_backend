package it.vkod.fooda.basket.server.repositories;

import it.vkod.fooda.basket.server.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends MongoRepository<User, UUID> {
    Page<User> findAllByUserId(final UUID userId);
}
