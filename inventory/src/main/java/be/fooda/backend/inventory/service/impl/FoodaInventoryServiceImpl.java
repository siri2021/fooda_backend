package be.fooda.backend.inventory.service.impl;

import be.fooda.backend.commons.model.template.inventory.request.FoodaInventoryReq;
import be.fooda.backend.commons.model.template.inventory.response.FoodaInventoryRes;
import be.fooda.backend.commons.service.mapper.FoodaInventoryHttpMapper;
import be.fooda.backend.inventory.dao.FoodaInventoryRepository;
import be.fooda.backend.inventory.service.FoodaInventoryService;
import be.fooda.backend.inventory.service.mapper.FoodaInventoryDtoMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class FoodaInventoryServiceImpl implements FoodaInventoryService<FoodaInventoryReq, FoodaInventoryRes> {
    private final FoodaInventoryRepository inventoryRepository;
    private final FoodaInventoryDtoMapper inventoryDtoMapper;
    private final FoodaInventoryHttpMapper inventoryHttpMapper;

    @Override
    public Optional<FoodaInventoryRes> getInventoryById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<FoodaInventoryRes> getInventoryByExample(FoodaInventoryReq inventoryReq) {
        return Optional.empty();
    }

    @Override
    public List<FoodaInventoryRes> getAllInventories() {
        return null;
    }
}
