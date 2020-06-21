package it.vkod.fooda.store.server.controllers;

import it.vkod.fooda.store.server.models.store.request.FoodaStore;
import it.vkod.fooda.store.server.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/store")
public class StoreController {

    @Autowired
    private StoreRepository repository;

    @PostMapping("/add")
    public void addStore(@RequestBody final FoodaStore store) {
        repository.save(store);
    }

    @PostMapping("/add/list")
    public void addStoreList(@RequestBody final List<FoodaStore> stores) {
        stores.forEach(this::addStore);
    }

    @PutMapping("/upt/{id}")
    public void updateStore(@RequestBody final FoodaStore store, @PathVariable("id") final Long id) {
        if (repository.existsById(id)) repository.save(store);
    }

    @DeleteMapping("/del/{id}")
    public void deleteStore(@PathVariable("id") final Long id) {
        if (repository.existsById(id)) repository.deleteById(id);
    }

    @GetMapping("/get")
    public List<FoodaStore> getStoreList() {
        return repository.findAll();
    }

    @GetMapping("/get/id/{id}")
    public FoodaStore getStore(@PathVariable("id") final Long id) {
        return repository.findById(id).orElse(new FoodaStore().empty());
    }

}
