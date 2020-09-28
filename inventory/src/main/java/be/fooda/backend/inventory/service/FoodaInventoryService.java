package be.fooda.backend.inventory.service;

import java.util.List;
import java.util.Optional;

public interface FoodaInventoryService <REQ, RES>{

    Optional<RES> getInventoryById(final Long id);

    Optional<RES> getInventoryByExample(final REQ inventoryReq);

    List<RES> getAllInventories();


}
