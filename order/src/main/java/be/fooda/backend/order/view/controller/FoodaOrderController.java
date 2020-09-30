package be.fooda.backend.order.view.controller;

import be.fooda.backend.commons.model.template.order.request.FoodaOrderReq;
import be.fooda.backend.commons.model.template.order.response.FoodaOrderRes;
import be.fooda.backend.order.service.FoodaOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/order")
public class FoodaOrderController {

    @Autowired
    private FoodaOrderService<FoodaOrderReq, FoodaOrderRes> orderService;

    @GetMapping("apiOrderGetById")
    public ResponseEntity<FoodaOrderRes> apiOrderGetById(@RequestParam Long orderId) {
        return orderService.getById(orderId)
                .map(res -> new ResponseEntity<>(res, HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("apiGetOrderByExample")
    public ResponseEntity<FoodaOrderRes> apiGetOrderByExample(@RequestBody final FoodaOrderReq orderReq) {
        return orderService.getByExample(orderReq)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("apiGetAllOrders")
    public ResponseEntity<List<FoodaOrderRes>> apiGetAllOrders() {
        return new ResponseEntity<>(orderService.getAll(), HttpStatus.FOUND);
    }

    @GetMapping("apiGetOrdersByStatusId")
    public ResponseEntity<List<FoodaOrderRes>> apiGetOrdersByStatusId(@RequestParam Long statusId) {
        return new ResponseEntity<>(orderService.getByStatusId(statusId), HttpStatus.FOUND);
    }

    @GetMapping("apiGetOrdersByRequiredTime")
    public ResponseEntity<List<FoodaOrderRes>> apiGetOrdersByRequiredTime(@RequestParam LocalDateTime requiredTime) {
        return new ResponseEntity<>(orderService.getByRequiredTime(requiredTime), HttpStatus.FOUND);
    }

    @GetMapping("apiGetOrdersByDeliveryTime")
    public ResponseEntity<List<FoodaOrderRes>> apiGetOrdersByDeliveryTime(@RequestParam LocalDateTime deliveryTime) {
        return new ResponseEntity<>(orderService.getByDeliveryTime(deliveryTime), HttpStatus.FOUND);
    }

    @GetMapping("apiGetOrdersByPaymentTime")
    public ResponseEntity<List<FoodaOrderRes>> apiGetOrdersByPaymentTime(@RequestParam LocalDateTime paymentTime) {
        return new ResponseEntity<>(orderService.getByPaymentTime(paymentTime), HttpStatus.FOUND);
    }

    @GetMapping("apiGetOrdersByPaymentId")
    public ResponseEntity<List<FoodaOrderRes>> apiGetOrdersByPaymentId(@RequestParam Long userId, @RequestParam Long paymentId) {
        return new ResponseEntity<>(orderService.getByPaymentId(userId, paymentId), HttpStatus.FOUND);
    }

    @GetMapping("apiGetOrdersByPaymentAmountByMin")
    public ResponseEntity<List<FoodaOrderRes>> apiGetOrdersByPaymentAmount(@RequestParam BigDecimal amount) {
        return new ResponseEntity<>(orderService.getByPaymentAmount(amount), HttpStatus.FOUND);
    }

    @GetMapping("apiGetOrdersByPaymentAmountByRange")
    public ResponseEntity<List<FoodaOrderRes>> apiGetOrdersByPaymentAmount(@RequestParam BigDecimal minAmount, @RequestParam BigDecimal maxAmount) {
        return new ResponseEntity<>(orderService.getByPaymentAmount(minAmount, maxAmount), HttpStatus.FOUND);
    }

    @GetMapping("apiGetOrdersByStoreId")
    public ResponseEntity<List<FoodaOrderRes>> apiGetOrdersByStoreId(@RequestParam Long storeId) {
        return new ResponseEntity<>(orderService.getByStoreId(storeId), HttpStatus.FOUND);
    }

    @GetMapping("apiGetOrdersByUserId")
    public ResponseEntity<List<FoodaOrderRes>> apiGetOrdersByUserId(@RequestParam Long userId) {
        return new ResponseEntity<>(orderService.getByUserId(userId), HttpStatus.FOUND);
    }

    @PostMapping("apiOrderAddOrder")
    public ResponseEntity<FoodaOrderRes> apiOrderAddOrder(@RequestBody final FoodaOrderReq orderReq) {
        return orderService.existsByExample(orderReq).equals(Boolean.FALSE)
                ? new ResponseEntity<>(orderService.add(orderReq).get(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.valueOf("ADDRESS_ALREADY_EXISTS"));
    }

    @PutMapping("apiOrderEditOrderByKey")
    public ResponseEntity<FoodaOrderRes> apiOrderEditOrderByKey(@RequestParam Long orderId, @RequestBody FoodaOrderReq orderREQ) {
        return orderService.editById(orderId, orderREQ)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("apiOrderEditOrderByExample")
    public ResponseEntity<FoodaOrderRes> apiOrderEditOrderByExample(@RequestBody final FoodaOrderReq Example) {
        return orderService.editByExample(Example)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("apiOrderRemoveByKey")
    public ResponseEntity<FoodaOrderRes> apiOrderRemoveOrderById(@RequestParam Long orderId) {
        return orderService.removeById(orderId)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("apiOrderRemoveOrderByExample")
    public ResponseEntity<FoodaOrderRes> apiOrderRemoveOrderByExample(final FoodaOrderReq Example) {
        return orderService.removeByExample(Example)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
