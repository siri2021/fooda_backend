package be.fooda.backend.basket.view.controller;

import be.fooda.backend.basket.model.dto.FoodaBasketProductDto;
import be.fooda.backend.basket.service.impl.FoodaBasketProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("basket/product/")
@RequiredArgsConstructor
public class FoodaBasketProductController {

    private final FoodaBasketProductServiceImpl productService;

    @GetMapping("getByProductId")
    public FoodaBasketProductDto getProduct(@RequestParam final Long productId) {
        return productService.get(productId).orElse(null);
    }

    @GetMapping("getAll")
    public Page<FoodaBasketProductDto> getProducts(@RequestParam final int page) {
        return productService.get(PageRequest.of(page - 1, 10));
    }

    @GetMapping("getAllByUserId")
    public Page<FoodaBasketProductDto> getProductsByUser(@RequestParam final Long userId, @RequestParam final int page) {
        return productService.get(userId, PageRequest.of(page - 1, 10));
    }

    @PostMapping("add")
    public void addProduct(@RequestBody final FoodaBasketProductDto product) {
        productService.add(product);
    }

    @PutMapping("edit")
    public void editProduct(@RequestBody final FoodaBasketProductDto product) {
        if (productService.exists(product.getProductId()).equals(true))
            productService.edit(product, product.getProductId());
    }

    @PutMapping("increaseByProductId")
    public void increaseProductQuantity(@RequestParam final Long productId, @RequestParam final Long storeId) {
        productService.increase(productId, storeId);
    }

    @PutMapping("increase")
    public void increaseProductQuantity(@RequestBody final FoodaBasketProductDto product) {
        productService.increase(product);
    }

    @PutMapping("decreaseByProductId")
    public void decreaseProductQuantity(@RequestParam final Long productId, @RequestParam final Long storeId) {
        productService.decrease(productId, storeId);
    }

    @PutMapping("decrease")
    public void decreaseProductQuantity(@RequestBody final FoodaBasketProductDto product) {
        productService.decrease(product);
    }

    @DeleteMapping("clearByUserId")
    public void clearProducts(@RequestParam final Long userId, @RequestParam final String sessionId) {
        productService.clear(userId, sessionId);
    }

    @DeleteMapping("deleteByProductId")
    public void deleteProduct(@RequestParam final Long productId) {
        productService.delete(productId);
    }

    @DeleteMapping("delete")
    public void deleteProduct(@RequestBody final FoodaBasketProductDto product) {
        productService.delete(product);
    }

}
