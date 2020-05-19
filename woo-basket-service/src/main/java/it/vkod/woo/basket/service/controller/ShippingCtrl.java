package it.vkod.woo.basket.service.controller;

import it.vkod.woo.basket.service.payloads.Shipping;
import it.vkod.woo.basket.service.repositories.ShippingRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Arrays;

@Slf4j
@RestController
@RequestMapping("api/basket/shipping/")
public class ShippingCtrl {

    @Autowired
    private ShippingRepo repo;

    @PostMapping("insert")
    public void apiPostInsertBasketShipping(@NotNull @RequestBody final Shipping shipping) {
        if (repo.existsByFirstNameAndLastNameAndUserIdAndAddressAndPostcode(shipping.getFirstName(), shipping.getLastName(),
                shipping.getUserId(), shipping.getAddress(), shipping.getPostcode())) {

            apiPutUpdateBasketShipping(shipping);

        } else {
            repo.save(shipping);
        }
    }

    @PutMapping("update")
    public void apiPutUpdateBasketShipping(@NotNull @RequestBody Shipping shipping) {
        shipping = repo.findByFirstNameAndLastNameAndUserIdAndAddressAndPostcode(shipping.getFirstName(), shipping.getLastName(),
                shipping.getUserId(), shipping.getAddress(), shipping.getPostcode());
        repo.save(shipping);
    }

    @DeleteMapping("delete")
    public void apiDeleteBasketShipping(@NotNull @RequestBody final Shipping shipping) {
        repo.delete(shipping);
    }

    @DeleteMapping("delete/{user_id}")
    public void apiClearBasketShipping(@PathVariable("user_id") final String userId) {
        final Shipping[] shipping = apiGetShipping(userId);
        Arrays.stream(shipping).forEach(this::apiDeleteBasketShipping);
    }

    @GetMapping("select/{user_id}")
    public Shipping[] apiGetShipping(@PathVariable("user_id") final String userId) {
        return repo.findAllByUserId(userId).toArray(Shipping[]::new);
    }
}
