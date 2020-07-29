package be.fooda.backend.basket.services.impl;

import be.fooda.backend.basket.models.Product;
import be.fooda.backend.basket.repositories.ProductRepository;
import be.fooda.backend.basket.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public void add(Product product) {
        repository.save(product);
    }

    @Override
    public void add(List<Product> products) {
        repository.saveAll(products);
    }

    @Override
    public void edit(Product product, BigInteger id) {
        if (repository.existsById(id))
            repository.save(product);
    }

    @Override
    public void delete(BigInteger id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Product product) {
        repository.delete(product);
    }

    @Override
    public Optional<Product> get(BigInteger id) {
        return repository.findById(id);
    }

    @Override
    public Page<Product> get(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Page<Product> get(BigInteger userId, Pageable pageable) {
        final List<Product> productList = repository.findByUserId(userId, pageable);
        return new PageImpl<>(productList, pageable, productList.size());
    }

    @Override
    public Boolean exists(Product product) {
        return repository.exists(Example.of(product));
    }

    @Override
    public Boolean exists(BigInteger id) {
        return repository.existsById(id);
    }

    @Override
    public void increase(Product product) {
        repository.findById(product.getProductId()).ifPresentOrElse(p -> {
            p.increase(product.getQuantity());
            repository.save(p);
        }, () -> repository.save(product));
    }

    @Override
    public void increase(BigInteger productId) {
        repository.findById(productId).ifPresentOrElse(p -> {
            p.increase();
            repository.save(p);
        }, () -> log.error("Product does not exist"));
    }

    @Override
    public void decrease(Product product) {
        repository.findById(product.getProductId()).ifPresentOrElse(p -> {
            p.decrease(product.getQuantity());
            repository.save(p);
        }, () -> repository.save(product));
    }

    @Override
    public void decrease(BigInteger productId) {
        repository.findById(productId).ifPresentOrElse(p -> {
            p.decrease();
            repository.save(p);
        }, () -> log.error("Product does not exist"));
    }

    @Override
    public void clear(BigInteger userId, String sessionId) {
        final List<Product> products = repository.findByUserId(userId, Pageable.unpaged());
        products.forEach(this::delete);
    }
}
