package be.fooda.backend.basket.service.impl;

import be.fooda.backend.basket.dao.FoodaBasketOrderRepository;
import be.fooda.backend.basket.model.dto.FoodaBasketOrderDto;
import be.fooda.backend.basket.service.FoodaBasketOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodaBasketOrderServiceImpl implements FoodaBasketOrderService {

    @Autowired
    private FoodaBasketOrderRepository repository;

    @Override
    public void add(FoodaBasketOrderDto order) {
        repository.save(order);
    }

    @Override
    public void add(List<FoodaBasketOrderDto> orders) {
        repository.saveAll(orders);
    }

    @Override
    public void edit(FoodaBasketOrderDto order, Long id) {
        if (repository.existsById(id))
            repository.save(order);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(FoodaBasketOrderDto order) {
        repository.delete(order);
    }

    @Override
    public Optional<FoodaBasketOrderDto> get(Long id) {
        return repository.findById(id);
    }

    @Override
    public Page<FoodaBasketOrderDto> get(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Page<FoodaBasketOrderDto> get(Long userId, Pageable pageable) {
        return repository.findAllByUserId(userId, pageable);
    }

    @Override
    public Boolean exists(FoodaBasketOrderDto order) {
        return repository.exists(Example.of(order));
    }

    @Override
    public Boolean exists(Long id) {
        return repository.existsById(id);
    }
}
