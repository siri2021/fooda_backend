package be.fooda.backend.store.service.impl;

import be.fooda.backend.commons.model.template.store.request.FoodaStoreAuthItemReq;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreAuthItemRes;
import be.fooda.backend.store.dao.FoodaStoreAuthRepository;
import be.fooda.backend.store.service.FoodaStoreAuthService;
import be.fooda.backend.store.service.mapper.FoodaStoreAuthDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class FoodaStoreAuthServiceImpl implements FoodaStoreAuthService<FoodaStoreAuthItemReq, FoodaStoreAuthItemRes> {

    @Autowired
    private FoodaStoreAuthRepository authRepo;

    @Autowired
    private FoodaStoreAuthDtoMapper storeAuthDtoMapper;

    @Override
    public Optional<FoodaStoreAuthItemRes> getByAuth(final String key, final String secret, final Long storeId) {
        return authRepo.findByAuth(key, secret, storeId)
                .map(storeAuthDtoMapper::dtoToResponse);

    }
}