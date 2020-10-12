package be.fooda.backend.product.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface FoodaProductService<REQ, RES> {

    Optional<RES> getById(final Long productId);

    Optional<RES> getById(final Long externalProductId, final Long storeId);

    Optional<RES> getByExample(final REQ req);

    List<RES> getAll();

    List<RES> getByName(final String name);

    List<RES> getByDescription(final String description);

    List<RES> getByFeatured();

    List<RES> getByTypeId(final Long productTypeId);

    List<RES> getByPriceRange(final BigDecimal minPrice, final BigDecimal maxPrice);

    List<RES> getByPriceId(final Long productPriceId);

    List<RES> getByExpiryDate(final Long productPriceId, final LocalDate expiryDate);

    List<RES> getByStoreId(final Long storeId);

    List<RES> getByCategoryId(final Long categoryId);

    List<RES> getByCategories(final Set<Long> categories);

    List<RES> getByTags(final Set<String> tags);

    Optional<RES> add(final REQ req);

    Optional<RES> editById(final Long productId, final REQ req);

    Optional<RES> editById(final Long externalProductId, final Long storeId, final REQ req);

    Optional<RES> editByExample(final REQ req);

    Optional<RES> removeById(final Long productId);

    Optional<RES> removeById(final Long externalProductId, final Long storeId);

    Optional<RES> removeByStoreId(final Long storeId);

    Optional<RES> removeByExample(final REQ req);

    Boolean existsById(final Long productId);

    Boolean existsById(final Long externalProductId, final Long storeId);

    Boolean existsByExample(final REQ req);
}