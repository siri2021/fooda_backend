package be.fooda.backend.store.dao;

import be.fooda.backend.store.model.dto.FoodaStoreAuthDto;
import be.fooda.backend.store.model.dto.FoodaStoreDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodaStoreAuthRepository extends JpaRepository<FoodaStoreAuthDto, Long> {

    @Query("SELECT sauth FROM FoodaStoreAuthDto sauth WHERE sauth.key = :key AND sauth.secret = :secret AND sauth.store.id = :storeId")
    Optional<FoodaStoreAuthDto> findByAuth(@Param("key") final String key, @Param("secret") final String secret, @Param("storeId") final Long storeId);

    @Query("SELECT sauth FROM FoodaStoreAuthDto sauth WHERE sauth.store.id = :storeId")
    List<FoodaStoreAuthDto> findByStoreId(@Param("storeId") final Long storeId);
}
