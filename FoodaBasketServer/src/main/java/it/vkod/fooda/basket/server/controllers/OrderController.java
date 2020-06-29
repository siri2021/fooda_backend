package it.vkod.fooda.basket.server.controllers;

import it.vkod.fooda.basket.server.models.Order;
import it.vkod.fooda.basket.server.services.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;


@RestController
@RequestMapping("basket/order/")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("{orderId}")
    public Order getOrder(@PathVariable final BigInteger contactId) {
        return orderService.get(contactId).orElse(null);
    }

    @GetMapping("{userId}/page/{page}")
    public Page<Order> getOrdersByUser(@PathVariable final BigInteger userId, @PathVariable final int page) {
        return orderService.get(userId, PageRequest.of(page, 10));
    }

    @PostMapping
    public void addOrder(@RequestBody final Order order) {
        orderService.add(order);
    }

    @PutMapping("{orderId}")
    public void editOrder(@RequestBody final Order order, @PathVariable final BigInteger orderId) {
        if (orderService.exists(orderId).equals(true))
            orderService.edit(order, orderId);
    }

    @DeleteMapping("{orderId}")
    public void deleteOrder(@PathVariable final BigInteger orderId) {
        orderService.delete(orderId);
    }

    @DeleteMapping
    public void deleteOrder(@RequestBody final Order order) {
        orderService.delete(order);
    }

}
