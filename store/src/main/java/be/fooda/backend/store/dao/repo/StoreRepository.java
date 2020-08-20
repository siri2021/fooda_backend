package be.fooda.backend.store.dao.repo;

import be.fooda.backend.commons.model.template.store.request.FoodaStoreRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends CrudRepository<FoodaStoreRequest, Long> {

}