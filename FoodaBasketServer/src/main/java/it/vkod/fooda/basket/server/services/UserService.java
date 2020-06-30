package it.vkod.fooda.basket.server.services;

import it.vkod.fooda.basket.server.models.User;

import java.math.BigInteger;
import java.util.Optional;

public interface UserService extends BasketService<User> {
    Optional<User> login(final String username, final String password);
    void logout(final BigInteger userId);
    Boolean exists(final String username);
}
