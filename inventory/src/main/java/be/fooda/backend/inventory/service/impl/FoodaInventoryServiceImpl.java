package be.fooda.backend.inventory.service.impl;

import be.fooda.backend.commons.model.template.inventory.request.FoodaInventoryReq;
import be.fooda.backend.commons.model.template.inventory.response.FoodaInventoryRes;
import be.fooda.backend.commons.service.mapper.FoodaInventoryHttpMapper;
import be.fooda.backend.inventory.dao.FoodaInventoryRepository;
import be.fooda.backend.inventory.model.dto.FoodaInventoryDto;
import be.fooda.backend.inventory.service.FoodaInventoryService;
import be.fooda.backend.inventory.service.mapper.FoodaInventoryDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodaInventoryServiceImpl implements FoodaInventoryService<FoodaInventoryReq, FoodaInventoryRes> {

    @Autowired
    private FoodaInventoryRepository inventoryRepository;

    @Autowired
    private FoodaInventoryDtoMapper inventoryDtoMapper;

    @Autowired
    private FoodaInventoryHttpMapper inventoryHttpMapper;

    @Override
    public Optional<FoodaInventoryRes> getById(Long inventoryId) {
        return inventoryRepository.findById(inventoryId)
                                  .map(inventoryDtoMapper::dtoToResponse);
    }

    @Override
    public Optional<FoodaInventoryRes> getByExample(FoodaInventoryReq req) {
        return inventoryRepository.findOne(Example.of(inventoryDtoMapper.requestToDto(req)))
                                  .map(inventoryDtoMapper:: dtoToResponse) ;
    }

    @Override
    public List<FoodaInventoryRes> getByStoreId(Long productKeyId) {
        return inventoryRepository.findAllByProductKey_ProductKeyId(productKeyId)
                .stream()
                .map(inventoryDtoMapper :: dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaInventoryRes> getByProductKeyAndStore(Long productId, Long storeId) {
        return inventoryRepository.findAllByProductKey_ProductIdAndProductKey_StoreId(productId, storeId)
                .stream()
                .map(inventoryDtoMapper :: dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaInventoryRes> getAll() {
        List<FoodaInventoryDto> results = new ArrayList<>();
        inventoryRepository.findAll().forEach(results :: add);
        return results.stream()
                      .map(inventoryDtoMapper :: dtoToResponse)
                      .collect(Collectors.toList());
    }

    @Override
    public Optional<FoodaInventoryRes> add(FoodaInventoryReq req) {
        return Optional.of(inventoryDtoMapper.dtoToResponse(
                inventoryRepository.save(inventoryDtoMapper.requestToDto(req))
        ));
    }

    @Override
    public Optional<FoodaInventoryRes> editById(Long inventoryId, FoodaInventoryReq req) {
        return getById(inventoryId)
                .map(res -> inventoryHttpMapper
                        .requestToResponse(req)
                        .toBuilder()
                        .inventoryId(inventoryId)
                        .build())
                .map(res -> inventoryDtoMapper.dtoToResponse(
                        inventoryRepository.save(
                                inventoryDtoMapper.responseToDto(res))));
    }

    @Override
    public Optional<FoodaInventoryRes> editByExample(FoodaInventoryReq req) {
        return getByExample(req).map(
                res -> inventoryDtoMapper.dtoToResponse(
                        inventoryRepository.save(inventoryDtoMapper.responseToDto(res))));
    }

    @Override
    public Optional<FoodaInventoryRes> removeById(Long inventoryId) {
        final Optional<FoodaInventoryRes> foundInventory = getById(inventoryId);
        foundInventory.ifPresent(res -> inventoryRepository.deleteById(inventoryId));
        final Optional<FoodaInventoryRes> oInventoryAfterDelete = getById(inventoryId);
        if (oInventoryAfterDelete.isEmpty()) {
            return foundInventory;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<FoodaInventoryRes> removeByExample(FoodaInventoryReq req) {
        final Optional<FoodaInventoryRes> foundInventory = getByExample(req);
        foundInventory.ifPresent(res -> inventoryRepository.delete(inventoryDtoMapper.requestToDto(req)));
        final Optional<FoodaInventoryRes> oInventoryAfterDelete = getByExample(req);
        if (oInventoryAfterDelete.isEmpty()) {
            return foundInventory;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Boolean existsById(Long inventoryId) {
        return inventoryRepository.existsById(inventoryId);
    }

    @Override
    public Boolean existsByExample(FoodaInventoryReq req) {
        return inventoryRepository.exists(Example.of(inventoryDtoMapper.requestToDto(req)));
    }
}
