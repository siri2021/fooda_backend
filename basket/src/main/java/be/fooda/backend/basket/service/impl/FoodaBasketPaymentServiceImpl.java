package be.fooda.backend.basket.service.impl;

import be.fooda.backend.basket.dao.FoodaBasketPaymentRepository;
import be.fooda.backend.basket.model.dto.FoodaBasketPaymentDto;
import be.fooda.backend.basket.service.FoodaBasketPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodaBasketPaymentServiceImpl implements FoodaBasketPaymentService {

    private FoodaBasketPaymentRepository repository;

    @Override
    public void add(FoodaBasketPaymentDto payment) {
        repository.save(payment);
    }

    @Override
    public void add(List<FoodaBasketPaymentDto> payments) {
        repository.saveAll(payments);
    }

    @Override
    public void edit(FoodaBasketPaymentDto payment, Long id) {
        if (repository.existsById(id))
            repository.save(payment);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(FoodaBasketPaymentDto payment) {
        repository.delete(payment);
    }

    @Override
    public Optional<FoodaBasketPaymentDto> get(Long id) {
        return repository.findById(id);
    }

    @Override
    public Page<FoodaBasketPaymentDto> get(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Page<FoodaBasketPaymentDto> get(Long userId, Pageable pageable) {
        return repository.findAllByUserId(userId, pageable);
    }

    @Override
    public Boolean exists(FoodaBasketPaymentDto payment) {
        return repository.exists(Example.of(payment));
    }

    @Override
    public Boolean exists(Long id) {
        return repository.existsById(id);
    }
}
