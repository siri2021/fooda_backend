package be.fooda.backend.store.dao;

import be.fooda.backend.commons.model.template.store.request.FoodaStoreReq;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreRes;
import be.fooda.backend.store.model.dto.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface FoodaStoreRepository extends CrudRepository<FoodaStoreDto, Long> {    public List<FoodaStoreDto> findAllByName(final FoodaStoreDto name);

    List<FoodaStoreDto> findByAddressId(final FoodaStoreDto address);

    List<FoodaStoreDto> findByTypeId(final FoodaStoreTypeDto storeTypeId);

    List<FoodaStoreDto> findByParentId(final FoodaStoreDto parent);

    List<FoodaStoreDto> findByAbout(final FoodaStoreDto about);

    Optional<FoodaStoreDto> findByAuth(FoodaStoreAuthDto auth);

    Optional<FoodaStoreDto> findByWorkingHours(FoodaStoreWorkingHoursDto hours);

    List<FoodaStoreDto> findByDeliveryLocation(FoodaStoreDeliveryLocationDto municipalityId);

    List<FoodaStoreDto> findByDeliveryTime(FoodaStoreDeliveryLocationDto build);

    Optional<FoodaStoreDto> findByExample(FoodaStoreReq example);



    List<FoodaStoreDto> findByDeliveryCost(FoodaStoreDeliveryCostDto build);

    List<FoodaStoreDto> findByPaymentMethodId(FoodaStorePaymentMethodDto build);
}