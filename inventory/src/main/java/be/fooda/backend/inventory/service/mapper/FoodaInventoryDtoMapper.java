package be.fooda.backend.inventory.service.mapper;

import be.fooda.backend.commons.model.template.inventory.request.FoodaInventoryProductReq;
import be.fooda.backend.commons.model.template.inventory.request.FoodaInventoryReq;
import be.fooda.backend.commons.model.template.inventory.response.FoodaInventoryProductRes;
import be.fooda.backend.commons.model.template.inventory.response.FoodaInventoryRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.inventory.model.dto.FoodaInventoryDto;
import be.fooda.backend.inventory.model.dto.FoodaInventoryProductKeyDto;

public class FoodaInventoryDtoMapper implements FoodaDtoMapper<FoodaInventoryDto, FoodaInventoryReq, FoodaInventoryRes> {
    @Override
    public FoodaInventoryDto requestToDto(FoodaInventoryReq foodaInventoryReq) {

        return FoodaInventoryDto.builder()
                .inventoryId(foodaInventoryReq.getInventoryId())
                .batchCode(foodaInventoryReq.getBatchCode())
                .productKey(productKeyReqToDto(foodaInventoryReq))
                .sku(foodaInventoryReq.getSku())
                .stockQuantity(foodaInventoryReq.getStockQuantity())
                .build();
    }

    private FoodaInventoryProductKeyDto productKeyReqToDto(FoodaInventoryReq foodaInventoryReq) {
        return FoodaInventoryProductKeyDto.builder()
                .productId(foodaInventoryReq.getProduct().getProductId())
                .storeId(foodaInventoryReq.getProduct().getStoreId())
                .build();
    }

    @Override
    public FoodaInventoryDto responseToDto(FoodaInventoryRes foodaInventoryRes) {
        return FoodaInventoryDto.builder()
                .stockQuantity(foodaInventoryRes.getStockQuantity())
                .sku(foodaInventoryRes.getSku())
                .productKey(productKeyResToDto(foodaInventoryRes))
                .batchCode(foodaInventoryRes.getBatchCode())
                .inventoryId(foodaInventoryRes.getInventoryId())
                .build();

    }

    private FoodaInventoryProductKeyDto productKeyResToDto(FoodaInventoryRes foodaInventoryRes) {
        return FoodaInventoryProductKeyDto.builder()
                .storeId(foodaInventoryRes.getProduct().getProductId())
                .productId(foodaInventoryRes.getProduct().getStoreId())
                .build();
    }

    @Override
    public FoodaInventoryReq dtoToRequest(FoodaInventoryDto foodaInventoryDto) {
        return FoodaInventoryReq.builder()
                .batchCode(foodaInventoryDto.getBatchCode())
                .inventoryId(foodaInventoryDto.getInventoryId())
                .product(productKeyDtoToReq(foodaInventoryDto))
                .sku(foodaInventoryDto.getSku())
                .stockQuantity(foodaInventoryDto.getStockQuantity())
                .build() ;
    }

    private FoodaInventoryProductReq productKeyDtoToReq(FoodaInventoryDto foodaInventoryDto) {
        return FoodaInventoryProductReq.builder()
                .productId(foodaInventoryDto.getProductKey().getProductId())
                .storeId(foodaInventoryDto.getProductKey().getStoreId())
                .build();
    }

    @Override
    public FoodaInventoryRes dtoToResponse(FoodaInventoryDto foodaInventoryDto) {
        return FoodaInventoryRes.builder()
                .batchCode(foodaInventoryDto.getBatchCode())
                .inventoryId(foodaInventoryDto.getInventoryId())
                .product(productKeyDtoToRes(foodaInventoryDto))
                .sku(foodaInventoryDto.getSku())
                .stockQuantity(foodaInventoryDto.getStockQuantity())
                .build();
    }

    private FoodaInventoryProductRes productKeyDtoToRes(FoodaInventoryDto foodaInventoryDto) {
        return FoodaInventoryProductRes.builder()
                .storeId(foodaInventoryDto.getProductKey().getProductId())
                .productId(foodaInventoryDto.getProductKey().getProductId()).build();
    }


}
