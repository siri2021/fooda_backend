package be.fooda.backend.inventory.service.mapper;

import be.fooda.backend.commons.model.template.inventory.request.FoodaInventoryProductReq;
import be.fooda.backend.commons.model.template.inventory.request.FoodaInventoryReq;
import be.fooda.backend.commons.model.template.inventory.response.FoodaInventoryProductRes;
import be.fooda.backend.commons.model.template.inventory.response.FoodaInventoryRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.inventory.model.dto.FoodaInventoryDto;
import org.springframework.stereotype.Component;

@Component
public class FoodaInventoryDtoMapper implements FoodaDtoMapper<FoodaInventoryDto, FoodaInventoryReq, FoodaInventoryRes> {
    @Override
    public FoodaInventoryDto requestToDto(FoodaInventoryReq req) {

        return FoodaInventoryDto.builder()
                .inventoryId(req.getInventoryId())
                .batchCode(req.getBatchCode())
                .productId(req.getProduct().getProductId())
                .storeId(req.getProduct().getStoreId())
                .sku(req.getSku())
                .stockQuantity(req.getStockQuantity())
                .build();
    }



    @Override
    public FoodaInventoryDto responseToDto(FoodaInventoryRes res) {
        return FoodaInventoryDto.builder()
                .stockQuantity(res.getStockQuantity())
                .sku(res.getSku())
                .productId(res.getProduct().getProductId())
                .storeId(res.getProduct().getStoreId())
                .batchCode(res.getBatchCode())
                .inventoryId(res.getInventoryId())
                .build();

    }

    @Override
    public FoodaInventoryReq dtoToRequest(FoodaInventoryDto dto) {
        return FoodaInventoryReq.builder()
                .batchCode(dto.getBatchCode())
                .inventoryId(dto.getInventoryId())
                .product(
                    FoodaInventoryProductReq.builder()
                            .productId(dto.getProductId())
                            .storeId(dto.getStoreId()).build())
                .sku(dto.getSku())
                .stockQuantity(dto.getStockQuantity())
                .build() ;
    }


    @Override
    public FoodaInventoryRes dtoToResponse(FoodaInventoryDto dto) {
        return FoodaInventoryRes.builder()
                .batchCode(dto.getBatchCode())
                .inventoryId(dto.getInventoryId())
                .product(productKeyDtoToRes(dto))
                .sku(dto.getSku())
                .stockQuantity(dto.getStockQuantity())
                .build();
    }

    private FoodaInventoryProductRes productKeyDtoToRes(FoodaInventoryDto dto) {
        return FoodaInventoryProductRes.builder()
                .storeId(dto.getStoreId())
                .productId(dto.getProductId()).build();
    }


}
