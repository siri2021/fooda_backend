package it.vkod.woo.product.service.controllers;

import org.springframework.web.bind.annotation.*;

public interface OrderCtrl<RES, REQ> {

    @GetMapping("page/{page}")
    public RES[] apiGetOrdersAll(@PathVariable("page") final int page);

    @GetMapping("{id}")
    public RES apiGetOrderOne(@PathVariable("id") final long id);

    @PostMapping
    public void apiPostOrderOne(@RequestBody REQ order);

    @PutMapping("{id}")
    public void apiPutOrderOne(@PathVariable("id") final long id, @RequestBody REQ order);

    @DeleteMapping("{id}")
    public void apiDeleteOrderOne(@PathVariable("id") final long id);

}
