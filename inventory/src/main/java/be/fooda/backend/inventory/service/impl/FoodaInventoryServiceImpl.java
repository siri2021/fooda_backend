package be.fooda.backend.inventory.service.impl;

import be.fooda.backend.commons.model.template.inventory.request.FoodaInventoryReq;
import be.fooda.backend.commons.model.template.inventory.response.FoodaInventoryRes;
import be.fooda.backend.commons.service.mapper.FoodaInventoryHttpMapper;
import be.fooda.backend.inventory.dao.FoodaInventoryRepository;
import be.fooda.backend.inventory.model.dto.FoodaInventoryDto;
import be.fooda.backend.inventory.service.FoodaInventoryService;
import be.fooda.backend.inventory.service.mapper.FoodaInventoryDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Qualifier("foodaInventoryDtoMapper")
    @Autowired
    private FoodaInventoryDtoMapper inventoryDtoMapper;

    @Autowired
    private FoodaInventoryHttpMapper inventoryHttpMapper;

    @Override
    public Optional<FoodaInventoryRes> getInventoryById(Long inventoryId) {
        return inventoryRepository.findById(inventoryId)
                                  .map(inventoryDtoMapper :: dtoToResponse);
    }

    @Override
    public Optional<FoodaInventoryRes> getInventoryByExample(FoodaInventoryReq inventoryReq) {
        return inventoryRepository.findByExample(inventoryReq)
                                  .map(inventoryDtoMapper:: dtoToResponse) ;
    }

    @Override
    public List<FoodaInventoryRes> getInventoryByProductKey(Long productKeyId) {
        return inventoryRepository.findAllByProductKey_ProductKeyId(productKeyId)
                .stream()
                .map(inventoryDtoMapper :: dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaInventoryRes> getInventoryByProductKey(Long productId, Long storeId) {
        return inventoryRepository.findAllByProductKey_ProductIdAndProductKey_StoreId(productId, storeId)
                .stream()
                .map(inventoryDtoMapper :: dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaInventoryRes> getAllInventories() {
        List<FoodaInventoryDto> results = new ArrayList<>();
        inventoryRepository.findAll().forEach(results :: add);
        return results.stream()
                      .map(inventoryDtoMapper :: dtoToResponse)
                      .collect(Collectors.toList());
    }

    @Override
    public Optional<FoodaInventoryRes> addInventory(FoodaInventoryReq foodaInventoryReq) {
        return Optional.of(inventoryDtoMapper.dtoToResponse(
                inventoryRepository.save(inventoryDtoMapper.requestToDto(foodaInventoryReq))
        ));
    }

    @Override
    public Optional<FoodaInventoryRes> editInventoryById(Long inventoryId, FoodaInventoryReq inventoryREQ) {
        return getInventoryById(inventoryId)
                .map(res -> inventoryHttpMapper
                        .requestToResponse(inventoryREQ)
                        .toBuilder()
                        .inventoryId(inventoryId)
                        .build())
                .map(res -> inventoryDtoMapper.dtoToResponse(
                        inventoryRepository.save(
                                inventoryDtoMapper.responseToDto(res))));
    }

    @Override
    public Optional<FoodaInventoryRes> editInventoryByExample(FoodaInventoryReq inventoryReq) {
        return getInventoryByExample(inventoryReq).map(
                res -> inventoryDtoMapper.dtoToResponse(
                        inventoryRepository.save(inventoryDtoMapper.responseToDto(res))));
    }

    @Override
    public Optional<FoodaInventoryRes> removeInventoryById(Long inventoryId) {
        final Optional<FoodaInventoryRes> foundInventory = getInventoryById(inventoryId);
        foundInventory.ifPresent(res -> inventoryRepository.deleteById(inventoryId));
        final Optional<FoodaInventoryRes> oInventoryAfterDelete = getInventoryById(inventoryId);
        if (oInventoryAfterDelete.isEmpty()) {
            return foundInventory;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<FoodaInventoryRes> removeInventoryByExample(FoodaInventoryReq inventoryReq) {
        final Optional<FoodaInventoryRes> foundInventory = getInventoryByExample(inventoryReq);
        foundInventory.ifPresent(res -> inventoryRepository.delete(inventoryDtoMapper.requestToDto(inventoryReq)));
        final Optional<FoodaInventoryRes> oInventoryAfterDelete = getInventoryByExample(inventoryReq);
        if (oInventoryAfterDelete.isEmpty()) {
            return foundInventory;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Boolean doesInventoryExistById(Long inventoryId) {
        return inventoryRepository.existsById(inventoryId);
    }

    @Override
    public Boolean doesInventoryExistByExample(FoodaInventoryReq inventoryReq) {
        return inventoryRepository.exists(Example.of(inventoryDtoMapper.requestToDto(inventoryReq)));
    }
}
