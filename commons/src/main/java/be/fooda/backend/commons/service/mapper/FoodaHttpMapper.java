package be.fooda.backend.commons.service.mapper;

public interface FoodaHttpMapper<REQ, RES> {
    REQ responseToRequest(final RES res);

    RES requestToResponse(final REQ req);
}