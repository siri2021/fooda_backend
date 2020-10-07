package be.fooda.backend.store.dao;

import be.fooda.backend.store.model.dto.FoodaStoreAuthDto;
import be.fooda.backend.store.model.dto.FoodaStoreDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FoodaAuthRepository extends JpaRepository<FoodaStoreAuthDto, Long> {

    @Query("SELECT A FROM FoodaStoreAuthDto WHERE A.key = :key AND A.secret = :secret AND A.store.storeId = :storeId ")
    Optional<FoodaStoreDto> findByAuth(@Param("key") final String key, @Param("secret") final String secret, @Param("storeId") final Long storeId);
}
