package be.fooda.backend.inventory.dao;

import be.fooda.backend.commons.model.template.inventory.request.FoodaInventoryReq;
import be.fooda.backend.commons.model.template.order.request.FoodaOrderReq;
import be.fooda.backend.inventory.model.dto.FoodaInventoryDto;
import be.fooda.backend.inventory.model.dto.FoodaInventoryProductKeyDto;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodaInventoryRepository extends CrudRepository<FoodaInventoryDto, Long> {

    Optional<FoodaInventoryDto> findByExample(FoodaInventoryReq example);

    List<FoodaInventoryDto> findAllByProductKey_ProductKeyId(final Long productKeyId);

    List<FoodaInventoryDto> findAllByProductKey_ProductIdAndProductKey_StoreId(final Long productId, final Long storeId);

    Boolean exists(Example<FoodaInventoryDto> example);
}
