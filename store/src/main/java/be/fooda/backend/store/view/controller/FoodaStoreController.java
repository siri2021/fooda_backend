package be.fooda.backend.store.view.controller;

import be.fooda.backend.commons.model.template.store.request.FoodaStoreReq;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreRes;
import be.fooda.backend.store.service.FoodaStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
public class FoodaStoreController {

    @Autowired
    private FoodaStoreService<FoodaStoreReq, FoodaStoreRes> storeService;

    @GetMapping("hello")
    public String hello(){
        return "Hello from Store Module.. ";
    }

}