package it.vkod.woo.store.db.repositories;

import it.vkod.woo.store.db.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long>, JpaSpecificationExecutor<Store> {

    public Store findByNameAndCkAndCs(String name, String ck, String cs);
}
