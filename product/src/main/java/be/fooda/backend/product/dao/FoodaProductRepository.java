package be.fooda.backend.product.dao;

import be.fooda.backend.product.model.dto.FoodaProductDto;
import be.fooda.backend.product.model.dto.FoodaProductKeyDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodaProductRepository extends JpaRepository<FoodaProductDto, Long> {

    Optional<FoodaProductDto> findByKey(final FoodaProductKeyDto key);

    List<FoodaProductDto> findByName(String name);

}
