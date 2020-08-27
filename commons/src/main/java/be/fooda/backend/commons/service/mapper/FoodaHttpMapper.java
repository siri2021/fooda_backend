package be.fooda.backend.commons.service.mapper;

public interface FoodaHttpMapper<REQ, RES> {
    REQ responseToRequest(RES res);

    RES requestToResponse(REQ req);
}