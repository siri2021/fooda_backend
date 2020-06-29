package it.vkod.fooda.basket.server.services;

import it.vkod.fooda.basket.server.models.User;

import java.math.BigInteger;

public interface UserService extends BasketService<User> {
    boolean login(final String username, final String password);
    void logout(final BigInteger userId);
}
