package be.fooda.backend.commons.dao.repo;

import be.fooda.backend.commons.model.template.product.dto.FoodaProductDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodaProductRepository extends CrudRepository<FoodaProductDto, Long> {

}
