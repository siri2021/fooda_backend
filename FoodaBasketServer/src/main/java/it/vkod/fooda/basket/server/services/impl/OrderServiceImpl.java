package it.vkod.fooda.basket.server.services.impl;

import it.vkod.fooda.basket.server.models.Order;
import it.vkod.fooda.basket.server.repositories.OrderRepository;
import it.vkod.fooda.basket.server.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Override
    public void add(Order order) {
        repository.save(order);
    }

    @Override
    public void edit(Order order, UUID id) {
        if (repository.existsById(id))
            repository.save(order);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Order order) {
        repository.delete(order);
    }

    @Override
    public Optional<Order> get(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Page<Order> getAll(UUID userId) {
        return repository.findAllByUserId(userId);
    }

    @Override
    public Boolean exists(Order order) {
        return repository.exists(Example.of(order));
    }

    @Override
    public Boolean exists(UUID id) {
        return repository.existsById(id);
    }
}
