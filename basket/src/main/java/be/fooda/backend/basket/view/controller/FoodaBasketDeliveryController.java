package be.fooda.backend.basket.view.controller;

import be.fooda.backend.basket.service.FoodaBasketDeliveryService;
import be.fooda.backend.commons.model.template.basket.request.FoodaBasketDeliveryReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketDeliveryRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("basket/delivery/")
@RequiredArgsConstructor
public class FoodaBasketDeliveryController {

    private final FoodaBasketDeliveryService<FoodaBasketDeliveryReq, FoodaBasketDeliveryRes> basketDeliveryService;

    @GetMapping("apiBasketGetDeliveryById")
    public ResponseEntity<FoodaBasketDeliveryRes> apiBasketGetDeliveryById(@RequestParam final String deliveryId) {
        return basketDeliveryService.getBasketDeliveryById(deliveryId)
                .map(res -> new ResponseEntity<>(res, HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("apiBasketGetDeliveriesByBasketKey")
    public ResponseEntity<List<FoodaBasketDeliveryRes>> apiBasketGetDeliveriesByBasketKey(@RequestParam final Long userId, @RequestParam final String session, @RequestParam final Long storeId) {
        return new ResponseEntity<>(basketDeliveryService.getBasketDeliveriesByBasketKey(userId, session, storeId), HttpStatus.FOUND);
    }

    @GetMapping("apiBasketGetDeliveriesByUser")
    public ResponseEntity<List<FoodaBasketDeliveryRes>> apiBasketGetDeliveriesByUser(@RequestParam final Long userId, @RequestParam final String session) {
        return new ResponseEntity<>(basketDeliveryService.getBasketDeliveriesByUser(userId, session), HttpStatus.FOUND);
    }

    @PostMapping("apiBasketAddDelivery")
    public ResponseEntity<FoodaBasketDeliveryRes> apiBasketAddDelivery(@RequestBody final FoodaBasketDeliveryReq req) {
        return basketDeliveryService.doesBasketDeliveryExistByExample(req).equals(Boolean.FALSE)
                ? new ResponseEntity<>(basketDeliveryService.addBasketDeliveryAndReturn(req), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.valueOf("ADDRESS_ALREADY_EXISTS"));
    }

    @PutMapping("apiBasketEditDelivery")
    public ResponseEntity<FoodaBasketDeliveryRes> apiBasketEditDelivery(@RequestBody final FoodaBasketDeliveryReq req, @RequestParam final String basketDeliveryId) {
        return basketDeliveryService.editBasketDeliveryByIdAndReturn(basketDeliveryId, req)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("apiBasketDeleteDeliveryById")
    public ResponseEntity<FoodaBasketDeliveryRes> apiBasketDeleteDelivery(@RequestParam final String basketDeliveryId) {
        return basketDeliveryService.removeBasketDeliveryByIdAndReturn(basketDeliveryId)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("apiBasketDeleteDeliveryByExample")
    public ResponseEntity<FoodaBasketDeliveryRes> apiBasketDeleteDelivery(@RequestBody final FoodaBasketDeliveryReq req) {
        return basketDeliveryService.removeBasketDeliveryByExampleAndReturn(req)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
