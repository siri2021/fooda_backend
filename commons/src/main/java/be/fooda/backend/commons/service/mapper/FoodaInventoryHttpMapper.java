
package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.inventory.request.FoodaInventoryProductReq;
import be.fooda.backend.commons.model.template.inventory.request.FoodaInventoryReq;
import be.fooda.backend.commons.model.template.inventory.response.FoodaInventoryProductRes;
import be.fooda.backend.commons.model.template.inventory.response.FoodaInventoryRes;
import org.springframework.stereotype.Component;

@Component
public class FoodaInventoryHttpMapper implements FoodaHttpMapper<FoodaInventoryReq, FoodaInventoryRes> {
    @Override
    public FoodaInventoryReq responseToRequest(FoodaInventoryRes foodaInventoryRes) {
        return FoodaInventoryReq.builder()
                .stockQuantity(foodaInventoryRes.getStockQuantity())
                .sku(foodaInventoryRes.getSku())
                .product(productResToReq(foodaInventoryRes))
                .inventoryId(foodaInventoryRes.getInventoryId())
                .batchCode(foodaInventoryRes.getBatchCode())
                .build();
    }

    private FoodaInventoryProductReq productResToReq(FoodaInventoryRes foodaInventoryRes) {
        return FoodaInventoryProductReq.builder()
                .storeId(foodaInventoryRes.getProduct().getStoreId())
                .productId(foodaInventoryRes.getProduct().getProductId())
                .logo(foodaInventoryRes.getProduct().getLogo())
                .name(foodaInventoryRes.getProduct().getName())
                .build();
    }

    @Override
    public FoodaInventoryRes requestToResponse(FoodaInventoryReq foodaInventoryReq) {
        return FoodaInventoryRes.builder()
                .stockQuantity(foodaInventoryReq.getStockQuantity())
                .sku(foodaInventoryReq.getSku())
                .product(productReqToRes(foodaInventoryReq))
                .inventoryId(foodaInventoryReq.getInventoryId())
                .batchCode(foodaInventoryReq.getBatchCode())
                .build();
    }

    private FoodaInventoryProductRes productReqToRes(FoodaInventoryReq foodaInventoryReq) {
        return FoodaInventoryProductRes.builder()
                .productId(foodaInventoryReq.getProduct().getProductId())
                .storeId(foodaInventoryReq.getProduct().getStoreId())
                .logo(foodaInventoryReq.getProduct().getLogo())
                .name(foodaInventoryReq.getProduct().getName()).build();
    }
}


