package be.fooda.backend.commons.dao.repo;

import be.fooda.backend.commons.model.template.user.dto.FoodaUserDto;
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
