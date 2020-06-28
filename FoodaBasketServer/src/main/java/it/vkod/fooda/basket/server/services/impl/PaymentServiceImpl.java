package it.vkod.fooda.basket.server.services.impl;

import it.vkod.fooda.basket.server.models.Payment;
import it.vkod.fooda.basket.server.repositories.PaymentRepository;
import it.vkod.fooda.basket.server.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository repository;

    @Override
    public void add(Payment payment) {
        repository.save(payment);
    }

    @Override
    public void edit(Payment payment, UUID id) {
        if (repository.existsById(id))
            repository.save(payment);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Payment payment) {
        repository.delete(payment);
    }

    @Override
    public Optional<Payment> get(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Page<Payment> getAll(UUID userId) {
        return repository.findAllByUserId(userId);
    }

    @Override
    public Boolean exists(Payment payment) {
        return repository.exists(Example.of(payment));
    }

    @Override
    public Boolean exists(UUID id) {
        return repository.existsById(id);
    }
}
