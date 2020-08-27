package be.fooda.backend.commons.dao.repo;

import be.fooda.backend.commons.model.template.matching.dto.FoodaMatchDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodaMatchingRepository extends CrudRepository<FoodaMatchDto, Long> {

}