package be.fooda.backend.commons.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface MySqlRepository<T, K> extends CrudRepository<T, K> {
    Optional<T> findByKey(final K key);
    Boolean existsByKey(final K key);
    List<T> findAllIsActive(final Boolean isActive);
    List<T> findAllByRegistryDate(final Date registry);
}
