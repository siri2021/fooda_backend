package be.fooda.backend.product.service;

import java.io.Serializable;

public interface GenericService<T, I extends Serializable> {
    <S extends T> S save(S entity);
}