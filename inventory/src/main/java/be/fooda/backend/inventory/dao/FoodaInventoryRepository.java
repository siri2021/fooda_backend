package be.fooda.backend.inventory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.fooda.backend.inventory.model.dto.FoodaInventoryDto;

import java.util.List;

@Repository
public interface FoodaInventoryRepository extends JpaRepository<FoodaInventoryDto, Long> {

    List<FoodaInventoryDto> findByStore(final Long productKeyId);

    List<FoodaInventoryDto> findByStoreAndProduct(final Long productId, final Long storeId);

    List<FoodaInventoryDto> findBySku(final String sku);
    
}
