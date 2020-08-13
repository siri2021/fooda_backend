package be.fooda.backend.product.service;

import be.fooda.backend.commons.model.template.product.request.FoodaProductRequest;

public interface FoodaProductService extends GenericService<FoodaProductRequest, Integer>  {
    FoodaProductRequest findByKey(Integer productId, Integer storeId);
    
}