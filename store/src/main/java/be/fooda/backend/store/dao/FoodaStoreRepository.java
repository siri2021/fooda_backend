package be.fooda.backend.store.dao;

import be.fooda.backend.store.model.dto.FoodaStoreDto;
import be.fooda.backend.store.model.dto.FoodaStoreTypeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface FoodaStoreRepository extends JpaRepository<FoodaStoreDto, Long> {

    @Query("SELECT s FROM FoodaStoreDto s WHERE s.name LIKE :name")
    List<FoodaStoreDto> findAllByName(@Param("name") String name);

    @Query("SELECT s FROM FoodaStoreDto s WHERE s.address.addressId IN :addresses")
    List<FoodaStoreDto> findByAddressId(@Param("addresses") final Collection<Long> address);

    List<FoodaStoreDto> findByType(final FoodaStoreTypeDto type);

    @Query("SELECT s FROM FoodaStoreDto s WHERE s.type.title = :title")
    List<FoodaStoreDto> findByType(@Param("title") final String title);

    List<FoodaStoreDto> findByParentId(final Long parent);

    List<FoodaStoreDto> findByAbout(final String about);

    @Query("SELECT swh FROM FoodaStoreWorkingHoursDto swh WHERE swh.workingDate = :date AND swh.openTime = :opens AND swh.closeTime =:closes")
    Optional<FoodaStoreDto> findByWorkingHours(@Param("date") final LocalDate date, @Param("opens") final LocalDateTime opens, @Param("closes") final LocalDateTime closes);

    @Query("SELECT swh FROM FoodaStoreWorkingHoursDto swh WHERE swh.openTime = :opens AND swh.closeTime =:closes")
    Optional<FoodaStoreDto> findByWorkingHours(@Param("opens") final LocalDateTime opens, @Param("closes") final LocalDateTime closes);

    @Query("SELECT sdl FROM FoodaStoreDeliveryLocationDto sdl WHERE sdl.municipalityId = :municipalityId")
    List<FoodaStoreDto> findByDeliveryLocation(@Param("municipalityId") final Long municipalityId);

    @Query("SELECT sdl FROM FoodaStoreDeliveryLocationDto sdl WHERE sdl.deliveryTime = :timeAsMinutes")
    List<FoodaStoreDto> findByDeliveryTime(@Param("timeAsMinutes") final Integer timeAsMinutes);

    @Query("SELECT sdc FROM FoodaStoreDeliveryLocationDto sdc WHERE sdc.minOrderPrice >= :minPrice AND sdc.maxOrderPrice <= :maxPrice")
    List<FoodaStoreDto> findByDeliveryCost(@Param("minPrice") final BigDecimal minPrice, @Param("maxPrice") final BigDecimal maxPrice);

    @Query("SELECT sdc FROM FoodaStoreDeliveryLocationDto sdc WHERE sdc.minOrderPrice >= :minPrice AND sdc.maxOrderPrice <= :maxPrice AND sdc.deliveryCost >= :amount")
    List<FoodaStoreDto> findByDeliveryCost(@Param("minPrice")final BigDecimal minPrice,@Param("maxPrice") final BigDecimal maxPrice,@Param("amount") final BigDecimal amount);

    @Query("SELECT spm FROM FoodaStorePaymentMethodDto spm WHERE spm.paymentMethodId= :paymentMethodId AND spm.minOrderAmount >= :minOrderAmount ")
    List<FoodaStoreDto> findByPaymentMethodId(@Param("paymentMethodId")final Long paymentMethodId,@Param("minOrderAmount") final BigDecimal minOrderAmount);

    @Query("SELECT spm FROM FoodaStorePaymentMethodDto spm WHERE spm.paymentMethodId= :paymentMethodId ")
    List<FoodaStoreDto> findByPaymentMethodId(@Param("paymentMethodId")final Long paymentMethodId);


}
