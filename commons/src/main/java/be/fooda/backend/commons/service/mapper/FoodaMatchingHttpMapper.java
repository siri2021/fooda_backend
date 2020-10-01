package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.matching.request.FoodaMatchReq;
import be.fooda.backend.commons.model.template.matching.response.FoodaMatchRes;
import org.springframework.stereotype.Component;

@Component
public class FoodaMatchingHttpMapper implements FoodaHttpMapper<FoodaMatchReq, FoodaMatchRes> {
    @Override
    public FoodaMatchReq responseToRequest(FoodaMatchRes foodaMatchRes) {
        return null;
    }

    @Override
    public FoodaMatchRes requestToResponse(FoodaMatchReq req) {
        return null;
    }
}
