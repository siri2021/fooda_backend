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

    @GetMapping("getByOrderId")
    public Order getOrder(@RequestParam final BigInteger orderId) {
        return orderService.get(orderId).orElse(null);
    }

    @GetMapping("getAllByUserId")
    public Page<Order> getOrdersByUser(@RequestParam final BigInteger userId, @RequestParam final int page) {
        return orderService.get(userId, PageRequest.of(page, 10));
    }

    @PostMapping("add")
    public void addOrder(@RequestBody final Order order) {
        orderService.add(order);
    }

    @PutMapping("edit")
    public void editOrder(@RequestBody final Order order) {
        if (orderService.exists(order.getOrderId()).equals(true))
            orderService.edit(order, order.getOrderId());
    }

    @DeleteMapping("deleteByOrderId")
    public void deleteOrder(@RequestParam final BigInteger orderId) {
        orderService.delete(orderId);
    }

    @DeleteMapping("delete")
    public void deleteOrder(@RequestBody final Order order) {
        orderService.delete(order);
    }

}
