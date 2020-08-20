package be.fooda.backend.commons.dao.repo;

import be.fooda.backend.commons.model.template.store.dto.FoodaStoreDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodaStoreRepository extends CrudRepository<FoodaStoreDto, Long> { }
