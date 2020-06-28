package it.vkod.fooda.basket.server.services.impl;

import it.vkod.fooda.basket.server.models.Contact;
import it.vkod.fooda.basket.server.repositories.ContactRepository;
import it.vkod.fooda.basket.server.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository repository;

    @Override
    public void add(Contact contact) {
        repository.save(contact);
    }

    @Override
    public void edit(Contact contact, UUID id) {
        if (repository.existsById(id))
            repository.save(contact);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Contact contact) {
        repository.delete(contact);
    }

    @Override
    public Optional<Contact> get(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Page<Contact> getAll(UUID userId) {
        return repository.findAllByUserId(userId);
    }

    @Override
    public Boolean exists(Contact contact) {
        return repository.exists(Example.of(contact));
    }

    @Override
    public Boolean exists(UUID id) {
        return repository.existsById(id);
    }
}
