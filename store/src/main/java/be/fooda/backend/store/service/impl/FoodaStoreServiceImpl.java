package be.fooda.backend.store.service.impl;

import be.fooda.backend.commons.model.template.store.request.FoodaStoreReq;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.commons.service.mapper.FoodaHttpMapper;
import be.fooda.backend.store.dao.*;
import be.fooda.backend.store.model.dto.*;
import be.fooda.backend.store.service.FoodaStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class FoodaStoreServiceImpl implements FoodaStoreService<FoodaStoreReq, FoodaStoreRes> {

    @Autowired
    private FoodaStoreRepository storeRepo;

    @Autowired
    private FoodaStoreAuthRepository authRepo;

    @Autowired
    private FoodaStoreAddressRepository addressRepo;

    @Autowired
    private FoodaStoreMediaRepository mediaRepo;

    @Autowired
    private FoodaStoreContactRepository contactRepo;

    @Autowired
    private FoodaStoreDeliveryLocationRepository locationRepo;

    @Autowired
    private FoodaStorePaymentMethodRepository paymentRepo;

    @Autowired
    private FoodaStoreWorkingHoursRepository hoursRepo;

    @Autowired
    private FoodaDtoMapper<FoodaStoreDto, FoodaStoreReq, FoodaStoreRes> storeDtoMapper;

    @Autowired
    private FoodaHttpMapper<FoodaStoreReq, FoodaStoreRes> storeHttpMapper;

    @Override
    public Optional<FoodaStoreRes> getById(final Long storeId) {
        return storeRepo.findById(storeId)
                .map(storeDtoMapper::dtoToResponse);
    }

    @Override
    public Optional<FoodaStoreRes> getByExample(final FoodaStoreReq example) {
        return storeRepo
                .findOne(Example.of(storeDtoMapper.requestToDto(example)))
                .map(storeDtoMapper::dtoToResponse);
    }

    @Override
    public List<FoodaStoreRes> getByName(final String name) {
        return storeRepo.findAllByName(name)
                .stream()
                .map(storeDtoMapper::dtoToResponse)
                .collect(Collectors.toList());

    }

    @Override
    public List<FoodaStoreRes> getByAddressId(final Set<Long> idSet) {
        return storeRepo.findByAddressId(idSet)
                .stream()
                .map(storeDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }


    @Override
    public List<FoodaStoreRes> getByType(final String title) {
        return storeRepo.findByType(title).stream()
                .map(storeDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaStoreRes> getByParent(final Long storeParentId) {
        return storeRepo.findByParentId(storeParentId)
                .stream()
                .map(storeDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaStoreRes> getByAbout(final String about) {
        return storeRepo.findByAbout(about)
                .stream()
                .map(storeDtoMapper::dtoToResponse).collect(Collectors.toList());
    }

    @Override
    public Optional<FoodaStoreRes> getByAuth(final String key, final String secret, final Long storeId) {
        Optional<FoodaStoreAuthDto> oAuthByStore = authRepo.findByAuth(key, secret, storeId);
        return oAuthByStore.isPresent() ?
                Optional.of(storeDtoMapper.dtoToResponse(storeRepo.getOne(storeId))) :
                Optional.empty();
    }

    @Override
    public List<FoodaStoreRes> getByWorkingHours(final LocalDate date, final LocalDateTime opens, final LocalDateTime closes) {
        return storeRepo.findByWorkingHours(date, opens, closes)
                .stream()
                .map(storeDtoMapper::dtoToResponse).collect(Collectors.toList());
    }

    @Override
    public List<FoodaStoreRes> getByWorkingHours(final LocalDateTime opens, final LocalDateTime closes) {
        return storeRepo.findByWorkingHours(opens, closes)
                .stream()
                .map(storeDtoMapper::dtoToResponse).collect(Collectors.toList());
    }

    @Override
    public List<FoodaStoreRes> getByDeliveryLocation(final Long municipalityId) {
        return storeRepo.findByDeliveryLocation(municipalityId)
                .stream()
                .map(storeDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaStoreRes> getStoreByDeliveryTime(Integer timeAsMinutes) {
        return storeRepo.findByDeliveryTime(timeAsMinutes)
                .stream()
                .map(storeDtoMapper::dtoToResponse).collect(Collectors.toList());
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
        return storeRepo.findByDeliveryCost(minPrice, maxPrice)
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

        FoodaStoreDto store = storeDtoMapper.requestToDto(storeReq);
        final FoodaStoreDto savedStore = storeRepo.save(store);

        final FoodaStoreAddressDto address = store.getAddress();
        address.setStore(savedStore);
        addressRepo.save(address);

        final FoodaStoreAuthDto auth = store.getAuth();
        auth.setStore(savedStore);
        authRepo.save(auth);

        final FoodaStoreMediaDto bgImage = store.getBgImage();
        bgImage.setStore(savedStore);
        mediaRepo.save(bgImage);

        final FoodaStoreMediaDto bgVideo = store.getBgVideo();
        bgVideo.setStore(savedStore);
        mediaRepo.save(bgVideo);

        final FoodaStoreContactDto contact = store.getContact();
        contact.setStore(savedStore);
        contactRepo.save(contact);

        final List<FoodaStoreDeliveryLocationDto> deliveryLocations = store.getDeliveryLocations();
        deliveryLocations.forEach(location -> {
            location.setStore(savedStore);
            locationRepo.save(location);
        });

        final FoodaStoreMediaDto logoImage = store.getLogoImage();
        logoImage.setStore(savedStore);
        mediaRepo.save(logoImage);

        final List<FoodaStorePaymentMethodDto> paymentMethods = store.getPaymentMethods();
        paymentMethods.forEach(payment -> {
            payment.setStore(savedStore);
            paymentRepo.save(payment);
        });

        final List<FoodaStoreWorkingHoursDto> workingHours = store.getWorkingHours();
        workingHours.forEach(hours -> {
            hours.setStore(savedStore);
            hoursRepo.save(hours);
        });

        return storeDtoMapper.dtoToResponse(savedStore);
    }

    @Override
    public Optional<FoodaStoreRes> editStoreById(final Long storeId, final FoodaStoreReq storeReq) {
        return getById(storeId)
                .map(res -> storeHttpMapper.requestToResponse(storeReq)
                        .toBuilder()
                        .storeId(storeId)
                        .build())
                .map(res -> storeDtoMapper.dtoToResponse(
                        storeRepo.save(
                                storeDtoMapper.responseToDto(res))));
    }

    @Override
    public Optional<FoodaStoreRes> editStoreByExample(final FoodaStoreReq req) {
        return storeRepo.findOne(Example.of(storeDtoMapper.requestToDto(req)))
                .map(res -> storeHttpMapper.requestToResponse(req))
                .map(res -> storeDtoMapper.dtoToResponse(
                        storeRepo.save(
                                storeDtoMapper.responseToDto(res))));
    }

    @Override
    public Optional<FoodaStoreRes> removeStoreById(final Long storeId) {
        final Optional<FoodaStoreRes> foundStore = getById(storeId);
        foundStore.ifPresent(res -> storeRepo.deleteById(storeId));
        final Optional<FoodaStoreRes> storeAfterDelete = getById(storeId);
        if (storeAfterDelete.isEmpty()) {
            return foundStore;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<FoodaStoreRes> removeStoreByExample(final FoodaStoreReq storeReq) {
        return getByExample(storeReq).map(
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
    public List<FoodaStoreRes> getAll() {

        return storeRepo.findAll()
                .stream()
                .map(storeDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }


}