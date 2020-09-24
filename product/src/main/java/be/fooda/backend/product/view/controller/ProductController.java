package be.fooda.backend.product.view.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import be.fooda.backend.commons.model.template.product.request.FoodaProductReq;
import be.fooda.backend.commons.model.template.product.response.FoodaProductRes;
import be.fooda.backend.product.service.FoodaProductService;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final FoodaProductService<FoodaProductReq, FoodaProductRes> productService;

    @GetMapping("apiProductGetByProductIdAndStoreId")
    public ResponseEntity<FoodaProductRes> apiProductGetByProductIdAndStoreId(@RequestParam final Long productId,
            @RequestParam final Long storeId) {
        return productService.getProductByKey(productId, storeId)
                .map(res -> new ResponseEntity<>(res, HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("apiProductAdd")
    public ResponseEntity<FoodaProductRes> apiProductAdd(@RequestBody final FoodaProductReq productReq){
        return productService.doesProductExistsByExample(productReq).equals(Boolean.FALSE)
        ? productService.addProduct(productReq)
            .map(res -> new ResponseEntity<>(res, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.CONFLICT))
        : new ResponseEntity<>(HttpStatus.FOUND);
    }

}