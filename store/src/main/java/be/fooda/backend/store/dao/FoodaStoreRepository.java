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

    @Query("SELECT swh FROM FoodaStoreWorkingHoursDto swh WHERE swh.workingDate = :date AND swh.openTime = :opens AND closeTime =:closes")
    Optional<FoodaStoreDto> findByWorkingHours(final LocalDate date, final LocalDateTime opens, final LocalDateTime closes);

    @Query("SELECT swh FROM FoodaStoreWorkingHoursDto swh WHERE swh.openTime = :opens AND swh.closeTime =:closes")
    Optional<FoodaStoreDto> findByWorkingHours(final LocalDateTime opens, final LocalDateTime closes);

    @Query("SELECT sdl FROM FoodaStoreDeliveryLocationDto sdl WHERE sdl.municipalityId = :municipalityId")
    List<FoodaStoreDto> findByDeliveryLocation(final Long municipalityId);

    @Query("SELECT sdl FROM FoodaStoreDeliveryLocationDto sdl WHERE sdl.deliveryTime = :timeAsMinutes")
    List<FoodaStoreDto> findByDeliveryTime(final Integer timeAsMinutes);

    @Query("SELECT sdc FROM FoodaStoreDeliveryCostDto sdc WHERE sdc.minPrice = : minPrice AND sdc.maxPrice =: maxPrice")
    List<FoodaStoreDto> findByDeliveryCost(final BigDecimal minPrice, final BigDecimal maxPrice);

    @Query("SELECT sdc FROM FoodaStoreDeliveryCostDto sdc WHERE sdc.minPrice = : minPrice AND sdc.maxPrice =: maxPrice AND sdc.amount = :amount")
    List<FoodaStoreDto> findByDeliveryCost(final BigDecimal minPrice, final BigDecimal maxPrice, final BigDecimal amount);

    @Query("SELECT spm FROM FoodaStorePaymentMethodDto spm WHERE spm.paymentMethodId= :paymentMethodId AND spm.minOrder = : minOrderAmount ")
    List<FoodaStoreDto> findByPaymentMethodId(final Long paymentMethodId, final BigDecimal minOrderAmount);

    @Query("SELECT spm FROM FoodaStorePaymentMethodDto spm WHERE spm.paymentMethodId= :paymentMethodId ")
    List<FoodaStoreDto> findByPaymentMethodId(final Long paymentMethodId);


}
