package be.fooda.backend.basket.view.controller;

import be.fooda.backend.basket.model.dto.FoodaBasketOrderDto;
import be.fooda.backend.basket.service.impl.FoodaBasketOrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("basket/order/")
@RequiredArgsConstructor
public class FoodaBasketOrderController {

    private final FoodaBasketOrderServiceImpl orderService;

    @GetMapping("getByOrderId")
    public FoodaBasketOrderDto getOrder(@RequestParam final Long orderId) {
        return orderService.get(orderId).orElse(null);
    }

    @GetMapping("getAllByUserId")
    public Page<FoodaBasketOrderDto> getOrdersByUser(@RequestParam final Long userId, @RequestParam final int page) {
        return orderService.get(userId, PageRequest.of(page, 10));
    }

    @PostMapping("add")
    public void addOrder(@RequestBody final FoodaBasketOrderDto order) {
        orderService.add(order);
    }

    @PutMapping("edit")
    public void editOrder(@RequestBody final FoodaBasketOrderDto order) {
        if (orderService.exists(order.getOrderId()).equals(true))
            orderService.edit(order, order.getOrderId());
    }

    @DeleteMapping("deleteByOrderId")
    public void deleteOrder(@RequestParam final Long orderId) {
        orderService.delete(orderId);
    }

    @DeleteMapping("delete")
    public void deleteOrder(@RequestBody final FoodaBasketOrderDto order) {
        orderService.delete(order);
    }

}
