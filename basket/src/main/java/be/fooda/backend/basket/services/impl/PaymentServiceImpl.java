package be.fooda.backend.basket.services.impl;

import be.fooda.backend.basket.models.Payment;
import be.fooda.backend.basket.repositories.PaymentRepository;
import be.fooda.backend.basket.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository repository;

    @Override
    public void add(Payment payment) {
        repository.save(payment);
    }

    @Override
    public void add(List<Payment> payments) {
        repository.saveAll(payments);
    }

    @Override
    public void edit(Payment payment, BigInteger id) {
        if (repository.existsById(id))
            repository.save(payment);
    }

    @Override
    public void delete(BigInteger id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Payment payment) {
        repository.delete(payment);
    }

    @Override
    public Optional<Payment> get(BigInteger id) {
        return repository.findById(id);
    }

    @Override
    public Page<Payment> get(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Page<Payment> get(BigInteger userId, Pageable pageable) {
        return repository.findAllByUserId(userId, pageable);
    }

    @Override
    public Boolean exists(Payment payment) {
        return repository.exists(Example.of(payment));
    }

    @Override
    public Boolean exists(BigInteger id) {
        return repository.existsById(id);
    }
}
