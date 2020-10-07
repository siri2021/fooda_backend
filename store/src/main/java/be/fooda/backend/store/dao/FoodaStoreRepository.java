package be.fooda.backend.store.dao;

import be.fooda.backend.commons.model.template.store.request.FoodaStoreReq;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreRes;
import be.fooda.backend.store.model.dto.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface FoodaStoreRepository extends JpaRepository<FoodaStoreDto, Long> {

    @Query("SELECT s FROM FoodaStoreDto s WHERE s.name LIKE :name") 
    List<FoodaStoreDto> findAllByName(@Param("name") String name);
    
    @Query("SELECT s FROM FoodaStoreDto s WHERE s.addressId IN :addresses") 
    List<FoodaStoreDto> findByAddressId(@Param("addresses") final
                                        Collection<Long> address);

    List<FoodaStoreDto> findByType(final FoodaStoreTypeDto type);
    
    @Query("SELECT s FROM FoodaStoreDto s WHERE s.type.title = :title")
    List<FoodaStoreDto> findByType(@Param("title") final String title);

    List<FoodaStoreDto> findByParentId(final Long parent);
    
    List<FoodaStoreDto> findByAbout(final String about);


    
    @Query("SELECT s from FoodaStoreWorkingHoursDto f where ")
    Optional<FoodaStoreDto> findByWorkingHours(final LocalDate date, final LocalDateTime opens, final LocalDateTime closes);
    
    @Query()
    Optional<FoodaStoreDto> findByWorkingHours(final LocalDateTime opens, final LocalDateTime closes);

    List<FoodaStoreDto> findByDeliveryLocation(final Long municipalityId);

    List<FoodaStoreDto> findByDeliveryTime(final Integer timeAsMinutes);
    
    @Query()
    List<FoodaStoreDto> findByDeliveryCost(final BigDecimal minPrice, final BigDecimal maxPrice);
    
    @Query()
    List<FoodaStoreDto> findByDeliveryCost(final BigDecimal minPrice, final BigDecimal maxPrice,final BigDecimal amount);
    
    @Query()
    List<FoodaStoreDto> findByPaymentMethodId(final Long paymentMethodId, final BigDecimal minOrderAmount);

    List<FoodaStoreDto> findByPaymentMethodId(final Long paymentMethodId);


}
