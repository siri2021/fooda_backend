package be.fooda.backend.store.dao;

import be.fooda.backend.commons.model.template.store.request.FoodaStoreReq;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreRes;
import be.fooda.backend.store.model.dto.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface FoodaStoreRepository extends JpaRepository<FoodaStoreDto, Long> {

    List<FoodaStoreDto> findAllByName(String name);

    List<FoodaStoreDto> findByAddressId(final Set<Long> address);

    List<FoodaStoreDto> findByTypeId(final Long storeTypeId);

    List<FoodaStoreDto> findByParentId(final Long parent);

    List<FoodaStoreDto> findByAbout(final String about);

    Optional<FoodaStoreDto> findByAuth(final String key, final String secret );

    Optional<FoodaStoreDto> findByWorkingHours(final LocalDate date, final LocalDateTime opens, final LocalDateTime closes);

    Optional<FoodaStoreDto> findByWorkingHours(final LocalDateTime opens, final LocalDateTime closes);

    List<FoodaStoreDto> findByDeliveryLocation(final Long municipalityId);

    List<FoodaStoreDto> findByDeliveryTime(final Integer timeAsMinutes);

      List<FoodaStoreDto> findByDeliveryCost(final BigDecimal minPrice, final BigDecimal maxPrice);

    List<FoodaStoreDto> findByDeliveryCost(final BigDecimal minPrice, final BigDecimal maxPrice,final BigDecimal amount);

    List<FoodaStoreDto> findByPaymentMethodId(final Long paymentMethodId, final BigDecimal minOrderAmount);

    List<FoodaStoreDto> findByPaymentMethodId(final Long paymentMethodId);


}