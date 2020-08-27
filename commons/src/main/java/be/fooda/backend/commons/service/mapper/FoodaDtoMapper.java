package be.fooda.backend.commons.service.mapper;

public interface FoodaDtoMapper<DTO, REQ, RES> {
    DTO requestToDto(REQ req);

    DTO responseToDto(RES res);

    REQ dtoToRequest(DTO dto);

    RES dtoToResponse(DTO dto);
}