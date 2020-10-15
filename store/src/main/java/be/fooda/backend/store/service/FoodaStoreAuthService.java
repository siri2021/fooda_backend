package be.fooda.backend.store.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FoodaStoreAuthService<REQ, RES> {



    Optional<RES> getByAuth(final String key, final String secret, final Long storeId);
}
