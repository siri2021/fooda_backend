package be.fooda.backend.basket.view.controller;

import be.fooda.backend.basket.service.FoodaBasketProductService;
import be.fooda.backend.commons.model.template.basket.request.FoodaBasketProductReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketProductRes;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("basket/product/")
public class FoodaBasketProductController {

    @Autowired
    private FoodaBasketProductService<FoodaBasketProductReq, FoodaBasketProductRes> basketProductService;

    @GetMapping("apiBasketGetProductById")
    public ResponseEntity<FoodaBasketProductRes> apiBasketGetProductById(@RequestParam final String basketProductId) {
        return basketProductService.getBasketProductById(basketProductId)
                .map(res -> new ResponseEntity<>(res, HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("apiBasketGetProductsByUserAndStore")
    public ResponseEntity<List<FoodaBasketProductRes>> apiBasketGetProductsByUserAndStore(
            @RequestParam final Long userId, @RequestParam final String session, @RequestParam final Long storeId) {
        return new ResponseEntity<>(basketProductService.getBasketProductsByBasketKey(userId, session, storeId),
                HttpStatus.FOUND);
    }

    @GetMapping("apiBasketGetProductsByUser")
    public ResponseEntity<List<FoodaBasketProductRes>> apiBasketGetProductsByUser(@RequestParam final Long userId,
            @RequestParam final String session) {
        return new ResponseEntity<>(basketProductService.getBasketProductsByUser(userId, session), HttpStatus.FOUND);
    }

    @PostMapping("apiBasketAddProduct")
    public ResponseEntity<FoodaBasketProductRes> apiBasketAddProduct(@RequestBody @Valid final FoodaBasketProductReq product) {
        return basketProductService.doesBasketProductExistByExample(product).equals(Boolean.FALSE)
                ? basketProductService.addBasketProductAndReturn(product)
                        .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                        .orElse(new ResponseEntity<>(HttpStatus.CONFLICT))
                : new ResponseEntity<>(HttpStatus.FOUND);
    }

    @PostMapping("apiBasketAddProductMany")
    public ResponseEntity<Set<FoodaBasketProductRes>> apiBasketAddProductMany( @RequestBody final Set<FoodaBasketProductReq> productSet) {
        final Set<FoodaBasketProductRes> productsAdded = productSet.stream().map(this::apiBasketAddProduct)
                .collect(Collectors.toList()) // List<ResponseEntity<FoodaBasketProductRes>>
                .stream().filter(res -> res.getStatusCode().is2xxSuccessful() || res.getStatusCode().is3xxRedirection())
                .map(HttpEntity::getBody).collect(Collectors.toSet());

        if (!productsAdded.isEmpty()) {
            return new ResponseEntity<>(productsAdded, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("apiBasketIncreaseProductQuantity")
    public ResponseEntity<FoodaBasketProductRes> apiBasketIncreaseProductQuantity(
            @RequestParam final String basketProductId) {
        return basketProductService.increaseBasketProductQuantityByIdAndReturn(basketProductId, 1)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("apiBasketDecreaseProductQuantity")
    public ResponseEntity<FoodaBasketProductRes> apiBasketDecreaseProductQuantity(
            @RequestParam final String basketProductId) {
        return basketProductService.decreaseBasketProductQuantityByIdAndReturn(basketProductId, 1)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("apiBasketEditProduct")
    public ResponseEntity<FoodaBasketProductRes> apiBasketEditProduct(@RequestParam final String basketProductId,
            @RequestBody final FoodaBasketProductReq req) {
        return basketProductService.editBasketProductByIdAndReturn(basketProductId, req)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("apiBasketDeleteProductById")
    public ResponseEntity<FoodaBasketProductRes> apiBasketDeleteProductById(
            @RequestParam final String basketProductId) {
        return basketProductService.removeBasketProductByIdAndReturn(basketProductId)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("apiBasketDeleteProductByExample")
    public ResponseEntity<FoodaBasketProductRes> apiBasketDeleteProductByExample(
            @RequestBody final FoodaBasketProductReq req) {
        return basketProductService.removeBasketProductByExampleAndReturn(req)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
