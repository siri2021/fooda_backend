package it.vkod.woo.basket.service.controller;

import it.vkod.woo.basket.service.payloads.Basket;
import it.vkod.woo.basket.service.repositories.BasketRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("api/basket")
public class BasketCtrl {

    @Autowired
    private BasketRepo repo;

    @PostMapping
    public void addProduct(@NotNull @RequestBody final Basket basket) {
        if (repo.existsByUserIdAndStoreIdAndProductId(basket.getUserId(), basket.getStoreId(), basket.getProductId())) {
            final Basket existingBasket = repo.findByUserIdAndStoreIdAndProductId(basket.getUserId(), basket.getStoreId(), basket.getProductId());
            existingBasket.setQuantity(existingBasket.getQuantity() + 1);
            repo.save(existingBasket);
        } else {
            repo.save(basket);
        }
    }

    @DeleteMapping
    public void deleteProduct(@NotNull @RequestBody final Basket basket) {
        repo.delete(basket);
    }

    @GetMapping("{user_id}")
    public List<Basket> getBasket(@PathVariable("user_id") final UUID userId) {
        return repo.findAllByUserId(userId);
    }
}
