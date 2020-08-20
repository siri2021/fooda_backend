package be.fooda.backend.commons.dao.repo;

import be.fooda.backend.commons.model.template.user.dto.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByLogin(final String login);
}
