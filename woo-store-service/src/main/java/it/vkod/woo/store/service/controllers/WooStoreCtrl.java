package it.vkod.woo.store.service.controllers;

import it.vkod.woo.store.service.payloads.store.request.WooStoreRequest;
import it.vkod.woo.store.service.repositories.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("api/stores/")
public class WooStoreCtrl {

    @Autowired
    private StoreRepo repo;

    @GetMapping("select")
    public Set<WooStoreRequest> apiGetStores() {
        return new HashSet<>(repo.findAll());
    }

    @PostMapping("insert")
    public ResponseEntity<WooStoreRequest> apiPostStore(@RequestBody WooStoreRequest store) {
        repo.save(store);
        return ResponseEntity.ok(store);
    }

}
