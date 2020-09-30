package be.fooda.backend.basket.view.controller;

import be.fooda.backend.basket.service.FoodaBasketOrderService;
import be.fooda.backend.commons.model.template.basket.request.FoodaBasketOrderReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketOrderRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("basket/order/")
@RequiredArgsConstructor
public class FoodaBasketOrderController {

    private final FoodaBasketOrderService<FoodaBasketOrderReq, FoodaBasketOrderRes> basketOrderService;

    @GetMapping("apiBasketGetOrderById")
    public ResponseEntity<FoodaBasketOrderRes> apiBasketGetOrderById(@RequestParam final String deliveryId) {
        return basketOrderService.getBasketOrderById(deliveryId)
                .map(res -> new ResponseEntity<>(res, HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("apiBasketGetOrdersByBasketKey")
    public ResponseEntity<List<FoodaBasketOrderRes>> apiBasketGetOrdersByBasketKey(@RequestParam final Long userId, @RequestParam final String session, @RequestParam final Long storeId) {
        return new ResponseEntity<>(basketOrderService.getBasketDeliveriesByBasketKey(userId, session, storeId), HttpStatus.FOUND);
    }

    @GetMapping("apiBasketGetOrdersByUser")
    public ResponseEntity<List<FoodaBasketOrderRes>> apiBasketGetOrdersByUser(@RequestParam final Long userId, @RequestParam final String session) {
        return new ResponseEntity<>(basketOrderService.getBasketDeliveriesByUser(userId, session), HttpStatus.FOUND);
    }

    @PostMapping("apiBasketAddOrder")
    public ResponseEntity<FoodaBasketOrderRes> apiBasketAddOrder(@RequestBody final FoodaBasketOrderReq req) {
        return basketOrderService.doesBasketOrderExistByExample(req).equals(Boolean.FALSE)
                ? new ResponseEntity<>(basketOrderService.addBasketOrderAndReturn(req), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.valueOf("ADDRESS_ALREADY_EXISTS"));
    }

    @PutMapping("apiBasketEditOrder")
    public ResponseEntity<FoodaBasketOrderRes> apiBasketEditOrder(@RequestBody final FoodaBasketOrderReq req, @RequestParam final String basketOrderId) {
        return basketOrderService.editBasketOrderByIdAndReturn(basketOrderId, req)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("apiBasketDeleteOrderById")
    public ResponseEntity<FoodaBasketOrderRes> apiBasketDeleteOrder(@RequestParam final String basketOrderId) {
        return basketOrderService.removeBasketOrderByIdAndReturn(basketOrderId)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("apiBasketDeleteOrderByExample")
    public ResponseEntity<FoodaBasketOrderRes> apiBasketDeleteOrder(@RequestBody final FoodaBasketOrderReq req) {
        return basketOrderService.removeBasketOrderByExampleAndReturn(req)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
