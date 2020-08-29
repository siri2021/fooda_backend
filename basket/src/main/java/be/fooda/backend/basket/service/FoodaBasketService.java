package be.fooda.backend.basket.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface FoodaBasketService<T> {

    void add(final T t);

    void add(final List<T> tList);

    void edit(final T t, final Long id);

    void delete(final Long id);

    void delete(final T t);

    Optional<T> get(final Long id);

    Page<T> get(Pageable page);

    Page<T> get(final Long userId, Pageable pageable);

    Boolean exists(final T t);

    Boolean exists(final Long id);
}
