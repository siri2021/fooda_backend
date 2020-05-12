package it.vkod.woo.product.service.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icoderman.woocommerce.EndpointBaseType;
import com.icoderman.woocommerce.WooCommerce;
import it.vkod.woo.core.payloads.product.request.WooProductRequest;
import it.vkod.woo.core.payloads.product.response.WooProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/products")
public class WooProductCtrl implements ProductCtrl<WooProductResponse, WooProductRequest> {

    @Value("${store.id}")
    private long storeId;

    @Autowired
    private WooCommerce wooCommerceService;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public WooProductResponse[] apiGetProductsAll(final int page) {
        Map<String, String> params = new HashMap<>();
        params.put("per_page", "100");
        params.put("offset", String.valueOf(page));
        @SuppressWarnings("unchecked")    // we'll throw an exception from service to simulate a failure
        final List<Map<String, Object>> productListMap = wooCommerceService.getAll(EndpointBaseType.PRODUCTS.getValue(), params);
        final WooProductResponse[] wooProductResponses = mapper.convertValue(productListMap, WooProductResponse[].class);
        Arrays.stream(wooProductResponses).forEach(wooProductResponse -> wooProductResponse.setStoreId(storeId));
        return wooProductResponses;
    }

    @Override
    public WooProductResponse[] apiGetProductsSearch(String search) {
        Map<String, String> params = new HashMap<>();
        params.put("per_page", "100");
        params.put("offset", "0");
        params.put("search", search);
        @SuppressWarnings("unchecked") final List<Map<String, Object>> productListMap = wooCommerceService.getAll(EndpointBaseType.PRODUCTS.getValue(), params);
        final WooProductResponse[] wooProductResponses = mapper.convertValue(productListMap, WooProductResponse[].class);
        Arrays.stream(wooProductResponses).forEach(wooProductResponse -> wooProductResponse.setStoreId(storeId));
        return wooProductResponses;
    }

    @Override
    public WooProductResponse[] apiGetProductsSearch(double min, double max) {
        Map<String, String> params = new HashMap<>();
        params.put("per_page", "100");
        params.put("offset", "0");
        params.put("min_price", String.valueOf(min));
        params.put("max_price", String.valueOf(max));
        @SuppressWarnings("unchecked")    // we'll throw an exception from service to simulate a failure
        final List<Map<String, Object>> productListMap = wooCommerceService.getAll(EndpointBaseType.PRODUCTS.getValue(), params);
        final WooProductResponse[] wooProductResponses = mapper.convertValue(productListMap, WooProductResponse[].class);
        Arrays.stream(wooProductResponses).forEach(wooProductResponse -> wooProductResponse.setStoreId(storeId));
        return wooProductResponses;
    }

    @Override
    public WooProductResponse apiGetProductOne(final long id) {
        @SuppressWarnings("unchecked")    // we'll throw an exception from service to simulate a failure
                Map<String, Object> productMap = wooCommerceService.get(EndpointBaseType.PRODUCTS.getValue(), (int) id);
        final WooProductResponse wooProductResponse = mapper.convertValue(productMap, WooProductResponse.class);
        wooProductResponse.setStoreId(storeId);
        return wooProductResponse;
    }

    @Override
    public void apiPostProductAll(WooProductRequest[] products) {
        Arrays.stream(products).forEach(this::apiPostProductOne);
    }

    @Override
    public void apiPostProductOne(WooProductRequest product) {
        final Map<String, Object> productMap = mapper.convertValue(product, new TypeReference<Map<String, Object>>() {
        });
        wooCommerceService.create(EndpointBaseType.PRODUCTS.getValue(), productMap);
    }

    @Override
    public void apiPutProductAll(WooProductRequest[] products) {
        Arrays.stream(products).forEach(product -> apiPutProductOne(Long.parseLong(String.valueOf(product.getId())), product));
    }

    @Override
    public void apiPutProductOne(long id, WooProductRequest product) {
        final Map<String, Object> productMap = mapper.convertValue(product, new TypeReference<Map<String, Object>>() {
        });
        wooCommerceService.update(EndpointBaseType.PRODUCTS.getValue(), (int) id, productMap);
    }

    @Override
    public void apiDeleteProductOne(long id) {
        wooCommerceService.delete(EndpointBaseType.PRODUCTS.getValue(), (int) id);
    }

    @Override
    public void apiDeleteProductAll(long... ids) {
        Arrays.stream(ids).forEach(this::apiDeleteProductOne);
    }
}
