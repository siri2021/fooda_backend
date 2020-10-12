package be.fooda.backend.contact.service;

import java.util.List;
import java.util.Optional;

public interface FoodaContactService<REQ, RES> {

    Optional<RES> getById(final Long id);

    List<RES> getAll();

    Optional<RES> getByExample(final REQ req);

    List<RES> getByUserId(final Long userId);

    Optional<RES> add(final REQ req);

    Optional<RES> editById(final Long id, REQ req);

    Optional<RES> editByExample(final REQ req);

    Optional<RES> removeById(final Long id);

    List<RES> removeByUserId(final Long userId);

    Optional<RES> removeByExample(final REQ req);

    Boolean existsById(final Long id);

    Boolean existsByExample(final REQ req);
    
}
