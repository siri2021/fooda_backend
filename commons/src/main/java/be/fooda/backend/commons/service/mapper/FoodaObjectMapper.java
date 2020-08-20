package be.fooda.backend.commons.service.mapper;

public interface FoodaObjectMapper<DTO, REQ, RES> {
    REQ dtoToRequest(DTO dto);
    REQ responseToRequest(RES res);
    RES dtoToResponse(DTO dto);
    RES requestToResponse(REQ req);
    DTO requestToDto(REQ req);
    DTO responseToDto(RES res);
}