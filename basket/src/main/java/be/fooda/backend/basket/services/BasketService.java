package be.fooda.backend.basket.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface BasketService<T> {

    void add(final T t);

    void add(final List<T> tList);

    void edit(final T t, final BigInteger id);

    void delete(final BigInteger id);

    void delete(final T t);

    Optional<T> get(final BigInteger id);

    Page<T> get(Pageable page);

    Page<T> get(final BigInteger userId, Pageable pageable);

    Boolean exists(final T t);

    Boolean exists(final BigInteger id);
}
