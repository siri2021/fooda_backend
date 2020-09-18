package be.fooda.backend.basket.view.controller;

import be.fooda.backend.basket.dao.FoodaBasketPaymentRepository;
import be.fooda.backend.basket.model.dto.FoodaBasketKeyDto;
import be.fooda.backend.basket.service.mapper.FoodaBasketPaymentDtoMapper;
import be.fooda.backend.commons.model.template.basket.request.FoodaBasketPaymentReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketPaymentRes;
import be.fooda.backend.commons.service.mapper.FoodaBasketPaymentHttpMapper;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("basket/payment/")
@RequiredArgsConstructor
public class FoodaBasketPaymentController {

    private final FoodaBasketPaymentRepository basketPaymentRepo;
    private final FoodaBasketPaymentDtoMapper basketPaymentDtoMapper;
    private final FoodaBasketPaymentHttpMapper basketPaymentHttpMapper;

    @GetMapping("apiBasketGetPaymentById")
    public ResponseEntity<FoodaBasketPaymentRes> apiBasketGetPaymentById(@RequestParam final String paymentId) {
        return basketPaymentRepo
                .findById(new ObjectId(paymentId))
                .map(basketPaymentDtoMapper::dtoToResponse)
                .map(res -> new ResponseEntity<>(res, HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("getAllByUserId")
    public ResponseEntity<List<FoodaBasketPaymentRes>> apiBasketGetPaymentsByUser(@RequestBody final FoodaBasketKeyDto key) {
        return new ResponseEntity<>(basketPaymentRepo
                .findAllByBasketKey(key)
                .stream()
                .map(basketPaymentDtoMapper::dtoToResponse)
                .collect(Collectors.toList()), HttpStatus.FOUND);
    }

    @PostMapping("add")
    public ResponseEntity<FoodaBasketPaymentRes> apiBasketAddPayment(@RequestBody final FoodaBasketPaymentReq payment) {
        return !basketPaymentRepo.exists(Example.of(basketPaymentDtoMapper.requestToDto(payment)))
                ? new ResponseEntity<>
                (basketPaymentDtoMapper.dtoToResponse(
                        basketPaymentRepo.save(
                                basketPaymentDtoMapper.requestToDto(payment))), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.valueOf("ADDRESS_ALREADY_EXISTS"));
    }

    @PutMapping("edit/{paymentId}")
    public ResponseEntity<FoodaBasketPaymentRes> apiBasketEditPayment(@RequestBody final FoodaBasketPaymentReq payment, @PathVariable final String paymentId) {
        ResponseEntity<FoodaBasketPaymentRes> result = basketPaymentRepo
                .findById(new ObjectId(paymentId))
                .map(basketPaymentDtoMapper::dtoToResponse)
                .map(res -> new ResponseEntity<>(basketPaymentHttpMapper
                        .requestToResponse(payment)
                        .toBuilder()
                        .basketPaymentId(paymentId)
                        .build()
                        , HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

        if (result.getStatusCode().equals(HttpStatus.FOUND)) {
            basketPaymentRepo.save(basketPaymentDtoMapper.responseToDto(Objects.requireNonNull(result.getBody())));
        }
        return result;
    }

    @DeleteMapping("deleteByAddressId")
    public void apiBasketDeletePayment(@RequestParam final String paymentId) {
        basketPaymentRepo.deleteById(new ObjectId(paymentId));
    }

    @DeleteMapping("delete")
    public void apiBasketDeletePayment(@RequestBody final FoodaBasketPaymentReq payment) {
        basketPaymentRepo.delete(basketPaymentDtoMapper.requestToDto(payment));
    }
}
