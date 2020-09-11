package be.fooda.backend.basket.view.controller;

import be.fooda.backend.basket.dao.FoodaBasketProductRepository;
import be.fooda.backend.basket.service.mapper.FoodaBasketProductDtoMapper;
import be.fooda.backend.commons.model.template.basket.request.FoodaBasketProductReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketProductRes;
import be.fooda.backend.commons.service.mapper.FoodaBasketProductHttpMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("basket/product/")
@RequiredArgsConstructor
public class FoodaBasketProductController {

    private final FoodaBasketProductRepository basketProductRepo;
    private final FoodaBasketProductDtoMapper basketProductDtoMapper;
    private final FoodaBasketProductHttpMapper basketProductHttpMapper;

    @GetMapping("apiBasketGetProductById")
    public ResponseEntity<FoodaBasketProductRes> apiBasketGetProductById(@RequestParam final Long productId) {
        return basketProductRepo
                .findById(productId)
                .map(basketProductDtoMapper::dtoToResponse)
                .map(res -> new ResponseEntity<>(res, HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("getAllByUserId")
    public ResponseEntity<List<FoodaBasketProductRes>> apiBasketGetProductsByUser(@RequestParam final Long userId) {
        return new ResponseEntity<>(basketProductRepo
                .findAllByUserId(userId)
                .stream()
                .map(basketProductDtoMapper::dtoToResponse)
                .collect(Collectors.toList()), HttpStatus.FOUND);
    }

    @PostMapping("add")
    public ResponseEntity<FoodaBasketProductRes> apiBasketAddProduct(@RequestBody final FoodaBasketProductReq product) {
        return basketProductRepo.exists(Example.of(basketProductDtoMapper.requestToDto(product)))
                ? new ResponseEntity<>
                (basketProductDtoMapper.dtoToResponse(
                        basketProductRepo.save(
                                basketProductDtoMapper.requestToDto(product))), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.valueOf("ADDRESS_ALREADY_EXISTS"));
    }

    @PutMapping("edit/{productId}")
    public ResponseEntity<FoodaBasketProductRes> apiBasketEditProduct(@RequestBody final FoodaBasketProductReq product, @PathVariable final Long productId) {
        ResponseEntity<FoodaBasketProductRes> result = basketProductRepo
                .findById(productId)
                .map(basketProductDtoMapper::dtoToResponse)
                .map(res -> new ResponseEntity<>(basketProductHttpMapper
                        .requestToResponse(product)
                        .toBuilder()
                        .basketProductId(productId)
                        .build()
                        , HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

        if (result.getStatusCode().equals(HttpStatus.FOUND)) {
            basketProductRepo.save(basketProductDtoMapper.responseToDto(result.getBody()));
        }
        return result;
    }

    @DeleteMapping("deleteByProductId")
    public void apiBasketDeleteProduct(@RequestParam final Long productId) {
        basketProductRepo.deleteById(productId);
    }

    @DeleteMapping("delete")
    public void apiBasketDeleteProduct(@RequestBody final FoodaBasketProductReq product) {
        basketProductRepo.delete(basketProductDtoMapper.requestToDto(product));
    }
}
