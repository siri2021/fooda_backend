package be.fooda.backend.basket.service.impl;

import be.fooda.backend.basket.dao.FoodaBasketProductRepository;
import be.fooda.backend.basket.model.dto.FoodaBasketProductDto;
import be.fooda.backend.basket.service.FoodaBasketProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class FoodaBasketProductServiceImpl implements FoodaBasketProductService {

    private final FoodaBasketProductRepository repository;

    @Override
    public void add(FoodaBasketProductDto product) {
        repository.save(product);
    }

    @Override
    public void add(List<FoodaBasketProductDto> products) {
        repository.saveAll(products);
    }

    @Override
    public void edit(FoodaBasketProductDto product, Long id) {
        if (repository.existsById(id))
            repository.save(product);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(FoodaBasketProductDto product) {
        repository.delete(product);
    }

    @Override
    public Optional<FoodaBasketProductDto> get(Long id) {
        return repository.findById(id);
    }

    @Override
    public Page<FoodaBasketProductDto> get(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Page<FoodaBasketProductDto> get(Long userId, Pageable pageable) {
        final List<FoodaBasketProductDto> productList = repository.findByUserId(userId, pageable);
        return new PageImpl<>(productList, pageable, productList.size());
    }

    @Override
    public Boolean exists(FoodaBasketProductDto product) {
        return repository.exists(Example.of(product));
    }

    @Override
    public Boolean exists(Long id) {
        return repository.existsById(id);
    }

    @Override
    public void increase(final FoodaBasketProductDto product) {
        repository.findById(product.getProductId()).ifPresentOrElse(p -> {
            p.increase(product.getQuantity());
            repository.save(p);
        }, () -> repository.save(product));
    }

    @Override
    public void increase(final Long productId, final Long storeId) {
        repository.findById(productId).ifPresentOrElse(p -> {
            p.increase();
            repository.save(p);
        }, () -> log.error("Product does not exist"));
    }

    @Override
    public void decrease(final FoodaBasketProductDto product) {
        repository.findById(product.getProductId()).ifPresentOrElse(p -> {
            p.decrease(product.getQuantity());
            repository.save(p);
        }, () -> repository.save(product));
    }

    @Override
    public void decrease(Long productId, final Long storeId) {
        repository.findById(productId).ifPresentOrElse(p -> {
            p.decrease();
            repository.save(p);
        }, () -> log.error("Product does not exist"));
    }

    @Override
    public void clear(final Long userId, final String sessionId) {
        final List<FoodaBasketProductDto> products = repository.findByUserId(userId, Pageable.unpaged());
        products.forEach(this::delete);
    }
}
