package be.fooda.backend.order.dao;

import be.fooda.backend.order.model.dto.FoodaOrderDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FoodaOrderRepository extends JpaRepository<FoodaOrderDto, Long> {

    @Query("SELECT o FROM FoodaOrderDto o WHERE o.userId = ?1")
    List<FoodaOrderDto> findByUser(Long userId);

    @Query("SELECT o FROM FoodaOrderDto o WHERE o.orderStatus.orderStatusId = ?1")
    List<FoodaOrderDto> findByStatus(Long statusId);

    List<FoodaOrderDto> findByRequiredTime(LocalDateTime requiredTime);

    List<FoodaOrderDto> findByDeliveryTime(LocalDateTime deliveryTime);

    List<FoodaOrderDto> findByPaymentTime(LocalDateTime paymentTime);

    @Query("SELECT o FROM FoodaOrderDto o WHERE o.userId = ?1 AND o.payments IN (SELECT p FROM FoodaOrderPaymentDto p WHERE p.paymentId = ?2)")
    List<FoodaOrderDto> findByPayment(Long userId, Long paymentId);

    @Query("SELECT o FROM FoodaOrderDto o WHERE o.payments = (SELECT p FROM FoodaOrderPaymentDto p WHERE p.amount > ?2)")
    List<FoodaOrderDto> findByPriceMin(BigDecimal amount);

    @Query("SELECT o FROM FoodaOrderDto o WHERE o.payments = (SELECT p FROM FoodaOrderPaymentDto p WHERE p.amount >= ?1 AND p.amount <= ?2)")
    List<FoodaOrderDto> findByPriceRange(BigDecimal minAmount, BigDecimal maxAmount);

    @Query("SELECT o FROM FoodaOrderDto o WHERE o.storeId = ?1")
    List<FoodaOrderDto> findByStore(Long storeId);

    @Query("DELETE FROM FoodaOrderDto o WHERE o.externalOrderId = ?1 AND o.storeId = ?2")
    void deleteByExternalOrder(Long externalOrderId, Long storeId);

}
