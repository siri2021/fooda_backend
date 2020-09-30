package be.fooda.backend.store.view.controller;

import be.fooda.backend.commons.model.template.store.request.FoodaStoreReq;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreRes;
import be.fooda.backend.store.service.FoodaStoreService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
@RequiredArgsConstructor
public class FoodaStoreController {

    private final FoodaStoreService<FoodaStoreReq, FoodaStoreRes> storeService;

    @GetMapping("apiStoreGetByStoreId")
    public ResponseEntity<FoodaStoreRes> apiStoreGetByStoreId(@RequestParam final Long storeId){
        return storeService.getStoreById(storeId)
                .map(res -> new ResponseEntity<>(res, HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("apiStoreGetByStoreExample")
    public ResponseEntity<FoodaStoreRes> apiStoreGetByStoreExample(@RequestParam final FoodaStoreReq storeExample){
        return storeService.getStoreByExample(storeExample)
                .map(res -> new ResponseEntity<>(res, HttpStatus.FOUND))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



}