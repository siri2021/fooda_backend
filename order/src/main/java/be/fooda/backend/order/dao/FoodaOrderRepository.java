package be.fooda.backend.order.dao;

import be.fooda.backend.commons.model.template.order.request.FoodaOrderReq;
import be.fooda.backend.commons.model.template.order.response.FoodaOrderRes;
import be.fooda.backend.order.model.dto.FoodaOrderDto;
import be.fooda.backend.order.model.dto.FoodaOrderKeyDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface FoodaOrderRepository extends CrudRepository<FoodaOrderDto, Long> {
    
    Optional<FoodaOrderDto> findByKey(final FoodaOrderKeyDto key);
    
    Optional<FoodaOrderDto> findByExample(final FoodaOrderReq example);

    List<FoodaOrderDto> findByStatusId(Long statusId);

    List<FoodaOrderDto> findByRequiredTime(LocalDateTime requiredTime);

    List<FoodaOrderDto> findByDeliveryTime(LocalDateTime deliveryTime);

    List<FoodaOrderDto> findByPaymentTime(LocalDateTime paymentTime);

    List<FoodaOrderDto> findByPaymentId(Long paymentId);

    List<FoodaOrderDto> findByPaymentAmount(BigDecimal amount);

    List<FoodaOrderDto> findByPaymentStoreId(Long storeId);

    List<FoodaOrderDto> findByPaymentUserId(Long userId);

    List<FoodaOrderDto> findByPaymentProductKey(Long productKey);
}
