package be.fooda.backend.basket.service.impl;

import be.fooda.backend.basket.dao.FoodaBasketAddressRepository;
import be.fooda.backend.basket.model.dto.FoodaBasketAddressDto;
import be.fooda.backend.basket.service.FoodaBasketAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodaBasketAddressServiceImpl implements FoodaBasketAddressService {

    private final FoodaBasketAddressRepository repository;

    @Override
    public void add(FoodaBasketAddressDto address) {
        repository.save(address);
    }

    @Override
    public void add(List<FoodaBasketAddressDto> addresses) {
        repository.saveAll(addresses);
    }

    @Override
    public void edit(FoodaBasketAddressDto address, Long id) {
        if (repository.existsById(id))
            repository.save(address);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(FoodaBasketAddressDto address) {
        repository.delete(address);
    }

    @Override
    public Optional<FoodaBasketAddressDto> get(Long id) {
        return repository.findById(id);
    }

    @Override
    public Page<FoodaBasketAddressDto> get(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Page<FoodaBasketAddressDto> get(Long userId, Pageable pageable) {
        return repository.findAllByUserId(userId, pageable);
    }

    @Override
    public Boolean exists(FoodaBasketAddressDto address) {
        return repository.exists(Example.of(address));
    }

    @Override
    public Boolean exists(Long id) {
        return repository.existsById(id);
    }
}
