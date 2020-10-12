package be.fooda.backend.store.dao;

import be.fooda.backend.store.model.dto.FoodaStorePaymentMethodDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodaStorePaymentMethodRepository extends JpaRepository<FoodaStorePaymentMethodDto, Long> {
}
