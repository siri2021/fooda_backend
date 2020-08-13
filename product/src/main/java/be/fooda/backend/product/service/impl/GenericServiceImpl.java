package be.fooda.backend.product.service.impl;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import be.fooda.backend.product.service.GenericService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GenericServiceImpl<T, I extends Serializable> implements GenericService<T, I> {

    private CrudRepository<T, I> repository;

    @Override
    public <S extends T> S save(S entity) {
        return repository.save(entity);
    }
}