package it.vkod.woo.order.service.controllers;

import org.springframework.web.bind.annotation.*;

public interface ProductCtrl<RES, REQ> {

    @GetMapping("page/{page}")
    public RES[] apiGetProductsAll(@PathVariable("page") final int page);

    @GetMapping("search/{search}")
    public RES[] apiGetProductsSearch(@PathVariable("search") final String search);

    @GetMapping("search/price/{min}/{max}")
    public RES[] apiGetProductsSearch(@PathVariable("min") final double min, @PathVariable("max") final double max);

    @GetMapping("{id}")
    public RES apiGetProductOne(@PathVariable("id") final long id);

    @PostMapping("all")
    public void apiPostProductAll(@RequestBody REQ[] products);

    @PostMapping
    public void apiPostProductOne(@RequestBody REQ product);

    @PutMapping("all")
    public void apiPutProductAll(@RequestBody REQ[] products);

    @PutMapping("{id}")
    public void apiPutProductOne(@PathVariable("id") final long id, @RequestBody REQ product);

    @DeleteMapping("all")
    public void apiDeleteProductAll(@RequestBody long... ids);

    @DeleteMapping("{id}")
    public void apiDeleteProductOne(@PathVariable("id") final long id);

}
