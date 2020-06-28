package it.vkod.fooda.basket.server.repositories;

import it.vkod.fooda.basket.server.models.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, UUID> {
    Page<Payment> findAllByUserId(final UUID userId);
}
