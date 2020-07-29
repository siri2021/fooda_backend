package be.fooda.backend.basket.services.impl;

import be.fooda.backend.basket.models.Contact;
import be.fooda.backend.basket.repositories.ContactRepository;
import be.fooda.backend.basket.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository repository;

    @Override
    public void add(Contact contact) {
        repository.save(contact);
    }

    @Override
    public void add(List<Contact> contacts) {
        repository.saveAll(contacts);
    }

    @Override
    public void edit(Contact contact, BigInteger id) {
        if (repository.existsById(id))
            repository.save(contact);
    }

    @Override
    public void delete(BigInteger id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Contact contact) {
        repository.delete(contact);
    }

    @Override
    public Optional<Contact> get(BigInteger id) {
        return repository.findById(id);
    }

    @Override
    public Page<Contact> get(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Page<Contact> get(BigInteger userId, Pageable pageable) {
        return repository.findAllByUserId(userId, pageable);
    }

    @Override
    public Boolean exists(Contact contact) {
        return repository.exists(Example.of(contact));
    }

    @Override
    public Boolean exists(BigInteger id) {
        return repository.existsById(id);
    }
}
