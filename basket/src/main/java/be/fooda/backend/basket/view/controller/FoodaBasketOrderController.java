package be.fooda.backend.basket.view.controller;

import be.fooda.backend.basket.dao.FoodaBasketOrderRepository;
import be.fooda.backend.basket.model.dto.FoodaBasketKeyDto;
import be.fooda.backend.basket.service.mapper.FoodaBasketOrderDtoMapper;
import be.fooda.backend.commons.model.template.basket.request.FoodaBasketOrderReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketOrderRes;
import be.fooda.backend.commons.service.mapper.FoodaBasketOrderHttpMapper;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("basket/order/")
@RequiredArgsConstructor
public class FoodaBasketOrderController {

    private final FoodaBasketOrderRepository basketOrderRepo;
    private final FoodaBasketOrderDtoMapper basketOrderDtoMapper;
    private final FoodaBasketOrderHttpMapper basketOrderHttpMapper;

    @GetMapping("apiBasketGetOrderById")
    public ResponseEntity<FoodaBasketOrderRes> apiBasketGetOrderById(@RequestParam final String orderId) {
        return getBasketOrderById(orderId)
                .map(res -> new ResponseEntity<>(res, HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    private Optional<FoodaBasketOrderRes> getBasketOrderById(@RequestParam String orderId) {
        return basketOrderRepo
                .findById(new ObjectId(orderId))
                .map(basketOrderDtoMapper::dtoToResponse);
    }

    @GetMapping("getBasketOrdersByBasketKey")
    public ResponseEntity<List<FoodaBasketOrderRes>> apiBasketGetOrdersByBasketKey(@RequestParam final Long userId, @RequestParam final String session, @RequestParam final Long storeId) {
        return new ResponseEntity<>(getBasketOrdersByBasketKey(FoodaBasketKeyDto.builder()
                .userId(userId)
                .session(session)
                .storeId(storeId)
                .build()), HttpStatus.FOUND);
    }

    private List<FoodaBasketOrderRes> getBasketOrdersByBasketKey(FoodaBasketKeyDto key) {
        return basketOrderRepo
                .findAllByBasketKey(key)
                .stream()
                .map(basketOrderDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("apiBasketGetOrdersByUser")
    public ResponseEntity<List<FoodaBasketOrderRes>> apiBasketGetOrdersByUser(@RequestParam final Long userId, @RequestParam final String session) {
        return new ResponseEntity<>(getBasketOrdersByUser(userId, session), HttpStatus.FOUND);
    }

    private List<FoodaBasketOrderRes> getBasketOrdersByUser(final Long userId, final String session) {
        return basketOrderRepo
                .findAllByBasketKey_UserIdAndBasketKey_Session(userId, session)
                .stream()
                .map(basketOrderDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @PostMapping("apiBasketAddOrder")
    public ResponseEntity<FoodaBasketOrderRes> apiBasketAddOrder(@RequestBody final FoodaBasketOrderReq order) {
        return !basketOrderRepo.exists(Example.of(basketOrderDtoMapper.requestToDto(order)))
                ? new ResponseEntity<>
                (basketOrderDtoMapper.dtoToResponse(
                        basketOrderRepo.save(
                                basketOrderDtoMapper.requestToDto(order))), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.valueOf("ORDER_ALREADY_EXISTS"));
    }

    @PutMapping("apiBasketEditOrder/{orderId}")
    public ResponseEntity<FoodaBasketOrderRes> apiBasketEditOrder(@RequestBody final FoodaBasketOrderReq order, @PathVariable final String orderId) {
        ResponseEntity<FoodaBasketOrderRes> result = getBasketOrderById(orderId)
                .map(res -> new ResponseEntity<>(basketOrderHttpMapper
                        .requestToResponse(order)
                        .toBuilder()
                        .basketOrderId(orderId)
                        .build()
                        , HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

        if (result.getStatusCode().equals(HttpStatus.FOUND)) {
            basketOrderRepo.save(basketOrderDtoMapper.responseToDto(Objects.requireNonNull(result.getBody())));
        }
        return result;
    }

    @DeleteMapping("apiBasketDeleteOrderById")
    public void apiBasketDeleteOrder(@RequestParam final String orderId) {
        basketOrderRepo.deleteById(new ObjectId(orderId));
    }

    @DeleteMapping("apiBasketDeleteOrder")
    public void apiBasketDeleteOrder(@RequestBody final FoodaBasketOrderReq order) {
        basketOrderRepo.delete(basketOrderDtoMapper.requestToDto(order));
    }
}
