package be.fooda.backend.product.view.controller;

import be.fooda.backend.commons.model.template.product.request.FoodaProductReq;
import be.fooda.backend.commons.model.template.product.response.FoodaProductRes;
import be.fooda.backend.product.service.FoodaProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("product")
public class FoodaProductController {

    @Autowired
    private FoodaProductService<FoodaProductReq, FoodaProductRes> productService;

    @GetMapping("apiGetProductById")
    public ResponseEntity<FoodaProductRes> apiGetProductById(@RequestParam final Long productId) {
        return productService.getById(productId).map(res -> new ResponseEntity<>(res, HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("apiGetProductById")
    public ResponseEntity<FoodaProductRes> apiGetProductById(@RequestParam final Long externalProductId,
            @RequestParam final Long storeId) {
        return productService.getById(externalProductId, storeId)
                .map(res -> new ResponseEntity<>(res, HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("apiGetProductByStoreId")
    public ResponseEntity<List<FoodaProductRes>> apiGetProductByStoreId(@RequestParam final Long storeId) {
        return new ResponseEntity<>(productService.getByStoreId(storeId), HttpStatus.FOUND);

    }

    @GetMapping("apiGetProductByExample")
    public ResponseEntity<FoodaProductRes> apiGetProductByExample(@RequestBody final FoodaProductReq productReq) {
        return productService.getByExample(productReq).map(res -> new ResponseEntity<>(res, HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("apiGetAllProducts")
    public ResponseEntity<List<FoodaProductRes>> apiGetAllProducts() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.FOUND);
    }

    @GetMapping("apiGetProductByName")
    public ResponseEntity<List<FoodaProductRes>> apiGetProductByName(@RequestParam final String productName) {
        return new ResponseEntity<>(productService.getByName(productName), HttpStatus.FOUND);
    }

    @GetMapping("apiGetProductsByFeatured")
    public ResponseEntity<List<FoodaProductRes>> apiGetProductsByFeatured() {
        return new ResponseEntity<>(productService.getByFeatured(), HttpStatus.FOUND);
    }

    @GetMapping("apiGetProductsByDescription")
    public ResponseEntity<List<FoodaProductRes>> apiGetProductsByDescription(
            @RequestParam final String productDescription) {
        return new ResponseEntity<>(productService.getByDescription(productDescription), HttpStatus.FOUND);
    }

    @GetMapping("apiGetProductsByTypeId")
    public ResponseEntity<List<FoodaProductRes>> apiGetProductsByTypeId(@RequestParam final Long productTypeId) {
        return new ResponseEntity<>(productService.getByTypeId(productTypeId), HttpStatus.FOUND);
    }

    @GetMapping("apiGetProductsByPriceRange")
    public ResponseEntity<List<FoodaProductRes>> apiGetProductsByPriceRange(@RequestParam final BigDecimal minPrice,
            @RequestParam final BigDecimal maxPrice) {
        return new ResponseEntity<>(productService.getByPriceRange(minPrice, maxPrice), HttpStatus.FOUND);
    }

    @GetMapping("apiGetProductsByPriceId")
    public ResponseEntity<List<FoodaProductRes>> apiGetProductsByPriceId(@RequestParam final Long productPriceId) {
        return new ResponseEntity<>(productService.getByPriceId(productPriceId), HttpStatus.FOUND);
    }

    @GetMapping("apiGetProductsByPriceIdAndExpiryDate")
    public ResponseEntity<List<FoodaProductRes>> apiGetProductsByPriceIdAndExpiryDate(
            @RequestParam final Long productPriceId, @RequestParam final LocalDate expiryDate) {
        return new ResponseEntity<>(productService.getByExpiryDate(productPriceId, expiryDate), HttpStatus.FOUND);
    }

    @GetMapping("apiGetProductsByCategoryId")
    public ResponseEntity<List<FoodaProductRes>> apiGetProductsByCategoryId(@RequestParam final Long categoryId) {
        return new ResponseEntity<>(productService.getByCategoryId(categoryId), HttpStatus.FOUND);
    }

    @GetMapping("apiGetProductsByCategories")
    public ResponseEntity<List<FoodaProductRes>> apiGetProductsByCategories(@RequestParam final Set<Long> categories) {
        return new ResponseEntity<>(productService.getByCategories(categories), HttpStatus.FOUND);
    }

    @GetMapping("apiGetProductsByTags")
    public ResponseEntity<List<FoodaProductRes>> apiGetProductsByTags(@RequestParam final Set<String> tags) {
        return new ResponseEntity<>(productService.getByTags(tags), HttpStatus.FOUND);
    }

    @PostMapping("apiAddProduct")
    public ResponseEntity<FoodaProductRes> apiAddProduct(@RequestBody final FoodaProductReq req) {
        return productService.existsByExample(req).equals(Boolean.FALSE) ? productService.add(req)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.CONFLICT))
                : new ResponseEntity<>(HttpStatus.FOUND);
    }

    @PutMapping("apiEditProductById")
    public ResponseEntity<FoodaProductRes> apiEditProductById(@RequestParam final Long productId,
            @RequestBody final FoodaProductReq req) {
        return productService.editById(productId, req).map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("apiEditProductByExample")
    public ResponseEntity<FoodaProductRes> apiEditProductByExample(@RequestBody final FoodaProductReq req) {
        return productService.editByExample(req).map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("apiDeleteProductById")
    public ResponseEntity<FoodaProductRes> apiDeleteProductById(@RequestParam final Long externalProductId,
            @RequestParam final Long storeId) {
        return productService.removeById(externalProductId, storeId)
                .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("apiDeleteProductByStoreId")
    public ResponseEntity<FoodaProductRes> apiDeleteProductByStoreId(@RequestParam final Long storeId) {
        return productService.removeByStoreId(storeId).map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("apiDeleteProductByExample")
    public ResponseEntity<FoodaProductRes> apiDeleteProductByExample(@RequestBody FoodaProductReq productReq) {
        return productService.removeByExample(productReq).map(res -> new ResponseEntity<>(res, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}