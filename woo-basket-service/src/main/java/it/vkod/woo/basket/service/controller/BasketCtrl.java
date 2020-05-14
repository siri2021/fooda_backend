package it.vkod.woo.basket.service.controller;

import it.vkod.woo.basket.service.payloads.Basket;
import it.vkod.woo.basket.service.repositories.BasketRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Arrays;

@Slf4j
@RestController
@RequestMapping("api/basket/products/")
public class BasketCtrl {

    @Autowired
    private BasketRepo repo;

    @PostMapping("insert")
    public void apiPostInsertProduct(@NotNull @RequestBody final Basket basket) {
        if (repo.existsByUserIdAndStoreIdAndProductId(basket.getUserId(), basket.getStoreId(), basket.getProductId())) {
            apiPutIncreaseBasketProductQuantity(basket);
        } else {
            repo.save(basket);
        }
    }

    @PutMapping("increase")
    public void apiPutIncreaseBasketProductQuantity(@NotNull @RequestBody final Basket basket) {
        final Basket existingBasket = repo.findByUserIdAndStoreIdAndProductId(basket.getUserId(), basket.getStoreId(), basket.getProductId());
        existingBasket.setQuantity(existingBasket.getQuantity() + 1);
        repo.save(existingBasket);
    }

    @PutMapping("decrease")
    public void apiPutDecreaseBasketProductQuantity(@NotNull @RequestBody final Basket basket) {
        final Basket existingBasket = repo.findByUserIdAndStoreIdAndProductId(basket.getUserId(), basket.getStoreId(), basket.getProductId());
        if (existingBasket.getQuantity() > 0) {
            existingBasket.setQuantity(existingBasket.getQuantity() - 1);
            repo.save(existingBasket);
        } else {
            apiDeleteBasketProduct(basket);
        }
    }

    @DeleteMapping("delete")
    public void apiDeleteBasketProduct(@NotNull @RequestBody final Basket basket) {
        repo.delete(basket);
    }

    @DeleteMapping("clear/{user_id}")
    public void apiClearBasketProducts(@PathVariable("user_id") final long userId) {
        final Basket[] basket = apiGetBasketProducts(userId);
        Arrays.stream(basket).forEach(this::apiDeleteBasketProduct);
    }

    @GetMapping("select/{user_id}")
    public Basket[] apiGetBasketProducts(@PathVariable("user_id") final long userId) {
        return repo.findAllByUserId(userId).toArray(Basket[]::new);
    }
}
