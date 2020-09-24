package be.fooda.backend.product.dao;

import be.fooda.backend.product.model.dto.FoodaProductDto;
import be.fooda.backend.product.model.dto.FoodaProductKeyDto;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodaProductRepository extends CrudRepository<FoodaProductDto, Long> {

    Optional<FoodaProductDto> findByKey(final FoodaProductKeyDto key);

    List<FoodaProductDto> findByName(String name);

}
