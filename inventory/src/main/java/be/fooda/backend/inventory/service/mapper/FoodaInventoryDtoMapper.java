package be.fooda.backend.inventory.service.mapper;

import be.fooda.backend.commons.model.template.inventory.request.FoodaInventoryReq;
import be.fooda.backend.commons.model.template.inventory.response.FoodaInventoryRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.inventory.model.dto.FoodaInventoryDto;

public class FoodaInventoryDtoMapper implements FoodaDtoMapper<FoodaInventoryDto, FoodaInventoryReq, FoodaInventoryRes> {
    @Override
    public FoodaInventoryDto requestToDto(FoodaInventoryReq foodaInventoryReq) {
        return null;
    }

    @Override
    public FoodaInventoryDto responseToDto(FoodaInventoryRes foodaInventoryRes) {
        return null;
    }

    @Override
    public FoodaInventoryReq dtoToRequest(FoodaInventoryDto foodaInventoryDto) {
        return null;
    }

    @Override
    public FoodaInventoryRes dtoToResponse(FoodaInventoryDto foodaInventoryDto) {
        return null;
    }
}
