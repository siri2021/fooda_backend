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


@RequiredArgsConstructor
public class FoodaStoreServiceImpl implements FoodaStoreService<FoodaStoreReq, FoodaStoreRes> {

	private final FoodaStoreRepository storeRepo;
	private final FoodaStoreDtoMapper storeDtoMapper;
	private final FoodaStoreHttpMapper storeHttpMapper;

	@Override
	public Optional<FoodaStoreRes> getStoreById(final Long storeId) {
		return storeRepo.findById(storeId)
				.map(storeDtoMapper::dtoToResponse);

	}

	@Override
	public Optional<FoodaStoreRes> getStoreByExample(final FoodaStoreReq example) {

		return storeRepo.findByExample(example).map(storeDtoMapper::dtoToResponse);
	}

	@Override
	public List<FoodaStoreRes> getStoreByName(final String name) {
		return storeRepo.findAllByName(
				FoodaStoreDto
						.builder()
						.name(name)
						.build())
				.stream()
				.map(storeDtoMapper::dtoToResponse)
				.collect(Collectors.toList());

	}

	@Override
	public List<FoodaStoreRes> getStoreByAddressId(final Set<Long> idSet) {
		return storeRepo.findByAddressId(
				FoodaStoreDto
						.builder()
						.addressId(idSet
								.stream()
								.findAny()
								.get())
						.build())
				.stream()
				.map(storeDtoMapper::dtoToResponse)
				.collect(Collectors.toList());


	}

	@Override
	public List<FoodaStoreRes> getStoreByTypeId(final Long storeTypeId) {
		return storeRepo.findByTypeId(FoodaStoreTypeDto
				.builder()
				.id(storeTypeId)
				.build())
				.stream()
				.map(storeDtoMapper::dtoToResponse)
				.collect(Collectors.toList())
				;
	}

	@Override
	public List<FoodaStoreRes> getStoreByParentId(final Long storeParentId) {
		return storeRepo.findByParentId(FoodaStoreDto
				.builder()
				.parent(FoodaStoreDto.builder().storeId(storeParentId).build())
				.build())
				.stream()
				.map(storeDtoMapper::dtoToResponse)
				.collect(Collectors.toList());

	}

	@Override
	public List<FoodaStoreRes> getStoreByAbout(final String about) {
		return storeRepo.findByAbout(FoodaStoreDto
				.builder()
				.about(about)
				.build())
				.stream()
				.map(storeDtoMapper::dtoToResponse).collect(Collectors.toList());

	}

	@Override
	public Optional<FoodaStoreRes> getStoreByAuth(final String key, final String secret) {
		return storeRepo.findByAuth(FoodaStoreAuthDto
				.builder()
				.key(key)
				.secret(secret)
				.build())
				.map(storeDtoMapper::dtoToResponse)
				;

	}

	@Override
	public List<FoodaStoreRes> getStoreByWorkingHours(final LocalDate date, final LocalDateTime opens, final LocalDateTime closes) {
		return storeRepo.findByWorkingHours(FoodaStoreWorkingHoursDto
				.builder()
				.openTime(opens)
				.closeTime(closes)
				.workingDay(date)
				.build())
				.stream()
				.map(storeDtoMapper::dtoToResponse).collect(Collectors.toList())
				;
	}

	@Override
	public List<FoodaStoreRes> getStoreByWorkingHours(final LocalDateTime opens, final LocalDateTime closes) {

		return storeRepo.findByWorkingHours(FoodaStoreWorkingHoursDto
				.builder()
				.openTime(opens)
				.closeTime(closes)
				.build())
				.stream()
				.map(storeDtoMapper::dtoToResponse).collect(Collectors.toList())
				;
	}

	@Override
	public List<FoodaStoreRes> getStoreByDeliveryLocation(final Long municipalityId) {
		return storeRepo.findByDeliveryLocation(FoodaStoreDeliveryLocationDto
				.builder()
				.municipalityId(municipalityId)
				.build())
				.stream()
				.map(storeDtoMapper::dtoToResponse)
				.collect(Collectors.toList())
				;
	}

	@Override
	public List<FoodaStoreRes> getStoreByDeliveryTime(Integer timeAsMinutes) {
		return storeRepo.findByDeliveryTime(FoodaStoreDeliveryLocationDto
				.builder()
				.deliveryTime(LocalDateTime.now().plusMinutes(timeAsMinutes))
				.build()).stream()
				.map(storeDtoMapper::dtoToResponse).collect(Collectors.toList())
				;
	}



	@Override
	public List<FoodaStoreRes> getStoreByDeliveryCost(final BigDecimal minPrice, final BigDecimal maxPrice, final BigDecimal amount) {
		return storeRepo.findByDeliveryCost(FoodaStoreDeliveryCostDto
				.builder()
				.minPrice(minPrice)
				.amount(amount)
				.maxPrice(maxPrice)
				.build())
				.stream()
				.map(storeDtoMapper::dtoToResponse)
				.collect(Collectors.toList());
	}

	@Override
	public List<FoodaStoreRes> getStoreByDeliveryCost(final BigDecimal minPrice, final BigDecimal maxPrice) {

		return storeRepo.findByDeliveryCost(FoodaStoreDeliveryCostDto
				.builder()
				.minPrice(minPrice)
				.maxPrice(maxPrice)
				.build())
				.stream()
				.map(storeDtoMapper::dtoToResponse).collect(Collectors.toList());
	}
	@Override
	public List<FoodaStoreRes> getStoreByPaymentMethodId(final Long paymentMethodId, final BigDecimal minOrderAmount) {
		return storeRepo.findByPaymentMethodId(FoodaStorePaymentMethodDto
				.builder()
				.methodId(paymentMethodId)
				.minOrderAmount(minOrderAmount)
				.build())
				.stream()
				.map(storeDtoMapper::dtoToResponse).collect(Collectors.toList());
	}

	@Override
	public List<FoodaStoreRes> getStoreByPaymentMethodId(final Long paymentMethodId) {
		return storeRepo.findByPaymentMethodId(FoodaStorePaymentMethodDto
				.builder()
				.methodId(paymentMethodId)
				.build())
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
		return storeRepo.findByExample(req).map(res-> storeHttpMapper.requestToResponse(req))
				.map(res->storeDtoMapper.dtoToResponse(
						storeRepo.save(
								storeDtoMapper.responseToDto(res)
						)));
	}
	/*final Optional<FoodaBasketOrderRes> foundOrder = getBasketOrderByExample(foodaBasketOrderReq);
        foundOrder.ifPresent(res ->
			basketOrderRepo.delete(
			basketOrderDtoMapper.requestToDto(foodaBasketOrderReq)));

	final Optional<FoodaBasketOrderRes> oBasketOrderAfterDelete = getBasketOrderByExample(foodaBasketOrderReq);
        if (oBasketOrderAfterDelete.isEmpty()) {
		return foundOrder;
	} else {
		return Optional.empty();
	}
	final Optional<FoodaBasketOrderRes> foundOrder = getBasketOrderById(basketOrderId);
        foundOrder.ifPresent(res -> basketOrderRepo.deleteById(new ObjectId(basketOrderId)));
        final Optional<FoodaBasketOrderRes> oBasketOrderAfterDelete = getBasketOrderById(basketOrderId);
        if (oBasketOrderAfterDelete.isEmpty()) {
            return foundOrder;
        } else {
            return Optional.empty();
        }*/

	@Override
	public Optional<FoodaStoreRes> removeStoreById(final Long storeId) {
		final Optional<FoodaStoreRes> foundStore = getStoreById(storeId);
		foundStore.ifPresent(res -> storeRepo.deleteById(storeId))
		final Optional<FoodaStoreRes> storeAfterDelete=getStoreById(storeId)      ;
		if(storeAfterDelete .isEmpty()) {
			return foundStore;
		}
		else{
			return  Optional.empty()
		}


		@Override
		public Optional<FoodaStoreRes> removeStoreByExample(final FoodaStoreReq storeReq) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Optional<FoodaStoreRes> doesStoreExistById(Long storeId) {
			return Optional.empty();
		}

		@Override
		public Optional<FoodaStoreRes> doesStoreExistByExample(Long storeId) {
			return Optional.empty();
		}

		@Override
		public List<FoodaStoreRes> getAllStores() {
			// TODO Auto-generated method stub
			return null;
		}


	}