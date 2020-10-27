package be.fooda.backend.store.dao;

import be.fooda.backend.store.model.dto.FoodaStoreDto;
import be.fooda.backend.store.model.dto.FoodaStorePaymentMethodDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface FoodaStorePaymentMethodRepository extends JpaRepository<FoodaStorePaymentMethodDto, Long> {
    @Query("SELECT spm FROM FoodaStorePaymentMethodDto spm WHERE spm.paymentMethodId = :paymentMethodId AND spm.minOrderAmount >= :minOrderAmount ")
    List<FoodaStorePaymentMethodDto> findByPaymentMethodId(@Param("paymentMethodId") final Long paymentMethodId, @Param("minOrderAmount") final BigDecimal minOrderAmount);

    @Query("SELECT spm FROM FoodaStorePaymentMethodDto spm WHERE spm.paymentMethodId = :paymentMethodId ")
    List<FoodaStorePaymentMethodDto> findByPaymentMethodId(@Param("paymentMethodId") final Long paymentMethodId);
}
