package be.fooda.backend.store.service.impl;


import be.fooda.backend.commons.model.template.store.request.FoodaStoreReq;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreRes;
import be.fooda.backend.commons.service.mapper.FoodaStoreHttpMapper;
import be.fooda.backend.store.dao.FoodaStoreRepository;
import be.fooda.backend.store.service.FoodaStoreService;
import be.fooda.backend.store.service.mapper.FoodaStoreDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class FoodaStoreServiceImpl implements FoodaStoreService<FoodaStoreReq, FoodaStoreRes> {

	@Autowired
	private FoodaStoreRepository storeRepo;

	@Qualifier("foodaStoreDtoMapper")
	@Autowired
	private FoodaStoreDtoMapper storeDtoMapper;

	@Autowired
	private FoodaStoreHttpMapper storeHttpMapper;

	@Override
	public Optional<FoodaStoreRes> getStoreById(final Long storeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<FoodaStoreRes> getStoreByExample(final FoodaStoreReq example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodaStoreRes> getStoreByName(final String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodaStoreRes> getStoreByAddressId(final Set<Long> idSet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodaStoreRes> getStoreByTypeId(final Long storeTypeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodaStoreRes> getStoreByParentId(final Long storeParentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodaStoreRes> getStoreByAbout(final String about) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<FoodaStoreRes> getStoreByAuth(final String key, final String secret) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodaStoreRes> getStoreByWorkingHours(final LocalDate date, final LocalDateTime opens, final LocalDateTime closes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodaStoreRes> getStoreByWorkingHours(final LocalDateTime opens, final LocalDateTime closes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodaStoreRes> getStoreByDeliveryLocation(final Long municipalityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodaStoreRes> getStoreByDeliveryTime(final Integer timeAsMinutes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodaStoreRes> getStoreByDeliveryCost(final Integer minPrice, final Integer maxPrice, final BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodaStoreRes> getStoreByDeliveryCost(final Integer minPrice, final Integer maxPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodaStoreRes> getStoreByPaymentMethodId(final Long paymentMethodId, final BigDecimal minOrderAmount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodaStoreRes> getStoreByPaymentMethodId(final Long paymentMethodId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<FoodaStoreRes> addStore(final FoodaStoreReq storeReq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<FoodaStoreRes> editStoreById(final Long storeId, final FoodaStoreReq storeReq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<FoodaStoreRes> editStoreByExample(final FoodaStoreReq req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<FoodaStoreRes> removeStoreById(final Long storeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<FoodaStoreRes> removeStoreByExample(final FoodaStoreReq storeReq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodaStoreRes> getAllStores() {
		// TODO Auto-generated method stub
		return null;
	}
    
}