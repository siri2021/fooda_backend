package be.fooda.backend.store.controllers;

import be.fooda.backend.store.models.Store;
import be.fooda.backend.store.services.impl.StoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/store")
public class StoreController {

    @Autowired
    private StoreServiceImpl storeService;

    @GetMapping("/getList")
    public List<Store> getStoreList() {
        return storeService.get();
    }

    @GetMapping("/getPaged")
    public Page<Store> getStorePaged(@RequestParam final int page) {
        return storeService.get(PageRequest.of(page - 1, 10));
    }

    @GetMapping("/getByStoreId")
    public Store getStore(@RequestParam final BigInteger storeId) {
        return storeService.get(storeId).orElse(null);
    }

    @PostMapping("/add")
    public void addStore(@RequestBody final Store store) {
        storeService.add(store);
    }

    @PostMapping("/addList")
    public void addStoreList(@RequestBody final List<Store> stores) {
        stores.forEach(this::addStore);
    }

    @PutMapping("/edit")
    public void editStore(@RequestBody final Store store) {
        storeService.edit(store, store.getStoreId());
    }

    @DeleteMapping("/deleteByStoreId")
    public void deleteStore(@RequestParam final BigInteger storeId) {
        storeService.delete(storeId);
    }

}
