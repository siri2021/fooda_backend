package it.vkod.woo.store.service.repositories;

import it.vkod.woo.store.service.payloads.store.request.WooStoreRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepo extends JpaRepository<WooStoreRequest, Long> {

}
