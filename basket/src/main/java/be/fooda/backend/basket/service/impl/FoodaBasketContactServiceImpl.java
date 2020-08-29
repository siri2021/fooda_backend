package be.fooda.backend.basket.service.impl;

import be.fooda.backend.basket.dao.FoodaBasketContactRepository;
import be.fooda.backend.basket.model.dto.FoodaBasketContactDto;
import be.fooda.backend.basket.service.FoodaBasketContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodaBasketContactServiceImpl implements FoodaBasketContactService {

    @Autowired
    private FoodaBasketContactRepository repository;

    @Override
    public void add(FoodaBasketContactDto contact) {
        repository.save(contact);
    }

    @Override
    public void add(List<FoodaBasketContactDto> contacts) {
        repository.saveAll(contacts);
    }

    @Override
    public void edit(FoodaBasketContactDto contact, Long id) {
        if (repository.existsById(id))
            repository.save(contact);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(FoodaBasketContactDto contact) {
        repository.delete(contact);
    }

    @Override
    public Optional<FoodaBasketContactDto> get(Long id) {
        return repository.findById(id);
    }

    @Override
    public Page<FoodaBasketContactDto> get(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Page<FoodaBasketContactDto> get(Long userId, Pageable pageable) {
        return repository.findAllByUserId(userId, pageable);
    }

    @Override
    public Boolean exists(FoodaBasketContactDto contact) {
        return repository.exists(Example.of(contact));
    }

    @Override
    public Boolean exists(Long id) {
        return repository.existsById(id);
    }
}
