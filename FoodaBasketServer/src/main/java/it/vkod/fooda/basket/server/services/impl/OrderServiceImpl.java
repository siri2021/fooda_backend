package it.vkod.fooda.basket.server.services.impl;

import it.vkod.fooda.basket.server.models.Order;
import it.vkod.fooda.basket.server.repositories.OrderRepository;
import it.vkod.fooda.basket.server.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Override
    public void add(Order order) {
        repository.save(order);
    }

    @Override
    public void add(List<Order> orders) {
        repository.saveAll(orders);
    }

    @Override
    public void edit(Order order, BigInteger id) {
        if (repository.existsById(id))
            repository.save(order);
    }

    @Override
    public void delete(BigInteger id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Order order) {
        repository.delete(order);
    }

    @Override
    public Optional<Order> get(BigInteger id) {
        return repository.findById(id);
    }

    @Override
    public Page<Order> get(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Page<Order> get(BigInteger userId, Pageable pageable) {
        return repository.findAllByUserId(userId, pageable);
    }

    @Override
    public Boolean exists(Order order) {
        return repository.exists(Example.of(order));
    }

    @Override
    public Boolean exists(BigInteger id) {
        return repository.existsById(id);
    }
}
