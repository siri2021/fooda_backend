package be.fooda.backend.basket.view.controller;

import be.fooda.backend.basket.service.FoodaBasketPaymentService;
import be.fooda.backend.commons.model.template.basket.request.FoodaBasketPaymentReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketPaymentRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("basket/payment/")
public class FoodaBasketPaymentController {

    @Autowired
    private FoodaBasketPaymentService<FoodaBasketPaymentReq, FoodaBasketPaymentRes> basketPaymentService;

    @GetMapping("apiBasketGetPaymentById")
    public ResponseEntity<FoodaBasketPaymentRes> apiBasketGetPaymentById(@RequestParam final String deliveryId) {
        return basketPaymentService.getBasketPaymentById(deliveryId)
                .map(res -> new ResponseEntity<>(res, HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("apiBasketGetPaymentsByBasketKey")
    public ResponseEntity<List<FoodaBasketPaymentRes>> apiBasketGetPaymentsByBasketKey(@RequestParam final Long userId, @RequestParam final String session, @RequestParam final Long storeId) {
        return new ResponseEntity<>(basketPaymentService.getBasketDeliveriesByBasketKey(userId, session, storeId), HttpStatus.FOUND);
    }

    @GetMapping("apiBasketGetPaymentsByUser")
    public ResponseEntity<List<FoodaBasketPaymentRes>> apiBasketGetPaymentsByUser(@RequestParam final Long userId, @RequestParam final String session) {
        return new ResponseEntity<>(basketPaymentService.getBasketDeliveriesByUser(userId, session), HttpStatus.FOUND);
    }

    @PostMapping("apiBasketAddPayment")
    public ResponseEntity<FoodaBasketPaymentRes> apiBasketAddPayment(@RequestBody final FoodaBasketPaymentReq req) {
        return basketPaymentService.doesBasketPaymentExistByExample(req).equals(Boolean.FALSE)
                ? new ResponseEntity<>(basketPaymentService.addBasketPaymentAndReturn(req), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.valueOf("ADDRESS_ALREADY_EXISTS"));
    }

    @PutMapping("apiBasketEditPayment")
    public ResponseEntity<FoodaBasketPaymentRes> apiBasketEditPayment(@RequestBody final FoodaBasketPaymentReq req, @RequestParam final String basketPaymentId) {
        return basketPaymentService.editBasketPaymentByIdAndReturn(basketPaymentId, req)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("apiBasketDeletePaymentById")
    public ResponseEntity<FoodaBasketPaymentRes> apiBasketDeletePayment(@RequestParam final String basketPaymentId) {
        return basketPaymentService.removeBasketPaymentByIdAndReturn(basketPaymentId)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("apiBasketDeletePaymentByExample")
    public ResponseEntity<FoodaBasketPaymentRes> apiBasketDeletePayment(@RequestBody final FoodaBasketPaymentReq req) {
        return basketPaymentService.removeBasketPaymentByExampleAndReturn(req)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
