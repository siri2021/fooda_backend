package it.vkod.fooda.basket.server.services.impl;

import it.vkod.fooda.basket.server.models.Product;
import it.vkod.fooda.basket.server.repositories.ProductRepository;
import it.vkod.fooda.basket.server.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public void add(Product product) {
        repository.save(product);
    }

    @Override
    public void edit(Product product, UUID id) {
        if (repository.existsById(id))
            repository.save(product);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Product product) {
        repository.delete(product);
    }

    @Override
    public Optional<Product> get(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Page<Product> getAll(UUID userId) {
        return repository.findAllByUserId(userId);
    }

    @Override
    public Boolean exists(Product product) {
        return repository.exists(Example.of(product));
    }

    @Override
    public Boolean exists(UUID id) {
        return repository.existsById(id);
    }
}
