package it.vkod.fooda.store.server.services.impl;

import it.vkod.fooda.store.server.models.Store;
import it.vkod.fooda.store.server.repositories.StoreRepository;
import it.vkod.fooda.store.server.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository repository;

    @Override
    public void add(Store store) {
        repository.save(store);
    }

    @Override
    public void add(List<Store> storeList) {
        repository.saveAll(storeList);
    }

    @Override
    public void edit(Store store, BigInteger id) {
        if (repository.existsById(id))
            repository.save(store);
    }

    @Override
    public void delete(BigInteger id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Store store) {
        repository.delete(store);
    }

    @Override
    public Optional<Store> get(BigInteger id) {
        return repository.findById(id);
    }

    @Override
    public List<Store> get() {
        return repository.findAll();
    }

    @Override
    public Page<Store> get(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Page<Store> get(BigInteger parentId, Pageable pageable) {
        return repository.findAllByParentId(parentId, pageable);
    }

    @Override
    public Boolean exists(Store store) {
        return repository.exists(Example.of(store));
    }

    @Override
    public Boolean exists(BigInteger id) {
        return repository.existsById(id);
    }
}
