package be.fooda.backend.inventory.service;

import java.util.List;
import java.util.Optional;

public interface FoodaInventoryService <REQ, RES>{

    Optional<RES> getById(final Long inventoryId);

    Optional<RES> getByExample(final REQ req);

    List<RES> getByProductKeyAndStore(final Long productId, final Long storeId);

    List<RES> getAll();

    Optional<RES> add(final REQ req);

    Optional<RES> editById(final Long inventoryId, final REQ req);

    Optional<RES> editByExample(final REQ req);

    Optional<RES> removeById(final Long inventoryId);

    Optional<RES> removeByExample(final REQ req);

    Boolean existsById(final Long inventoryId);

    Boolean existsByExample(final REQ req);

}
