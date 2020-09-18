package be.fooda.backend.basket.view.controller;

import be.fooda.backend.basket.dao.FoodaBasketProductRepository;
import be.fooda.backend.basket.model.dto.FoodaBasketKeyDto;
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

@RestController //API
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

    @GetMapping("apiBasketGetProductsByUser")
    public ResponseEntity<List<FoodaBasketProductRes>> apiBasketGetProductsByUser(@RequestBody final FoodaBasketKeyDto key) {
        return new ResponseEntity<>(basketProductRepo
                .findAllByBasketKey(key)
                .stream()
                .map(basketProductDtoMapper::dtoToResponse)
                .collect(Collectors.toList()), HttpStatus.FOUND);
    }

    @PostMapping("apiBasketAddProduct")
    public ResponseEntity<FoodaBasketProductRes> apiBasketAddProduct(@RequestBody final FoodaBasketProductReq product) {
        return !basketProductRepo.exists(Example.of(basketProductDtoMapper.requestToDto(product)))
                ? new ResponseEntity<>
                (basketProductDtoMapper.dtoToResponse(
                        basketProductRepo.save(
                                basketProductDtoMapper.requestToDto(product))), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.valueOf("PRODUCT_ALREADY_EXIST..!"));
    }

    @PutMapping("apiBasketEditProduct/{basketProductId}")
    public ResponseEntity<FoodaBasketProductRes> apiBasketEditProduct(@RequestBody final FoodaBasketProductReq product, @PathVariable final Long basketProductId) {
        ResponseEntity<FoodaBasketProductRes> result = basketProductRepo
                .findById(basketProductId)
                .map(basketProductDtoMapper::dtoToResponse)
                .map(res -> new ResponseEntity<>(basketProductHttpMapper
                        .requestToResponse(product)
                        .toBuilder()
                        .basketProductId(basketProductId)
                        .build()
                        , HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

        if (result.getStatusCode().equals(HttpStatus.FOUND)) {
            basketProductRepo.save(basketProductDtoMapper.responseToDto(result.getBody()));
        }
        return result;
    }

    @DeleteMapping("apiBasketDeleteProductById")
    public void apiBasketDeleteProductById(@RequestParam final Long productId) {
        basketProductRepo.deleteById(productId);
    }

    @DeleteMapping("apiBasketDeleteProduct")
    public void apiBasketDeleteProduct(@RequestBody final FoodaBasketProductReq product) {
        basketProductRepo.delete(basketProductDtoMapper.requestToDto(product));
    }
}
