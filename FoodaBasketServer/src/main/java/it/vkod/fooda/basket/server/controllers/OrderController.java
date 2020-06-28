package it.vkod.fooda.basket.server.controllers;

import it.vkod.fooda.basket.server.models.Order;
import it.vkod.fooda.basket.server.services.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("basket/order/")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("{orderId}")
    public Order getOrder(@PathVariable final UUID id) {
        return orderService.get(id).orElse(null);
    }

    @GetMapping("{userId}")
    public Page<Order> getOrdersByUser(@PathVariable final UUID userId) {
        return orderService.getAll(userId);
    }

    @PostMapping
    public void addOrder(@RequestBody final Order order) {
        order.setId(UUID.randomUUID());
        orderService.add(order);
    }

    @PutMapping("{orderId}")
    public void editOrder(@RequestBody final Order order, @PathVariable final UUID orderId) {
        if (orderService.exists(orderId))
            orderService.edit(order, orderId);
    }

    @DeleteMapping("{orderId}")
    public void deleteOrder(@PathVariable final UUID orderId) {
        orderService.delete(orderId);
    }

    @DeleteMapping
    public void deleteOrder(@RequestBody final Order order) {
        orderService.delete(order);
    }

}
