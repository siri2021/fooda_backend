package be.fooda.backend.store.view.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.fooda.backend.commons.dao.repo.FoodaStoreRepository;
import be.fooda.backend.commons.model.template.store.dto.FoodaStoreDto;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/store")
@RequiredArgsConstructor
public class FoodaStoreController {

    private final FoodaStoreRepository repo;

    @GetMapping("/{id}")
    private Optional<FoodaStoreResponse> apiGetStoreById(@PathVariable final Long id) {
        Optional<FoodaStoreDto> oStoreDto = repo.findById(id);
        oStoreDto.ifPresentOrElse(oStoreDto -> {
                
        }, () -> {

        });
    }

    @GetMapping
    private List<FoodaStoreResponse> apiGetAllStores() {
        return null;
    }
}