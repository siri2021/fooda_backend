package it.vkod.woo.product.service.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icoderman.woocommerce.EndpointBaseType;
import com.icoderman.woocommerce.WooCommerce;
import it.vkod.woo.product.service.models.pojo.WooProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("wc")
public class WooCtrl implements ProductCtrl<WooProduct> {

    @Autowired
    private WooCommerce woo;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public WooProduct[] apiGetProductsAll(final int page) {
        Map<String, String> params = new HashMap<>();
        params.put("per_page", "100");
        params.put("offset", String.valueOf(page));
        @SuppressWarnings("unchecked")    // we'll throw an exception from service to simulate a failure
        final List<Map<String, Object>> productListMap = woo.getAll(EndpointBaseType.PRODUCTS.getValue(), params);
        return mapper.convertValue(productListMap, WooProduct[].class);
    }

    @Override
    public WooProduct[] apiGetProductsSearch(String search) {
        Map<String, String> params = new HashMap<>();
        params.put("per_page", "100");
        params.put("offset", "0");
        params.put("search", search);
        @SuppressWarnings("unchecked")
        final List<Map<String, Object>> productListMap = woo.getAll(EndpointBaseType.PRODUCTS.getValue(), params);
        return mapper.convertValue(productListMap, WooProduct[].class);
    }

    @Override
    public WooProduct[] apiGetProductsSearch(double min, double max) {
        Map<String, String> params = new HashMap<>();
        params.put("per_page", "100");
        params.put("offset", "0");
        params.put("min_price", String.valueOf(min));
        params.put("max_price", String.valueOf(max));
        @SuppressWarnings("unchecked")    // we'll throw an exception from service to simulate a failure
        final List<Map<String, Object>> productListMap = woo.getAll(EndpointBaseType.PRODUCTS.getValue(), params);
        return mapper.convertValue(productListMap, WooProduct[].class);
    }

    @Override
    public WooProduct apiGetProductOne(final long id) {
        @SuppressWarnings("unchecked")    // we'll throw an exception from service to simulate a failure
                Map<String, Object> productMap = woo.get(EndpointBaseType.PRODUCTS.getValue(), (int) id);
        return mapper.convertValue(productMap, WooProduct.class);
    }

    @Override
    public void apiPostProductAll(WooProduct[] products) {
        Arrays.stream(products).forEach(this::apiPostProductOne);
    }

    @Override
    public void apiPostProductOne(WooProduct product) {
        final Map<String, Object> productMap = mapper.convertValue(product, new TypeReference<Map<String, Object>>() {
        });
        woo.create(EndpointBaseType.PRODUCTS.getValue(), productMap);
    }

    @Override
    public void apiPutProductAll(WooProduct[] products) {
        Arrays.stream(products).forEach(product -> apiPutProductOne(Long.parseLong(String.valueOf(product.getId())), product));
    }

    @Override
    public void apiPutProductOne(long id, WooProduct product) {
        final Map<String, Object> productMap = mapper.convertValue(product, new TypeReference<Map<String, Object>>() {
        });
        woo.update(EndpointBaseType.PRODUCTS.getValue(), (int) id, productMap);
    }

    @Override
    public void apiDeleteProductOne(long id) {
        woo.delete(EndpointBaseType.PRODUCTS.getValue(), (int) id);
    }

    @Override
    public void apiDeleteProductAll(long... ids) {
        Arrays.stream(ids).forEach(this::apiDeleteProductOne);
    }
}
