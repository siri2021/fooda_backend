package it.vkod.woocommerce.server.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icoderman.woocommerce.EndpointBaseType;
import com.icoderman.woocommerce.WooCommerce;
import it.vkod.woocommerce.server.models.product.request.WooProductRequest;
import it.vkod.woocommerce.server.models.product.response.WooProductResponse;
import it.vkod.woocommerce.server.models.store.response.FoodaStoreResponse;
import it.vkod.woocommerce.server.utilities.EnvironmentUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import static java.util.Objects.requireNonNull;

@RestController
@RequestMapping("api/products")
public class WooProductController implements ProductController<WooProductResponse, WooProductRequest> {

    @Autowired
    private Environment env;
    @Autowired
    private WooCommerce woo;
    @Autowired
    private EnvironmentUtility util;
    @Autowired
    private ObjectMapper mapper;

    @Override
    public FoodaStoreResponse apiGetStore() {
        return FoodaStoreResponse.builder()
                .id(Long.valueOf(requireNonNull(env.getProperty("store.id"))))
                .consumerKey(requireNonNull(env.getProperty("store.ck")))
                .consumerSecret(requireNonNull(env.getProperty("store.cs")))
                .name(requireNonNull(env.getProperty("store.name")))
                .address(requireNonNull(env.getProperty("store.address")))
                .municipality(requireNonNull(env.getProperty("store.municipality")))
                .city(requireNonNull(env.getProperty("store.city")))
                .region(requireNonNull(env.getProperty("store.region")))
                .country(requireNonNull(env.getProperty("store.country")))
                .currency(requireNonNull(env.getProperty("store.currency")))
                .latitude(Double.parseDouble(requireNonNull(env.getProperty("store.latitude"))))
                .longitude(Double.parseDouble(requireNonNull(env.getProperty("store.longitude"))))
                .homeUrl(requireNonNull(env.getProperty("store.homeUrl")))
                .siteUrl(requireNonNull(env.getProperty("store.siteUrl")))
                .port(Objects.requireNonNull(env.getProperty("store.port")))
                .build();
    }

    @Override
    public WooProductResponse[] apiGetProductsAll(final int page) {
        Map<String, String> params = new HashMap<>();
        params.put("per_page", "10");
        params.put("offset", String.valueOf(page));
        @SuppressWarnings("unchecked")    // we'll throw an exception from service to simulate a failure
        final List<Map<String, Object>> productListMap = woo.getAll(EndpointBaseType.PRODUCTS.getValue(), params);
        final WooProductResponse[] wooProductResponses = mapper.convertValue(productListMap, WooProductResponse[].class);
        Arrays.stream(wooProductResponses).forEach(wooProductResponse -> {
            wooProductResponse.setStoreId(Long.parseLong(requireNonNull(env.getProperty("store.id"))));
            wooProductResponse.setRestUrl(util.getHostname() + ":" + util.getPort());
        });
        return wooProductResponses;
    }

    @Override
    public WooProductResponse[] apiGetProductsSearch(String search) {
        Map<String, String> params = new HashMap<>();
        params.put("per_page", "10"); // it was 100 by default ..
        params.put("offset", "0");
        params.put("search", search);
        @SuppressWarnings("unchecked") final List<Map<String, Object>> productListMap = woo.getAll(EndpointBaseType.PRODUCTS.getValue(), params);
        final WooProductResponse[] wooProductResponses = mapper.convertValue(productListMap, WooProductResponse[].class);
        Arrays.stream(wooProductResponses).forEach(wooProductResponse -> {
            wooProductResponse.setStoreId(Long.parseLong(requireNonNull(env.getProperty("store.id"))));
            wooProductResponse.setRestUrl(util.getHostname() + ":" + util.getPort());
        });
        return wooProductResponses;
    }

    @Override
    public WooProductResponse[] apiGetProductsSearch(double min, double max) {
        Map<String, String> params = new HashMap<>();
        params.put("per_page", "10");
        params.put("offset", "0");
        params.put("min_price", String.valueOf(min));
        params.put("max_price", String.valueOf(max));
        @SuppressWarnings("unchecked")    // we'll throw an exception from service to simulate a failure
        final List<Map<String, Object>> productListMap = woo.getAll(EndpointBaseType.PRODUCTS.getValue(), params);
        final WooProductResponse[] wooProductResponses = mapper.convertValue(productListMap, WooProductResponse[].class);
        Arrays.stream(wooProductResponses).forEach(wooProductResponse -> {
            wooProductResponse.setStoreId(Long.parseLong(requireNonNull(env.getProperty("store.id"))));
            wooProductResponse.setRestUrl(util.getHostname() + ":" + util.getPort());
        });
        return wooProductResponses;
    }

    @Override
    public WooProductResponse apiGetProductOne(final long id) {
        @SuppressWarnings("unchecked")    // we'll throw an exception from service to simulate a failure
                Map<String, Object> productMap = woo.get(EndpointBaseType.PRODUCTS.getValue(), (int) id);
        final WooProductResponse wooProductResponse = mapper.convertValue(productMap, WooProductResponse.class);
        wooProductResponse.setStoreId(Long.parseLong(requireNonNull(env.getProperty("store.id"))));
        wooProductResponse.setRestUrl(util.getHostname() + ":" + util.getPort());
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
        woo.create(EndpointBaseType.PRODUCTS.getValue(), productMap);
    }

    @Override
    public void apiPutProductAll(WooProductRequest[] products) {
        Arrays.stream(products).forEach(product -> apiPutProductOne(Long.parseLong(String.valueOf(product.getId())), product));
    }

    @Override
    public void apiPutProductOne(long id, WooProductRequest product) {
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
