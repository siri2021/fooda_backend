package be.fooda.backend.product.service;

import be.fooda.backend.commons.model.template.product.dto.FoodaProductDto;

public interface FoodaProductService extends GenericService<FoodaProductDto, Integer> {
    FoodaProductDto findByKey(Integer productId, Integer storeId);
}