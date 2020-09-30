package be.fooda.backend.order.dao;

import be.fooda.backend.order.model.dto.FoodaOrderProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface FoodaOrderProductRepository extends JpaRepository<FoodaOrderProductDto, Long> {

    @Query("SELECT p FROM FoodaOrderProductDto p WHERE p.price >= ?1")
    List<FoodaOrderProductDto> findByPriceMin(final BigDecimal min);

    @Query("SELECT p FROM FoodaOrderProductDto p WHERE p.price >= ?1 AND p.price <= ?2")
    List<FoodaOrderProductDto> findByPriceRange(final BigDecimal min, final BigDecimal max);

}
