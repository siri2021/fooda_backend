package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.inventory.request.FoodaInventoryReq;
import be.fooda.backend.commons.model.template.inventory.response.FoodaInventoryRes;

public class FoodaInventoryHttpMapper implements FoodaHttpMapper<FoodaInventoryReq, FoodaInventoryRes> {
    @Override
    public FoodaInventoryReq responseToRequest(FoodaInventoryRes foodaInventoryRes) {
        return null;
    }

    @Override
    public FoodaInventoryRes requestToResponse(FoodaInventoryReq foodaInventoryReq) {
        return null;
    }
}
