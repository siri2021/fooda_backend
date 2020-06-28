package it.vkod.fooda.basket.server.services.impl;

import it.vkod.fooda.basket.server.models.User;
import it.vkod.fooda.basket.server.repositories.UserRepository;
import it.vkod.fooda.basket.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public void add(User user) {
        repository.save(user);
    }

    @Override
    public void edit(User user, UUID id) {
        if (repository.existsById(id))
            repository.save(user);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }

    @Override
    public Optional<User> get(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Page<User> getAll(UUID userId) {
        return repository.findAllByUserId(userId);
    }

    @Override
    public Boolean exists(User user) {
        return repository.exists(Example.of(user));
    }

    @Override
    public Boolean exists(UUID id) {
        return repository.existsById(id);
    }
}
