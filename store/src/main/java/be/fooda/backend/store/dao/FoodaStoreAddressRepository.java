package be.fooda.backend.store.dao;

import be.fooda.backend.store.model.dto.FoodaStoreAddressDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodaStoreAddressRepository extends JpaRepository<FoodaStoreAddressDto, Long> {

}
