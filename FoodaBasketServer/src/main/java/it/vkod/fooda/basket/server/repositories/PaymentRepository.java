package it.vkod.fooda.basket.server.repositories;

import it.vkod.fooda.basket.server.models.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, UUID> {
    List<Payment> findAllByUserId(final String userId);
    List<Payment> findAllByUserIdAndStoreId(final String userId, final long storeId);
}
