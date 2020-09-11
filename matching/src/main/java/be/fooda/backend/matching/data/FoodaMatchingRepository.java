package be.fooda.backend.matching.data;

import be.fooda.backend.matching.model.dto.FoodaMatchDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodaMatchingRepository extends CrudRepository<FoodaMatchDto, Long> {

}