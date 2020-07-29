package be.fooda.backend.store.repositories;

import be.fooda.backend.store.models.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface StoreRepository extends MongoRepository<Store, BigInteger> {
    Page<Store> findAllByParentId(final BigInteger parentId, Pageable pageable);
}
