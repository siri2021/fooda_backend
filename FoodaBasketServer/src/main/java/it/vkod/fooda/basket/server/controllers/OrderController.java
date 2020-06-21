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
@RequestMapping("api/basket")
public class OrderController {

    @Autowired
    private OrderRepository repo;

    @PostMapping("/orders/insert")
    public void apiPostInsertOrder(@NotNull @RequestBody final Order order) {
        repo.save(order);
        log.info("Order added: " + order.toString());
    }

    @DeleteMapping("/orders/delete")
    public void apiDeleteOrderOrder(@NotNull @RequestBody final Order order) {
        repo.delete(order);
    }

    @DeleteMapping("/orders/clear/{user_id}")
    public void apiClearOrdersByUserAndStore(@PathVariable("user_id") final String userId) {
        final Order[] basket = apiGetUserOrders(userId);
        Arrays.stream(basket).forEach(this::apiDeleteOrderOrder);
    }

    @DeleteMapping("/orders/clear/{user_id}/store/{store_id}")
    public void apiClearOrdersByUserAndStore(@PathVariable("user_id") final String userId, @PathVariable("user_id") final long storeId) {
        final Order[] basket = apiGetUserOrders(userId);
        Arrays.stream(basket)
                .filter(b -> b.getStoreId() == storeId)
                .forEach(this::apiDeleteOrderOrder);
    }

    @GetMapping("/orders/select/{user_id}")
    public Order[] apiGetUserOrders(@PathVariable("user_id") final String userId) {
        return repo.findAllByUserId(userId).toArray(Order[]::new);
    }
}
