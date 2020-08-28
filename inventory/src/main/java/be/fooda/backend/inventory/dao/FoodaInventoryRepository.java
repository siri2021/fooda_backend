package be.fooda.backend.inventory.dao;

import be.fooda.backend.inventory.model.dto.FoodaInventoryDto;
import be.fooda.backend.inventory.model.dto.FoodaInventoryProductKeyDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodaInventoryRepository extends CrudRepository<FoodaInventoryDto, Long> {
    List<FoodaInventoryDto> findAllByProductKey(final FoodaInventoryProductKeyDto productKey);
}
