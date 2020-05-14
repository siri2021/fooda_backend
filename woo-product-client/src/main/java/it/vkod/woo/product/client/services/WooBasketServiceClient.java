package it.vkod.woo.product.client.services;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import it.vkod.woo.product.client.payloads.basketRequest.Basket;
import it.vkod.woo.product.client.payloads.basketRequest.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Slf4j
@Service
public class WooBasketServiceClient {

    @Autowired
    private RestTemplate rest;

    @Autowired
    private EurekaClient discoveryClient;

    private String getBasketServiceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("woo-basket-service", false);
        return instance.getHomePageUrl();
    }

    public Basket[] apiGetBasketProducts(final long userId) {
        return rest.getForObject(getBasketServiceUrl() + "api/basket/products/select/" + userId, Basket[].class);
    }

    public double apiGetBasketTotalPrice(final long userId) {
        final Basket[] basket = apiGetBasketProducts(userId);
        return Arrays.stream(basket)
                .mapToDouble(b -> b.getQuantity() * b.getPrice())
                .sum();
    }

    public void apiIncreaseBasketProductQuantity(final Basket basket) {
        rest.put(getBasketServiceUrl() + "api/basket/products/increase/", basket);
    }

    public void apiDecreaseBasketProductQuantity(final Basket basket) {
        rest.put(getBasketServiceUrl() + "api/basket/products/decrease/", basket);
    }

    public void apiAddBasketProduct(final Basket basket) {
        rest.postForObject(getBasketServiceUrl() + "api/basket/products/insert/", basket, Basket.class);
    }

    public Contact[] apiGetBasketContacts(final long userId) {
        return rest.getForObject(getBasketServiceUrl() + "api/basket/contacts/select/" + userId, Contact[].class);
    }

    public void apiAddBasketContact(final Contact contact) {
        rest.postForObject(getBasketServiceUrl() + "api/basket/contacts/insert/", contact, Contact.class);
    }

}
