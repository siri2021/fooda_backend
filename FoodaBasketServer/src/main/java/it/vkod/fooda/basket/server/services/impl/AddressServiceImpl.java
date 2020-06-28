package it.vkod.fooda.basket.server.services.impl;

import it.vkod.fooda.basket.server.models.Address;
import it.vkod.fooda.basket.server.repositories.AddressRepository;
import it.vkod.fooda.basket.server.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository repository;

    @Override
    public void add(Address address) {
        repository.save(address);
    }

    @Override
    public void edit(Address address, UUID id) {
        if (repository.existsById(id))
            repository.save(address);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Address address) {
        repository.delete(address);
    }

    @Override
    public Optional<Address> get(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Page<Address> getAll(UUID userId) {
        return repository.findAllByUserId(userId);
    }

    @Override
    public Boolean exists(Address address) {
        return repository.exists(Example.of(address));
    }

    @Override
    public Boolean exists(UUID id) {
        return repository.existsById(id);
    }
}
