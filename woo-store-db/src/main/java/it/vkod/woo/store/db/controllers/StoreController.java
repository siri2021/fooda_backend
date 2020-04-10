package it.vkod.woo.store.db.controllers;

import it.vkod.woo.store.db.exceptions.StoreNotFoundException;
import it.vkod.woo.store.db.models.Store;
import it.vkod.woo.store.db.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(path = "api/stores/")
public class StoreController {

    @Autowired
    private StoreRepository repository;

    @PostMapping
    public void apiPostStore(@NotNull @RequestBody Store store) {
        repository.saveAndFlush(store);
    }

    @PostMapping("all")
    public void apiPostStores(@NotNull @RequestBody List<Store> stores) {
        repository.saveAll(stores);
    }

    @GetMapping("{id}")
    public Store apiGetStore(@PathVariable("id") long id) {
        return repository.findById(id).orElseThrow(StoreNotFoundException::new);
    }

    @GetMapping("all")
    public List<Store> apiGetStores() {
        return repository.findAll();
    }

    @GetMapping("exists/{id}")
    public boolean apiStoreExists(@PathVariable("id") final long id) {
        return repository.existsById(id);
    }

    @DeleteMapping("{id}")
    public boolean apiDeleteStore(@PathVariable("id") final long id) {
        repository.deleteById(id);
        return apiStoreExists(id);
    }

    @PutMapping
    public void apiPutStore(@RequestBody Store store) {
        repository.saveAndFlush(store);
    }
}
