package be.fooda.backend.order.dao;

import be.fooda.backend.commons.model.template.order.request.FoodaOrderReq;
import be.fooda.backend.commons.model.template.order.response.FoodaOrderRes;
import be.fooda.backend.order.model.dto.FoodaOrderDto;
import be.fooda.backend.order.model.dto.FoodaOrderKeyDto;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface FoodaOrderRepository extends CrudRepository<FoodaOrderDto, FoodaOrderKeyDto> {

    Optional<FoodaOrderDto> findByOrderKey_OrderKeyId(Long orderKeyId);

    Optional<FoodaOrderDto> findByOrderKey_ExternalOrderIdAndOrderKey_UserIdAndOrderKey_StoreId (Long externalOrderId, Long userId,Long storeId);
    
    Optional<FoodaOrderDto> findByExample(FoodaOrderReq example);

    List<FoodaOrderDto> findByStatusId(Long statusId);

    List<FoodaOrderDto> findByRequiredTime(LocalDateTime requiredTime);

    List<FoodaOrderDto> findByDeliveryTime(LocalDateTime deliveryTime);

    List<FoodaOrderDto> findByPaymentTime(LocalDateTime paymentTime);

    @Query("FROM FoodaOrderDto o WHERE o.orderKey IN (SELECT op.orderKey FROM FoodaOrderPaymentDto  op WHERE op.paymentId = ?1)")
    List<FoodaOrderDto> findByPaymentId(Long productKey);

    @Query("FROM FoodaOrderDto o WHERE o.orderKey IN (SELECT op.orderKey FROM FoodaOrderPaymentDto  op WHERE op.amount = ?1)")
    List<FoodaOrderDto> findByPaymentAmount(BigDecimal amount);

    @Query("FROM FoodaOrderDto o WHERE o.orderKey IN (SELECT op.orderKey FROM FoodaOrderPaymentDto  op WHERE op.amount between ?1 AND ?2)")
    List<FoodaOrderDto> findByPaymentAmount(BigDecimal minAmount, BigDecimal maxAmount);

    List<FoodaOrderDto> findByProductKey(Long productKey);

    List<FoodaOrderDto> findByOrderKey_StoreId(Long storeId);

    List<FoodaOrderDto> findByOrderKey_UserId(Long userId);

    @Modifying
    @Query("DELETE FROM FoodaOrderDto o WHERE o.orderKey.orderKeyId = ?1")
    void deleteByOrderKey_orderKeyId(Long orderKeyId);

    @Modifying
    @Query("DELETE FROM FoodaOrderDto o WHERE o.orderKey.externalOrderId = ?1 AND o.orderKey.userId = ?2 AND o.orderKey.storeId = ?3")
    void deleteByOrderKey_ExternalOrderIdAndOrderKey_UserIdAndOrderKey_StoreId(Long externalOrderId, Long userID, Long storeId);


    Boolean existsByOrderKey_OrderKeyId(Long orderKeyId);

    Boolean existsByOrderKey_ExternalOrderIdAndOrderKey_UserIdAndOrderKey_StoreId(Long externalOrderId, Long userID, Long storeId);

    Boolean exists(Example<FoodaOrderDto> example);
}
