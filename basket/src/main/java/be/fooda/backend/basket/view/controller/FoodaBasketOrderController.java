package be.fooda.backend.basket.view.controller;

import be.fooda.backend.basket.dao.FoodaBasketOrderRepository;
import be.fooda.backend.basket.model.dto.FoodaBasketKeyDto;
import be.fooda.backend.basket.service.mapper.FoodaBasketOrderDtoMapper;
import be.fooda.backend.commons.model.template.basket.request.FoodaBasketOrderReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketOrderRes;
import be.fooda.backend.commons.service.mapper.FoodaBasketOrderHttpMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("basket/order/")
@RequiredArgsConstructor
public class FoodaBasketOrderController {

    private final FoodaBasketOrderRepository basketOrderRepo;
    private final FoodaBasketOrderDtoMapper basketOrderDtoMapper;
    private final FoodaBasketOrderHttpMapper basketOrderHttpMapper;

    @GetMapping("apiBasketGetOrderById")
    public ResponseEntity<FoodaBasketOrderRes> apiBasketGetOrderById(@RequestParam final Long orderId) {
        return basketOrderRepo
                .findById(orderId)
                .map(basketOrderDtoMapper::dtoToResponse)
                .map(res -> new ResponseEntity<>(res, HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("getAllByUserId")
    public ResponseEntity<List<FoodaBasketOrderRes>> apiBasketGetOrdersByUser(@RequestBody final FoodaBasketKeyDto key) {
        return new ResponseEntity<>(basketOrderRepo
                .findAllByBasketKey(key)
                .stream()
                .map(basketOrderDtoMapper::dtoToResponse)
                .collect(Collectors.toList()), HttpStatus.FOUND);
    }

    @PostMapping("add")
    public ResponseEntity<FoodaBasketOrderRes> apiBasketAddOrder(@RequestBody final FoodaBasketOrderReq order) {
        return basketOrderRepo.exists(Example.of(basketOrderDtoMapper.requestToDto(order)))
                ? new ResponseEntity<>
                (basketOrderDtoMapper.dtoToResponse(
                        basketOrderRepo.save(
                                basketOrderDtoMapper.requestToDto(order))), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.valueOf("ORDER_ALREADY_EXISTS"));
    }

    @PutMapping("edit/{orderId}")
    public ResponseEntity<FoodaBasketOrderRes> apiBasketEditOrder(@RequestBody final FoodaBasketOrderReq order, @PathVariable final Long orderId) {
        ResponseEntity<FoodaBasketOrderRes> result = basketOrderRepo
                .findById(orderId)
                .map(basketOrderDtoMapper::dtoToResponse)
                .map(res -> new ResponseEntity<>(basketOrderHttpMapper
                        .requestToResponse(order)
                        .toBuilder()
                        .basketOrderId(orderId)
                        .build()
                        , HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

        if (result.getStatusCode().equals(HttpStatus.FOUND)) {
            basketOrderRepo.save(basketOrderDtoMapper.responseToDto(result.getBody()));
        }
        return result;
    }

    @DeleteMapping("deleteByAddressId")
    public void apiBasketDeleteOrder(@RequestParam final Long orderId) {
        basketOrderRepo.deleteById(orderId);
    }

    @DeleteMapping("delete")
    public void apiBasketDeleteOrder(@RequestBody final FoodaBasketOrderReq order) {
        basketOrderRepo.delete(basketOrderDtoMapper.requestToDto(order));
    }
}
