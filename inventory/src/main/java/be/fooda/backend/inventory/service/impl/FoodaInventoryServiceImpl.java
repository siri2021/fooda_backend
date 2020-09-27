package be.fooda.backend.inventory.service.impl;

import be.fooda.backend.commons.model.template.inventory.request.FoodaInventoryReq;
import be.fooda.backend.commons.model.template.inventory.response.FoodaInventoryRes;
import be.fooda.backend.commons.service.mapper.FoodaInventoryHttpMapper;
import be.fooda.backend.inventory.dao.FoodaInventoryRepository;
import be.fooda.backend.inventory.service.FoodaInventoryService;
import be.fooda.backend.inventory.service.mapper.FoodaInventoryDtoMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FoodaInventoryServiceImpl implements FoodaInventoryService<FoodaInventoryReq, FoodaInventoryRes> {
    private final FoodaInventoryRepository inventoryRepository;
    private final FoodaInventoryDtoMapper inventoryDtoMapper;
    private final FoodaInventoryHttpMapper inventoryHttpMapper;
}
