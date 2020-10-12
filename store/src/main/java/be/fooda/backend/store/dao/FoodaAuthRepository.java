package be.fooda.backend.store.dao;

import be.fooda.backend.store.model.dto.FoodaStoreAuthDto;
import be.fooda.backend.store.model.dto.FoodaStoreDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodaAuthRepository extends JpaRepository<FoodaStoreAuthDto, Long> {

    @Query("SELECT s FROM FoodaStoreAuthDto WHERE s.key = :key AND s.secret = :secret AND s.store.storeId = :storeId ")
    Optional<FoodaStoreDto> findByAuth(@Param("key") final String key, @Param("secret") final String secret, @Param("storeId") final Long storeId);
}
