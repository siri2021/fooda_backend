package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.user.request.FoodaUserReq;
import be.fooda.backend.commons.model.template.user.response.FoodaUserRes;
import org.springframework.stereotype.Component;

@Component
public class FoodaUserHttpMapper implements FoodaHttpMapper<FoodaUserReq, FoodaUserRes> {

    @Override
    public FoodaUserReq responseToRequest(FoodaUserRes res) {

        return FoodaUserReq.builder()
                .login(res.getLogin())
                .build();
    }

    @Override
    public FoodaUserRes requestToResponse(FoodaUserReq req) {

        return FoodaUserRes.builder()
                .login(req.getLogin())
                .build();
    }
}