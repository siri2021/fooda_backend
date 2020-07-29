package be.fooda.backend.basket.repositories;

import be.fooda.backend.basket.models.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, BigInteger> {
    Page<Payment> findAllByUserId(final BigInteger userId, Pageable page);
}
