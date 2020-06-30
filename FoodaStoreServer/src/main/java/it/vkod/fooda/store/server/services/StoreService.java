package it.vkod.fooda.store.server.services;

import it.vkod.fooda.store.server.models.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface StoreService {

    void add(final Store store);

    void add(final List<Store> storeList);

    void edit(final Store store, final BigInteger id);

    void delete(final BigInteger id);

    void delete(final Store store);

    Optional<Store> get(final BigInteger id);

    List<Store> get();

    Page<Store> get(Pageable page);

    Page<Store> get(final BigInteger parentId, Pageable pageable);

    Boolean exists(final Store store);

    Boolean exists(final BigInteger id);
}
