package be.fooda.backend.store.dao;

import be.fooda.backend.store.model.dto.FoodaStoreDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodaStoreRepository extends CrudRepository<FoodaStoreDto, Long> { }
