package be.fooda.backend.store.service;

import be.fooda.backend.commons.model.template.store.request.FoodaStoreReq;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface FoodaStoreService<REQ, RES> {

    Optional<RES> getById(final Long storeId);

    Optional<RES> getByExample(final REQ example);

    List<RES> getAll();

    List<RES> getByName(final String name);

    List<RES> getByAddressId(Set<Long> idSet);

    List<RES> getByType(String title);

    List<RES> getByParent(Long storeParentId);

    List<RES> getByAbout(final String about);

    Optional<RES> getByAuth(final String key, final String secret, final Long storeId);

    List<RES> getByWorkingHours(final LocalDate date, final LocalDateTime opens, final LocalDateTime closes);

    List<RES> getByWorkingHours(final LocalDateTime opens, final LocalDateTime closes);

    List<RES> getByDeliveryLocation(final Long municipalityId);

    List<RES> getStoreByDeliveryTime(final Integer timeAsMinutes);

    List<RES> getStoreByDeliveryCost(final BigDecimal minPrice, final BigDecimal maxPrice, BigDecimal amount);

    List<RES> getStoreByDeliveryCost(final BigDecimal minPrice, final BigDecimal maxPrice);

    List<RES> getStoreByPaymentMethodId(final Long paymentMethodId, final BigDecimal minOrderAmount);

    List<RES> getStoreByPaymentMethodId(final Long paymentMethodId);

    RES addStore(final REQ storeReq);

    Optional<RES> editStoreById(final Long storeId, final REQ storeReq);

    Optional<RES> editStoreByExample(final REQ req);

    Optional<RES> removeStoreById(final Long storeId);

    Optional<RES> removeStoreByExample(final REQ storeReq);

    Boolean doesStoreExistById(final Long storeId);

    Boolean doesStoreExistByExample(final FoodaStoreReq req);


}
