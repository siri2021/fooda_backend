package be.fooda.backend.store.service.impl;

import be.fooda.backend.commons.model.template.store.request.FoodaStoreAuthItemReq;
import be.fooda.backend.commons.model.template.store.request.FoodaStoreReq;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreAuthItemRes;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.store.dao.FoodaAuthRepository;
import be.fooda.backend.store.model.dto.FoodaStoreDto;
import be.fooda.backend.store.service.FoodaStoreAuthService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FoodaStoreAuthServiceImpl implements FoodaStoreAuthService<FoodaStoreAuthItemReq, FoodaStoreAuthItemRes> {
    private FoodaAuthRepository authRepo;
    private FoodaDtoMapper<FoodaStoreDto, FoodaStoreReq, FoodaStoreRes> storeDtoMapper;



    @Override
    public Optional<FoodaStoreAuthItemResRes> getByAuth(final String key, final String secret, final Long storeId) {


        return authRepo.findByAuth(key, secret, storeId)
                .map(storeDtoMapper::dtoToResponse);

    }