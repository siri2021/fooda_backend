package be.fooda.backend.store.view.controller;

import be.fooda.backend.commons.dao.repo.FoodaStoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
@RequiredArgsConstructor
public class FoodaStoreController {

    private final FoodaStoreRepository repo;


}