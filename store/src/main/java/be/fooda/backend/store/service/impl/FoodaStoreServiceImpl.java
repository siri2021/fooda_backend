package be.fooda.backend.store.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import be.fooda.backend.commons.model.template.basket.response.FoodaBasketOrderRes;
import be.fooda.backend.commons.model.template.store.request.FoodaStorePaymentMethodsItemReq;
import be.fooda.backend.commons.model.template.store.request.FoodaStoreReq;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreDeliveryCostsItemRes;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreRes;
import be.fooda.backend.commons.service.mapper.FoodaStoreHttpMapper;
import be.fooda.backend.store.dao.FoodaStoreRepository;
import be.fooda.backend.store.model.dto.*;
import be.fooda.backend.store.service.FoodaStoreService;
import be.fooda.backend.store.service.mapper.FoodaStoreDtoMapper;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;


@RequiredArgsConstructor
public class FoodaStoreServiceImpl implements FoodaStoreService<FoodaStoreReq, FoodaStoreRes> {
	@Autowired
	private final FoodaStoreRepository storeRepo;
	@Autowired
	private final FoodaStoreDtoMapper storeDtoMapper;
	@Autowired
	private final FoodaStoreHttpMapper storeHttpMapper;

	@Override
	public Optional<FoodaStoreRes> getStoreById(final Long storeId) {
		return storeRepo.findById(storeId)
				.map(storeDtoMapper::dtoToResponse);
	}

	@Override
	public Optional<FoodaStoreRes> getStoreByExample(final FoodaStoreReq example) {

		return storeRepo
				.findOne(Example.of(storeDtoMapper.requestToDto(example)))
						.map(storeDtoMapper::dtoToResponse);
	}

	@Override
	public List<FoodaStoreRes> getStoreByName(final String name) {
		return storeRepo.findAllByName(name)
				.stream()
				.map(storeDtoMapper::dtoToResponse)
				.collect(Collectors.toList());

	}

	@Override
	public List<FoodaStoreRes> getStoreByAddressId(final Set<Long> idSet) {
		return storeRepo.findByAddressId(idSet)
				.stream()
				.map(storeDtoMapper::dtoToResponse)
				.collect(Collectors.toList());


	}


	@Override
	public List<FoodaStoreRes> getStoreByTypeId(final Long storeTypeId) {
		return storeRepo.findByTypeId(storeTypeId).stream()
				.map(storeDtoMapper::dtoToResponse)
				.collect(Collectors.toList());
	}

	@Override
	public List<FoodaStoreRes> getStoreByParentId(final Long storeParentId) {
		return storeRepo.findByParentId(storeParentId)
				.stream()
				.map(storeDtoMapper::dtoToResponse)
				.collect(Collectors.toList());

	}

	@Override
	public List<FoodaStoreRes> getStoreByAbout(final String about) {
		return storeRepo.findByAbout(about)
				.stream()
				.map(storeDtoMapper::dtoToResponse).collect(Collectors.toList());

	}

	@Override
	public Optional<FoodaStoreRes> getStoreByAuth(final String key, final String secret) {
		return storeRepo.findByAuth(key,secret)
				.map(storeDtoMapper::dtoToResponse);

	}

	@Override
	public List<FoodaStoreRes> getStoreByWorkingHours(final LocalDate date, final LocalDateTime opens, final LocalDateTime closes) {
		return storeRepo.findByWorkingHours(date,opens,closes)
				.stream()
				.map(storeDtoMapper::dtoToResponse).collect(Collectors.toList());
	}

	@Override
	public List<FoodaStoreRes> getStoreByWorkingHours(final LocalDateTime opens, final LocalDateTime closes) {
		return storeRepo.findByWorkingHours(opens,closes)
				.stream()
				.map(storeDtoMapper::dtoToResponse).collect(Collectors.toList());
	}
	@Override
	public List<FoodaStoreRes> getStoreByDeliveryLocation(final Long municipalityId) {
		return storeRepo.findByDeliveryLocation(municipalityId)
				.stream()
				.map(storeDtoMapper::dtoToResponse)
				.collect(Collectors.toList())
				;
	}

	@Override
	public List<FoodaStoreRes> getStoreByDeliveryTime(Integer timeAsMinutes) {
		return storeRepo.findByDeliveryTime(timeAsMinutes)
				.stream()
				.map(storeDtoMapper::dtoToResponse).collect(Collectors.toList())
				;
	}



	@Override
	public List<FoodaStoreRes> getStoreByDeliveryCost(final BigDecimal minPrice, final BigDecimal maxPrice, final BigDecimal amount) {
		return storeRepo.findByDeliveryCost(minPrice, maxPrice, amount)
				.stream()
				.map(storeDtoMapper::dtoToResponse)
				.collect(Collectors.toList());
	}

	@Override
	public List<FoodaStoreRes> getStoreByDeliveryCost(final BigDecimal minPrice, final BigDecimal maxPrice) {

		return storeRepo.findByDeliveryCost( minPrice, maxPrice)
				.stream()
				.map(storeDtoMapper::dtoToResponse).collect(Collectors.toList());
	}
	@Override
	public List<FoodaStoreRes> getStoreByPaymentMethodId(final Long paymentMethodId, final BigDecimal minOrderAmount) {
		return storeRepo.findByPaymentMethodId(paymentMethodId, minOrderAmount)
				.stream()
				.map(storeDtoMapper::dtoToResponse).collect(Collectors.toList());
	}

	@Override
	public List<FoodaStoreRes> getStoreByPaymentMethodId(final Long paymentMethodId) {
		return storeRepo.findByPaymentMethodId(paymentMethodId)
				.stream()
				.map(storeDtoMapper::dtoToResponse).collect(Collectors.toList());
	}



	@Override
	public FoodaStoreRes addStore(final FoodaStoreReq storeReq) {
		return storeDtoMapper.dtoToResponse(
				storeRepo.save(
						storeDtoMapper.requestToDto(storeReq)));
	}

	@Override
	public Optional<FoodaStoreRes> editStoreById(final Long storeId, final FoodaStoreReq storeReq) {
		return getStoreById(storeId)
				.map(res-> storeHttpMapper.requestToResponse(storeReq)
						.toBuilder()
						.storeId(storeId)
						.build())
				.map(res->storeDtoMapper.dtoToResponse(
						storeRepo.save(
								storeDtoMapper.responseToDto(res)
						)));
	}

	@Override
	public Optional<FoodaStoreRes> editStoreByExample(final FoodaStoreReq req) {
		return storeRepo.findOne(Example.of(storeDtoMapper.requestToDto(req)))
				.map(res-> storeHttpMapper.requestToResponse(req))
				.map(res->storeDtoMapper.dtoToResponse(
						storeRepo.save(
								storeDtoMapper.responseToDto(res)
						)));
	}

	@Override
	public Optional<FoodaStoreRes> removeStoreById(final Long storeId) {
		final Optional<FoodaStoreRes> foundStore = getStoreById(storeId);
		foundStore.ifPresent(res -> storeRepo.deleteById(storeId));
		final Optional<FoodaStoreRes> storeAfterDelete = getStoreById(storeId);
		if (storeAfterDelete.isEmpty()) {
			return foundStore;
		} else {
			return Optional.empty();
		}
	}

		@Override
		public Optional<FoodaStoreRes> removeStoreByExample(final FoodaStoreReq storeReq) {
			return getStoreByExample(storeReq).map(
					res -> storeDtoMapper.dtoToResponse(
							storeRepo.save(storeDtoMapper.responseToDto(res))));
		}

		@Override
		public Boolean doesStoreExistById(Long storeId) {
			return storeRepo.existsById(storeId);
		}

		@Override
		public Boolean doesStoreExistByExample(FoodaStoreReq req) {
			return storeRepo.exists(Example.of(storeDtoMapper.requestToDto(req)));
		}

		@Override
		public List<FoodaStoreRes> getAllStores() {

			return storeRepo.findAll()
					.stream()
					.map(storeDtoMapper::dtoToResponse)
					.collect(Collectors.toList());
		}


	}