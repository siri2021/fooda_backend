package be.fooda.backend.order.view.controller;

import be.fooda.backend.commons.model.template.order.request.FoodaOrderReq;
import be.fooda.backend.commons.model.template.order.response.FoodaOrderRes;
import be.fooda.backend.order.service.FoodaOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class FoodaOrderController {

    private final FoodaOrderService<FoodaOrderReq, FoodaOrderRes> orderService;

    @GetMapping("apiOrderGetOrderByOrderKey")
    public ResponseEntity<FoodaOrderRes> apiOrderGetOrderByKey(@RequestParam final Long orderKeyId){
        return orderService.getOrderByKey(orderKeyId)
                           .map(res -> new ResponseEntity<>(res, HttpStatus.FOUND))
                           .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("apiOrderGetOrderByKey")
    public ResponseEntity<FoodaOrderRes> apiOrderGetOrderByKey(@RequestParam Long externalOrderId,@RequestParam Long userID,@RequestParam Long storeId){
        return orderService.getOrderByKey(externalOrderId, userID, storeId)
                .map(res -> new ResponseEntity<>(res, HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("apiGetOrderByExample")
    public ResponseEntity<FoodaOrderRes> apiGetOrderByExample(@RequestBody final FoodaOrderReq orderReq){
        return orderService.getOrderByExample(orderReq)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping("apiGetAllOrders")
    public ResponseEntity<List<FoodaOrderRes>> apiGetAllOrders(){
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.FOUND);
    }

    @RequestMapping("apiGetOrdersByStatusId")
    public ResponseEntity<List<FoodaOrderRes>> apiGetOrdersByStatusId(@RequestParam Long statusId){
        return new ResponseEntity<>(orderService.getOrdersByStatusId(statusId), HttpStatus.FOUND);
    }

    @RequestMapping("apiGetOrdersByDeliveryTime")
    public ResponseEntity<List<FoodaOrderRes>> apiGetOrdersByDeliveryTime(@RequestParam LocalDateTime deliveryTime){
        return new ResponseEntity<>(orderService.getOrdersByDeliveryTime(deliveryTime), HttpStatus.FOUND);
    }

    @RequestMapping("apiGetOrdersByPaymentTime")
    public ResponseEntity<List<FoodaOrderRes>> apiGetOrdersByPaymentTime(@RequestParam LocalDateTime paymentTime){
        return new ResponseEntity<>(orderService.getOrdersByPaymentTime(paymentTime), HttpStatus.FOUND);
    }

    @RequestMapping("apiGetOrdersByPaymentId")
    public ResponseEntity<List<FoodaOrderRes>> apiGetOrdersByPaymentId(@RequestParam Long paymentId){
        return new ResponseEntity<>(orderService.getOrdersByPaymentId(paymentId), HttpStatus.FOUND);
    }

    @RequestMapping("apiGetOrdersByPaymentAmount")
    public ResponseEntity<List<FoodaOrderRes>> apiGetOrdersByPaymentAmount(@RequestParam BigDecimal amount){
        return new ResponseEntity<>(orderService.getOrdersByPaymentAmount(amount), HttpStatus.FOUND);
    }

    @RequestMapping("apiGetOrdersByStoreId")
    public ResponseEntity<List<FoodaOrderRes>> apiGetOrdersByStoreId(@RequestParam Long storeId){
        return new ResponseEntity<>(orderService.getOrdersByStoreId(storeId), HttpStatus.FOUND);
    }

    @RequestMapping("apiGetOrdersByUserId")
    public ResponseEntity<List<FoodaOrderRes>> apiGetOrdersByUserId(@RequestParam Long userId){
        return new ResponseEntity<>(orderService.getOrdersByUserId(userId), HttpStatus.FOUND);
    }

    @RequestMapping("apiGetOrdersByProductKey")
    public ResponseEntity<List<FoodaOrderRes>> apiGetOrdersByProductKey(@RequestParam Long productKey){
        return new ResponseEntity<>(orderService.getOrdersByProductKey(productKey), HttpStatus.FOUND);
    }

    @PostMapping("apiOrderAddOrder")
    public ResponseEntity<FoodaOrderRes> apiOrderAddOrder(@RequestBody final FoodaOrderReq orderReq) {
        return orderService.doesOrderExistsByExample(orderReq).equals(Boolean.FALSE)
                ? new ResponseEntity<>(orderService.addOrder(orderReq).get(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.valueOf("ADDRESS_ALREADY_EXISTS"));
    }

    @PutMapping("apiOrderEditOrderByKey")
    public ResponseEntity<FoodaOrderRes> apiOrderEditOrderByKey(@RequestParam final Long orderKeyId, @RequestBody final FoodaOrderReq orderREQ) {
        return orderService.editOrderByKey(orderKeyId, orderREQ)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("apiOrderEditOrderByKey")
    public ResponseEntity<FoodaOrderRes> apiOrderEditOrderByKey(@RequestParam Long orderKeyId, @RequestParam Long externalOrderId, @RequestParam Long userID,@RequestParam Long storeId, @RequestBody FoodaOrderReq orderREQ) {
        return orderService.editOrderByKey(orderKeyId, externalOrderId, userID, storeId, orderREQ)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("apiOrderEditOrderByExample")
    public ResponseEntity<FoodaOrderRes> apiOrderEditOrderByExample(@RequestBody final FoodaOrderReq Example) {
        return orderService.editOrderByExample(Example)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("apiOrderRemoveOrderByKey")
    public ResponseEntity<FoodaOrderRes> apiOrderRemoveOrderByKey(@RequestParam Long orderKeyId) {
        return orderService.removeOrderByKey(orderKeyId)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("apiOrderRemoveOrderByKey")
    public ResponseEntity<FoodaOrderRes> apiOrderRemoveOrderByKey(@RequestParam Long externalOrderId,@RequestParam Long userID,@RequestParam Long storeId) {
        return orderService.removeOrderByKey(externalOrderId, userID, storeId)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("apiOrderRemoveOrderByExample")
    public ResponseEntity<FoodaOrderRes> apiOrderRemoveOrderByExample(final FoodaOrderReq Example) {
        return orderService.removeOrderByExample(Example)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
