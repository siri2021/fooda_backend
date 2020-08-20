package be.fooda.backend.commons.dao.repo;

import be.fooda.backend.commons.model.template.user.dto.FoodaUserDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodaUserRepository extends CrudRepository<FoodaUserDto, Long> {
    Optional<FoodaUserDto> findByLogin(final String login);
}
