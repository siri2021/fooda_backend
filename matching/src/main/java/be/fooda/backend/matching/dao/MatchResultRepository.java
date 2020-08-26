package be.fooda.backend.matching.dao;

import be.fooda.backend.commons.model.template.matching.dto.FoodaMatchDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchResultRepository extends CrudRepository<FoodaMatchDto, Long> {

}