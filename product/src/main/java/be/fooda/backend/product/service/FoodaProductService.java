package be.fooda.backend.product.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface FoodaProductService<REQ, RES> {

    Optional<RES> getProductByKey(final Long productKey);

    Optional<RES> getProductByKey(final Long productId, final Long storeId);

    Optional<RES> getProductByExample(final REQ productReq);

    List<RES> getAllProducts();

    List<RES> getProductsByName(final String name);

    List<RES> getProductsByDescription(final String description);

    List<RES> getProductsByFeatured();

    List<RES> getProductsByTypeId(final Long productTypeId);

    List<RES> getProductsByPriceRange(final BigDecimal minPrice, final BigDecimal maxPrice);

    List<RES> getProductsByPriceId(final Long productPriceId);

    List<RES> getProductsByPriceId(final Long productPriceId, final LocalDate expiryDate);

    List<RES> getProductsByStoreId(final Long storeId);

    List<RES> getProductsByCategoryId(final Long categoryId);

    List<RES> getProductsByCategories(Set<Long> categories);

    List<RES> getProductsByTags(final Set<String> tags);

    Optional<RES> addProduct(final REQ req);

    Optional<RES> editProductByKey(final Long productId, final Long storeId);

    Optional<RES> editProductByExample(final REQ productReq);

    Optional<RES> removeProductByKey(final Long productId, final Long storeId);

    Optional<RES> removeProductByExample(final REQ productReq);

    Boolean doesProductExistsById(final Long productKey);

    Boolean doesProductExists(final Long productId, final Long storeId);

    Boolean doesProductExistsByExample(final REQ productReq);
}