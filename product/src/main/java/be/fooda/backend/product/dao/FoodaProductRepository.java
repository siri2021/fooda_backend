package be.fooda.backend.product.dao;

import be.fooda.backend.product.model.dto.FoodaProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface FoodaProductRepository extends JpaRepository<FoodaProductDto, Long> {

    @Query("SELECT p FROM FoodaProductDto p WHERE p.name=?1")
    List<FoodaProductDto> findByName(final String name);

    @Query("SELECT p FROM FoodaProductDto p WHERE p.description=?1")
    List<FoodaProductDto> findByDescription(final String description);

    List<FoodaProductDto> findByFeatured();

    @Query("SELECT p FROM FoodaProductDto p WHERE p.price IN (SELECT p FROM FoodaProductPriceDto p WHERE p.amount >= ?1 AND p.amount <= ?2)")
    List<FoodaProductDto> findByPrice(final BigDecimal minPrice, final BigDecimal maxPrice);

    @Query("SELECT p FROM FoodaProductDto p WHERE p.price IN (SELECT p FROM FoodaProductPriceDto p WHERE p.productPriceId >= ?1 AND p.expiry <= ?2)")
    List<FoodaProductDto> findByPriceIdAndExpiryDate(final Long productPriceId, final LocalDate expiryDate);

    @Query("SELECT p FROM FoodaProductDto p WHERE p.categories IN :categories")
    List<FoodaProductDto> findByCategories(final Collection<Long> categories);
    
    @Query("SELECT p FROM FoodaProductDto p WHERE p.tags IN :tags")
    List<FoodaProductDto> findByTags(final Collection<String> tags);
    
    @Query("DELETE FROM FoodaProductDto p WHERE p.productId = ?1 AND p.storeId = ?2")
    void deleteById(final Long externalProductId, final Long storeId);

}
