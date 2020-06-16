package it.vkod.woocommerce.server.controllers;

import it.vkod.woocommerce.server.models.store.response.FoodaStoreResponse;
import org.springframework.web.bind.annotation.*;

public interface ProductController<RES, REQ> {

    @GetMapping("store")
    FoodaStoreResponse apiGetStore();

    @GetMapping("page/{page}")
    RES[] apiGetProductsAll(@PathVariable("page") final int page);

    @GetMapping("search/{search}")
    RES[] apiGetProductsSearch(@PathVariable("search") final String search);

    @GetMapping("search/price/{min}/{max}")
    RES[] apiGetProductsSearch(@PathVariable("min") final double min, @PathVariable("max") final double max);

    @GetMapping("{id}")
    RES apiGetProductOne(@PathVariable("id") final long id);

    @PostMapping("all")
    void apiPostProductAll(@RequestBody REQ[] products);

    @PostMapping
    void apiPostProductOne(@RequestBody REQ product);

    @PutMapping("all")
    void apiPutProductAll(@RequestBody REQ[] products);

    @PutMapping("{id}")
    void apiPutProductOne(@PathVariable("id") final long id, @RequestBody REQ product);

    @DeleteMapping("all")
    void apiDeleteProductAll(@RequestBody long... ids);

    @DeleteMapping("{id}")
    void apiDeleteProductOne(@PathVariable("id") final long id);

}
