package be.fooda.backend.inventory.service;

import be.fooda.backend.commons.model.template.inventory.response.FoodaInventoryRes;

import java.util.List;
import java.util.Optional;

public interface FoodaInventoryService <REQ, RES>{

    Optional<RES> getInventoryById(final Long inventoryId);

    Optional<RES> getInventoryByExample(final REQ inventoryReq);

    List<RES> getInventoryByProductKey(final Long productKeyId);

    List<RES> getInventoryByProductKey(final Long productId, final Long storeId);

    List<RES> getAllInventories();

    Optional<RES> addInventory(final REQ req);

    Optional<RES> editInventoryById(final Long inventoryId, final REQ inventoryREQ);

    Optional<RES> editInventoryByExample(final REQ inventoryReq);

    Optional<RES> removeInventoryById(final Long inventoryId);

    Optional<RES> removeInventoryByExample(final REQ inventoryReq);

    Boolean doesInventoryExistById(final Long inventoryId);

    Boolean doesInventoryExistByExample(final REQ inventoryReq);




}
