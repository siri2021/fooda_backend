package be.fooda.backend.user.dao;

import be.fooda.backend.user.model.dto.FoodaUserDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodaUserRepository extends CrudRepository<FoodaUserDto, Long> {
    @Query("SELECT u FROM USER u WHERE u.login = :login")
    Optional<FoodaUserDto> findByLogin(@Param("login") String login);
}
