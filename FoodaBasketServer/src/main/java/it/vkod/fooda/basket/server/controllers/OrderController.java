package it.vkod.fooda.basket.server.controllers;

import it.vkod.fooda.basket.server.models.Order;
import it.vkod.fooda.basket.server.repositories.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Arrays;

@Slf4j
@RestController
@RequestMapping("api/basket/orders/")
public class OrderController {

    @Autowired
    private OrderRepository repo;

    @PostMapping("insert")
    public void apiPostInsertOrder(@NotNull @RequestBody final Order order) {
        repo.save(order);
        log.info("Order added: " + order.toString());
    }

    @DeleteMapping("delete")
    public void apiDeleteOrderOrder(@NotNull @RequestBody final Order order) {
        repo.delete(order);
    }

    @DeleteMapping("clear/{user_id}")
    public void apiClearOrdersByUserAndStore(@PathVariable("user_id") final String userId) {
        final Order[] basket = apiGetUserOrders(userId);
        Arrays.stream(basket).forEach(this::apiDeleteOrderOrder);
    }

    @DeleteMapping("clear/{user_id}/store/{store_id}")
    public void apiClearOrdersByUserAndStore(@PathVariable("user_id") final String userId, @PathVariable("user_id") final long storeId) {
        final Order[] basket = apiGetUserOrders(userId);
        Arrays.stream(basket)
                .filter(b -> b.getStoreId() == storeId)
                .forEach(this::apiDeleteOrderOrder);
    }

    @GetMapping("select/{user_id}")
    public Order[] apiGetUserOrders(@PathVariable("user_id") final String userId) {
        return repo.findAllByUserId(userId).toArray(Order[]::new);
    }
}
