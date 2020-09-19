package be.fooda.backend.basket.view.controller;

import be.fooda.backend.basket.dao.FoodaBasketDeliveryRepository;
import be.fooda.backend.basket.model.dto.FoodaBasketKeyDto;
import be.fooda.backend.basket.service.mapper.FoodaBasketDeliveryDtoMapper;
import be.fooda.backend.commons.model.template.basket.request.FoodaBasketDeliveryReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketDeliveryRes;
import be.fooda.backend.commons.service.mapper.FoodaBasketDeliveryHttpMapper;
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
@RequestMapping("basket/delivery/")
@RequiredArgsConstructor
public class FoodaBasketDeliveryController {

    private final FoodaBasketDeliveryRepository basketDeliveryRepo;
    private final FoodaBasketDeliveryDtoMapper basketDeliveryDtoMapper;
    private final FoodaBasketDeliveryHttpMapper basketDeliveryHttpMapper;

    @GetMapping("apiBasketGetDeliveryById")
    public ResponseEntity<FoodaBasketDeliveryRes> apiBasketGetDeliveryById(@RequestParam final String deliveryId) {
        return getBasketDeliveryById(deliveryId)
                .map(res -> new ResponseEntity<>(res, HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    private Optional<FoodaBasketDeliveryRes> getBasketDeliveryById(@RequestParam String deliveryId) {
        return basketDeliveryRepo
                .findById(new ObjectId(deliveryId))
                .map(basketDeliveryDtoMapper::dtoToResponse);
    }

    @GetMapping("apiBasketGetDeliveriesByBasketKey")
    public ResponseEntity<List<FoodaBasketDeliveryRes>> apiBasketGetDeliveriesByBasketKey(@RequestParam final Long userId, @RequestParam final String session, @RequestParam final Long storeId) {
        return new ResponseEntity<>(getAllDeliveriesByKey(FoodaBasketKeyDto.builder()
                .userId(userId)
                .session(session)
                .storeId(storeId)
                .build()
        ), HttpStatus.FOUND);
    }

    private List<FoodaBasketDeliveryRes> getAllDeliveriesByKey(final FoodaBasketKeyDto key) {
        return basketDeliveryRepo
                .findAllByBasketKey(key)
                .stream()
                .map(basketDeliveryDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("apiBasketGetDeliveriesByUser")
    public ResponseEntity<List<FoodaBasketDeliveryRes>> apiBasketGetDeliveriesByUser(@RequestParam final Long userId, @RequestParam final String session) {
        return new ResponseEntity<>(getAllDeliveriesByUser(userId, session), HttpStatus.FOUND);
    }

    private List<FoodaBasketDeliveryRes> getAllDeliveriesByUser(final Long userId, final String session) {
        return basketDeliveryRepo
                .findAllByBasketKey_UserIdAndBasketKey_Session(userId, session)
                .stream()
                .map(basketDeliveryDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @PostMapping("add")
    public ResponseEntity<FoodaBasketDeliveryRes> apiBasketAddDelivery(@RequestBody final FoodaBasketDeliveryReq delivery) {
        return !basketDeliveryRepo.exists(Example.of(basketDeliveryDtoMapper.requestToDto(delivery)))
                ? new ResponseEntity<>(addBasketDelivery(delivery), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.valueOf("ADDRESS_ALREADY_EXISTS"));
    }

    private FoodaBasketDeliveryRes addBasketDelivery(FoodaBasketDeliveryReq delivery) {
        return basketDeliveryDtoMapper.dtoToResponse(
                basketDeliveryRepo.save(
                        basketDeliveryDtoMapper.requestToDto(delivery)));
    }

    @PutMapping("edit/{deliveryId}")
    public ResponseEntity<FoodaBasketDeliveryRes> apiBasketEditDelivery(@RequestBody final FoodaBasketDeliveryReq delivery, @PathVariable final String deliveryId) {
        ResponseEntity<FoodaBasketDeliveryRes> result = getBasketDeliveryById(deliveryId)
                .map(res -> new ResponseEntity<>(basketDeliveryHttpMapper
                        .requestToResponse(delivery)
                        .toBuilder()
                        .basketDeliveryId(deliveryId)
                        .build(), HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

        if (result.getStatusCode().equals(HttpStatus.FOUND)) {
            basketDeliveryRepo.save(basketDeliveryDtoMapper.responseToDto(Objects.requireNonNull(result.getBody())));
        }
        return result;
    }

    @DeleteMapping("deleteByAddressId")
    public void apiBasketDeleteDelivery(@RequestParam final String deliveryId) {
        basketDeliveryRepo.deleteById(new ObjectId(deliveryId));
    }

    @DeleteMapping("delete")
    public void apiBasketDeleteDelivery(@RequestBody final FoodaBasketDeliveryReq delivery) {
        basketDeliveryRepo.delete(basketDeliveryDtoMapper.requestToDto(delivery));
    }
}
