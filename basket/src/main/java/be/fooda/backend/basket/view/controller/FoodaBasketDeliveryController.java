package be.fooda.backend.basket.view.controller;

import be.fooda.backend.basket.dao.FoodaBasketDeliveryRepository;
import be.fooda.backend.basket.model.dto.FoodaBasketKeyDto;
import be.fooda.backend.basket.service.mapper.FoodaBasketDeliveryDtoMapper;
import be.fooda.backend.commons.model.template.basket.request.FoodaBasketDeliveryReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketDeliveryRes;
import be.fooda.backend.commons.service.mapper.FoodaBasketDeliveryHttpMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("basket/delivery/")  // https://www.fooda.be/basket/delivery/...
@RequiredArgsConstructor
public class FoodaBasketDeliveryController {

    private final FoodaBasketDeliveryRepository basketDeliveryRepo;
    private final FoodaBasketDeliveryDtoMapper basketDeliveryDtoMapper;
    private final FoodaBasketDeliveryHttpMapper basketDeliveryHttpMapper;

    @GetMapping("apiBasketGetDeliveryById")
    public ResponseEntity<FoodaBasketDeliveryRes> apiBasketGetDeliveryById(@RequestParam final Long deliveryId) {
        return basketDeliveryRepo
                .findById(deliveryId)
                .map(basketDeliveryDtoMapper::dtoToResponse)
                .map(res -> new ResponseEntity<>(res, HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("getAllByUserId")
    public ResponseEntity<List<FoodaBasketDeliveryRes>> apiBasketGetDeliveriesByUser(@RequestBody final FoodaBasketKeyDto key) {
        return new ResponseEntity<>(basketDeliveryRepo
                .findAllByBasketKey(key)
                .stream()
                .map(basketDeliveryDtoMapper::dtoToResponse)
                .collect(Collectors.toList()), HttpStatus.FOUND);
    }

    @PostMapping("add")
    public ResponseEntity<FoodaBasketDeliveryRes> apiBasketAddDelivery(@RequestBody final FoodaBasketDeliveryReq delivery) {
        return basketDeliveryRepo.exists(Example.of(basketDeliveryDtoMapper.requestToDto(delivery)))
                ? new ResponseEntity<>
                (basketDeliveryDtoMapper.dtoToResponse(
                        basketDeliveryRepo.save(
                                basketDeliveryDtoMapper.requestToDto(delivery))), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.valueOf("ADDRESS_ALREADY_EXISTS"));
    }

    @PutMapping("edit/{deliveryId}")
    public ResponseEntity<FoodaBasketDeliveryRes> apiBasketEditDelivery(@RequestBody final FoodaBasketDeliveryReq delivery, @PathVariable final Long deliveryId) {
        ResponseEntity<FoodaBasketDeliveryRes> result = basketDeliveryRepo
                .findById(deliveryId)
                .map(basketDeliveryDtoMapper::dtoToResponse)
                .map(res -> new ResponseEntity<>(basketDeliveryHttpMapper
                        .requestToResponse(delivery)
                        .toBuilder()
                        .basketDeliveryId(deliveryId)
                        .build(), HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

        if (result.getStatusCode().equals(HttpStatus.FOUND)) {
            basketDeliveryRepo.save(basketDeliveryDtoMapper.responseToDto(result.getBody()));
        }
        return result;
    }

    @DeleteMapping("deleteByAddressId")
    public void apiBasketDeleteDelivery(@RequestParam final Long deliveryId) {
        basketDeliveryRepo.deleteById(deliveryId);
    }

    @DeleteMapping("delete")
    public void apiBasketDeleteDelivery(@RequestBody final FoodaBasketDeliveryReq delivery) {
        basketDeliveryRepo.delete(basketDeliveryDtoMapper.requestToDto(delivery));
    }
}
