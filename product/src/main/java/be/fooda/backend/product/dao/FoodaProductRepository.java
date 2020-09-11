package be.fooda.backend.product.dao;

import be.fooda.backend.product.model.dto.FoodaProductDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodaProductRepository extends CrudRepository<FoodaProductDto, Long> {

}
