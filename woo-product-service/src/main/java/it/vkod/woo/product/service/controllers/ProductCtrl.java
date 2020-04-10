package it.vkod.woo.product.service.controllers;

import org.springframework.web.bind.annotation.*;

public interface ProductCtrl<T> {

    @GetMapping("page/{page}")
    public T[] apiGetProductsAll(@PathVariable("page") final int page);

    @GetMapping("search/{search}")
    public T[] apiGetProductsSearch(@PathVariable("search") final String search);

    @GetMapping("search/price/{min}/{max}")
    public T[] apiGetProductsSearch(@PathVariable("min") final double min, @PathVariable("max") final double max);

    @GetMapping("{id}")
    public T apiGetProductOne(@PathVariable("id") final long id);

    @PostMapping("all")
    public void apiPostProductAll(@RequestBody T[] products);

    @PostMapping
    public void apiPostProductOne(@RequestBody T product);

    @PutMapping("all")
    public void apiPutProductAll(@RequestBody T[] products);

    @PutMapping("{id}")
    public void apiPutProductOne(@PathVariable("id") final long id, @RequestBody T product);

    @DeleteMapping("all")
    public void apiDeleteProductAll(@RequestBody long... ids);

    @DeleteMapping("{id}")
    public void apiDeleteProductOne(@PathVariable("id") final long id);

}
