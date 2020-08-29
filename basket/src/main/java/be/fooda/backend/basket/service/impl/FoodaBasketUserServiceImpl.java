package be.fooda.backend.basket.service.impl;

import be.fooda.backend.basket.dao.FoodaBasketUserRepository;
import be.fooda.backend.basket.model.dto.FoodaBasketUserDto;
import be.fooda.backend.basket.service.FoodaBasketUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class FoodaBasketUserServiceImpl implements FoodaBasketUserService {

    private final FoodaBasketUserRepository repository;

    @Override
    public void add(FoodaBasketUserDto user) {
        user.setLogin(user.getLogin().toLowerCase());
        repository.save(user);
    }

    @Override
    public void add(List<FoodaBasketUserDto> users) {
        repository.saveAll(users);
    }

    @Override
    public void edit(FoodaBasketUserDto user, Long id) {
        if (repository.existsById(id)) {
            user.setLogin(user.getLogin().toLowerCase());
            repository.save(user);
        }
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(FoodaBasketUserDto user) {
        repository.delete(user);
    }

    @Override
    public Optional<FoodaBasketUserDto> get(Long id) {
        return repository.findById(id);
    }

    @Override
    public Page<FoodaBasketUserDto> get(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Page<FoodaBasketUserDto> get(Long userId, Pageable pageable) {
        final FoodaBasketUserDto list = repository.findById(userId).orElse(null);
        return new PageImpl<>(Collections.singletonList(list), pageable, 1);
    }

    @Override
    public Boolean exists(FoodaBasketUserDto user) {
        return repository.exists(Example.of(user));
    }

    @Override
    public Boolean exists(Long id) {
        return repository.existsById(id);
    }

    @Override
    public Boolean exists(String username) {
        return repository.existsByLogin(username.toLowerCase());
    }

    @Override
    public Optional<FoodaBasketUserDto> login(String username, String password) {
        final Optional<FoodaBasketUserDto> optionalUser = repository.findByLogin(username);
        return optionalUser.isPresent() && optionalUser.get().getPassword().equalsIgnoreCase(password) ? optionalUser : Optional.empty();
    }

    @Override
    public void logout(Long userId) {
        repository.findById(userId).ifPresentOrElse(user -> repository.save(user),
                () -> log.error("Logout failed, User already logged out or it does not exists"));
    }
}
