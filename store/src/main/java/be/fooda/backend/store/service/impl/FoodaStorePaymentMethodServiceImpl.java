package be.fooda.backend.store.service.impl;

import be.fooda.backend.commons.model.template.store.request.FoodaStorePaymentMethodsItemReq;
import be.fooda.backend.commons.model.template.store.request.FoodaStoreReq;
import be.fooda.backend.commons.model.template.store.response.FoodaStorePaymentMethodsItemRes;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.store.dao.FoodaStorePaymentMethodRepository;
import be.fooda.backend.store.model.dto.FoodaStoreDto;
import be.fooda.backend.store.service.FoodaStorePaymentMethodService;
import be.fooda.backend.store.service.mapper.FoodaStorePaymentMethodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodaStorePaymentMethodServiceImpl implements FoodaStorePaymentMethodService<FoodaStorePaymentMethodsItemReq, FoodaStorePaymentMethodsItemRes> {

    @Autowired
    private FoodaStorePaymentMethodsMapper  storePaymentMethodMapper;

    @Autowired
    private FoodaStorePaymentMethodRepository paymentRepo;

    @Override
    public List<FoodaStorePaymentMethodsItemRes> getStoreByPaymentMethodId(Long paymentMethodId, BigDecimal minOrderAmount) {
        return paymentRepo.findByPaymentMethodId(paymentMethodId, minOrderAmount)
                .stream()
                .map(storePaymentMethodMapper::dtoToResponse).collect(Collectors.toList());
    }

    @Override
    public List<FoodaStorePaymentMethodsItemRes> getStoreByPaymentMethodId(Long paymentMethodId) {
        return paymentRepo.findByPaymentMethodId(paymentMethodId)
                .stream()
                .map(storePaymentMethodMapper::dtoToResponse).collect(Collectors.toList());
    }
}
