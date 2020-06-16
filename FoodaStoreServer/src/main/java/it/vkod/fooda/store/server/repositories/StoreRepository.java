package it.vkod.fooda.store.server.repositories;

import it.vkod.fooda.store.server.models.store.request.FoodaStore;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends MongoRepository<FoodaStore, Long> {

}
