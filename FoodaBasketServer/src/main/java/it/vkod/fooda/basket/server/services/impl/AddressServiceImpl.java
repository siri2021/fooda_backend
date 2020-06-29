package it.vkod.fooda.basket.server.services.impl;

import it.vkod.fooda.basket.server.models.Address;
import it.vkod.fooda.basket.server.repositories.AddressRepository;
import it.vkod.fooda.basket.server.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository repository;

    @Override
    public void add(Address address) {
        repository.save(address);
    }

    @Override
    public void add(List<Address> addresses) {
        repository.saveAll(addresses);
    }

    @Override
    public void edit(Address address, BigInteger id) {
        if (repository.existsById(id))
            repository.save(address);
    }

    @Override
    public void delete(BigInteger id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Address address) {
        repository.delete(address);
    }

    @Override
    public Optional<Address> get(BigInteger id) {
        return repository.findById(id);
    }

    @Override
    public Page<Address> get(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Page<Address> get(BigInteger userId, Pageable pageable) {
        return repository.findAllByUserId(userId, pageable);
    }

    @Override
    public Boolean exists(Address address) {
        return repository.exists(Example.of(address));
    }

    @Override
    public Boolean exists(BigInteger id) {
        return repository.existsById(id);
    }
}
