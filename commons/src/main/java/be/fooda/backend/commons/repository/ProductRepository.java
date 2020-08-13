package be.fooda.backend.commons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import be.fooda.backend.commons.model.template.product.request.FoodaProductKey;
import be.fooda.backend.commons.model.template.product.request.FoodaProductRequest;

public interface ProductRepository extends MySqlRepository<FoodaProductRequest, FoodaProductKey> {
    @Query("SELECT * FROM Product WHERE store_id = $1;")
    List<FoodaProductRequest> finaAllByStoreId(final Integer storeId);
    

}