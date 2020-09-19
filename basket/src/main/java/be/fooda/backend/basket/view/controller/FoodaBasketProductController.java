package be.fooda.backend.basket.view.controller;

import be.fooda.backend.basket.dao.FoodaBasketProductRepository;
import be.fooda.backend.basket.model.dto.FoodaBasketKeyDto;
import be.fooda.backend.basket.service.mapper.FoodaBasketProductDtoMapper;
import be.fooda.backend.commons.model.template.basket.request.FoodaBasketProductReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketProductRes;
import be.fooda.backend.commons.service.mapper.FoodaBasketProductHttpMapper;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("basket/product/")
@RequiredArgsConstructor
public class FoodaBasketProductController {

    private final FoodaBasketProductRepository basketProductRepo;
    private final FoodaBasketProductDtoMapper basketProductDtoMapper;
    private final FoodaBasketProductHttpMapper basketProductHttpMapper;

    @GetMapping("apiBasketGetProductById")
    public ResponseEntity<FoodaBasketProductRes> apiBasketGetProductById(@RequestParam final String productId) {
        return getGetProductById(productId)
                .map(res -> new ResponseEntity<>(res, HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    private Optional<FoodaBasketProductRes> getGetProductById(@RequestParam String productId) {
        return basketProductRepo
                .findById(new ObjectId(productId))
                .map(basketProductDtoMapper::dtoToResponse);
    }

    @GetMapping("apiBasketGetProductsByUserAndStore")
    public ResponseEntity<List<FoodaBasketProductRes>> apiBasketGetProductsByUserAndStore(@RequestParam final Long userId, @RequestParam final String session, @RequestParam final Long storeId) {
        return new ResponseEntity<>(getProductsByBasketKey(FoodaBasketKeyDto.builder()
                .userId(userId)
                .storeId(storeId)
                .session(session)
                .build()), HttpStatus.FOUND);
    }

    @GetMapping("apiBasketGetProductsByUser")
    public ResponseEntity<List<FoodaBasketProductRes>> apiBasketGetProductsByUser(@RequestParam final Long userId, @RequestParam final String session) {
        return new ResponseEntity<>(getProductsByUser(userId, session), HttpStatus.FOUND);
    }

    private List<FoodaBasketProductRes> getProductsByBasketKey(FoodaBasketKeyDto key) {
        return basketProductRepo
                .findAllByKey(key)
                .stream()
                .map(basketProductDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    private List<FoodaBasketProductRes> getProductsByUser(final Long userId, final String session) {
        return basketProductRepo
                .findAllByKey_UserIdAndKey_Session(userId, session)
                .stream()
                .map(basketProductDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @PostMapping("apiBasketAddProduct")
    public ResponseEntity<FoodaBasketProductRes> apiBasketAddProduct(@RequestBody @Valid final FoodaBasketProductReq product) {
        return !basketProductRepo.exists(Example.of(basketProductDtoMapper.requestToDto(product)))
                ? new ResponseEntity<>(addBasketProductAndReturn(product), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PostMapping("apiBasketAddProductMany")
    public ResponseEntity<List<FoodaBasketProductRes>> apiBasketAddProductMany(@RequestBody final Set<FoodaBasketProductReq> productSet) {
        final List<FoodaBasketProductRes> productsAdded = productSet.stream()
                .map(this::apiBasketAddProduct)
                .collect(Collectors.toList())
                .stream()
                .filter(res -> res.getStatusCode().is2xxSuccessful() || res.getStatusCode().is3xxRedirection())
                .map(HttpEntity::getBody)
                .collect(Collectors.toList());

        if (!productsAdded.isEmpty()) {
            return new ResponseEntity<>(productsAdded, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private FoodaBasketProductRes addBasketProductAndReturn(FoodaBasketProductReq product) {
        return basketProductDtoMapper.dtoToResponse(
                basketProductRepo.save(
                        basketProductDtoMapper.requestToDto(product)));
    }

    @PutMapping("apiBasketIncreaseProductQuantity/{basketProductId}")
    public ResponseEntity<FoodaBasketProductRes> apiBasketIncreaseProductQuantity(@PathVariable final String basketProductId) {
        ResponseEntity<FoodaBasketProductRes> result = getGetProductById(basketProductId)
                .map(res -> {
                    res.increase();
                    return new ResponseEntity<>(res, HttpStatus.FOUND);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

        if (result.getStatusCode().equals(HttpStatus.FOUND)) {
            basketProductRepo.save(basketProductDtoMapper.responseToDto(Objects.requireNonNull(result.getBody())));
        }
        return result;
    }

    @PutMapping("apiBasketDecreaseProductQuantity/{basketProductId}")
    public ResponseEntity<FoodaBasketProductRes> apiBasketDecreaseProductQuantity(@PathVariable final String basketProductId) {
        ResponseEntity<FoodaBasketProductRes> result = getGetProductById(basketProductId)
                .map(res -> {
                    res.decrease();
                    return new ResponseEntity<>(res, HttpStatus.FOUND);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

        if (result.getStatusCode().equals(HttpStatus.FOUND)) {
            if (Objects.requireNonNull(result.getBody()).getQuantity() == 0)
                basketProductRepo.save(basketProductDtoMapper.responseToDto(Objects.requireNonNull(result.getBody())));
            else
                basketProductRepo.deleteById(new ObjectId(basketProductId));
        }
        return result;
    }

    @PutMapping("apiBasketEditProduct/{basketProductId}")
    public ResponseEntity<FoodaBasketProductRes> apiBasketEditProduct(@RequestBody final FoodaBasketProductReq product, @PathVariable final String basketProductId) {
        ResponseEntity<FoodaBasketProductRes> result = getGetProductById(basketProductId)
                .map(res -> new ResponseEntity<>(basketProductHttpMapper
                        .requestToResponse(product)
                        .toBuilder()
                        .basketProductId(basketProductId)
                        .build()
                        , HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

        if (result.getStatusCode().equals(HttpStatus.FOUND)) {
            basketProductRepo.save(basketProductDtoMapper.responseToDto(Objects.requireNonNull(result.getBody())));
        }
        return result;
    }

    @DeleteMapping("apiBasketDeleteProductById")
    public void apiBasketDeleteProductById(@RequestParam final String productId) {
        basketProductRepo.deleteById(new ObjectId(productId));
    }

    @DeleteMapping("apiBasketDeleteProduct")
    public void apiBasketDeleteProduct(@RequestBody final FoodaBasketProductReq product) {
        basketProductRepo.delete(basketProductDtoMapper.requestToDto(product));
    }
}
