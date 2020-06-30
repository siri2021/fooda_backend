package it.vkod.fooda.basket.server.services;

import it.vkod.fooda.basket.server.models.Product;

import java.math.BigInteger;

public interface ProductService extends BasketService<Product>{
    void increase(final Product product);
    void increase(final BigInteger productId);
    void decrease(final Product product);
    void decrease(final BigInteger productId);
    void clear(final BigInteger userId, final String sessionId);
}