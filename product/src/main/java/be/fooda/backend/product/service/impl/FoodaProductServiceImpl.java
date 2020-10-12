package be.fooda.backend.product.service.impl;

import be.fooda.backend.commons.model.template.product.request.FoodaProductReq;
import be.fooda.backend.commons.model.template.product.response.FoodaProductRes;
import be.fooda.backend.commons.service.mapper.FoodaProductHttpMapper;
import be.fooda.backend.product.dao.FoodaProductRepository;
import be.fooda.backend.product.service.FoodaProductService;
import be.fooda.backend.product.service.mapper.FoodaProductDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FoodaProductServiceImpl implements FoodaProductService<FoodaProductReq, FoodaProductRes> {

    @Autowired
    private FoodaProductRepository productRepo;

    @Autowired
    private FoodaProductDtoMapper productDtoMapper;

    @Autowired
    private FoodaProductHttpMapper productHttpMapper;

    @Override
    public Optional<FoodaProductRes> getById(final Long productId) {
        return productRepo.findById(productId).map(productDtoMapper::dtoToResponse);
    }

    @Override
    public Optional<FoodaProductRes> getByExample(final FoodaProductReq productReq) {
        return productRepo.findOne(Example.of(productDtoMapper.requestToDto(productReq)))
                .map(productDtoMapper::dtoToResponse);

    }

    @Override
    public List<FoodaProductRes> getAll() {
        return productRepo.findAll().stream().map(productDtoMapper::dtoToResponse).collect(Collectors.toList());
    }

    @Override
    public List<FoodaProductRes> getByName(final String productName) {
        return productRepo.findByName(productName).stream().map(productDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaProductRes> getByDescription(final String description) {
        return productRepo.findByDescription(description).stream().map(productDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaProductRes> getByFeatured() {
        return productRepo.findByFeatured().stream().map(productDtoMapper::dtoToResponse).collect(Collectors.toList());
    }

    @Override
    public List<FoodaProductRes> getByTypeId(final Long productTypeId) {
        return productRepo.findById(productTypeId).stream().map(productDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaProductRes> getByPriceRange(final BigDecimal minPrice, final BigDecimal maxPrice) {
        return productRepo.findByPrice(minPrice, maxPrice).stream().map(productDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaProductRes> getByPriceId(final Long productPriceId) {
        return productRepo.findById(productPriceId).stream().map(productDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaProductRes> getByExpiryDate(final Long productPriceId, final LocalDate expiryDate) {
        return productRepo.findByPriceIdAndExpiryDate(productPriceId, expiryDate).stream()
                .map(productDtoMapper::dtoToResponse).collect(Collectors.toList());
    }

    @Override
    public List<FoodaProductRes> getByStoreId(final Long storeId) {
        return productRepo.findById(storeId).stream().map(productDtoMapper::dtoToResponse).collect(Collectors.toList());
    }

    @Override
    public List<FoodaProductRes> getByCategoryId(final Long categoryId) {
        return productRepo.findById(categoryId).stream().map(productDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaProductRes> getByCategories(final Set<Long> categories) {
        return productRepo.findByCategories(categories).stream().map(productDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaProductRes> getByTags(final Set<String> tags) {
        return productRepo.findByTags(tags).stream().map(productDtoMapper::dtoToResponse).collect(Collectors.toList());
    }

    @Override
    public Optional<FoodaProductRes> add(final FoodaProductReq req) {
        return Optional.of(productDtoMapper.dtoToResponse(productRepo.save(productDtoMapper.requestToDto(req))));
    }

    @Override
    public Optional<FoodaProductRes> editById(final Long productId, final FoodaProductReq productReq) {
        return getById(productId)
                .map(res -> productHttpMapper.requestToResponse(productReq).toBuilder()
                        .productId(productReq.getProductId()).build())
                .map(res -> productDtoMapper.dtoToResponse(productRepo.save(productDtoMapper.responseToDto(res))));

    }

    @Override
    public Optional<FoodaProductRes> editByExample(final FoodaProductReq productReq) {
        return getByExample(productReq)
                .map(res -> productDtoMapper.dtoToResponse(productRepo.save(productDtoMapper.responseToDto(res))));

    }

    @Override
    public Optional<FoodaProductRes> removeById(final Long productId) {
        final Optional<FoodaProductRes> foundProduct = getById(productId);
        foundProduct.ifPresent(res -> productRepo.deleteById(productId));
        final Optional<FoodaProductRes> productAfterDelete = getById(productId);
        if (productAfterDelete.isEmpty()) {
            return foundProduct;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<FoodaProductRes> removeByStoreId(final Long storeId) {
        final Optional<FoodaProductRes> foundProduct = getById(storeId);
        foundProduct.ifPresent(res -> productRepo.deleteById(storeId));
        final Optional<FoodaProductRes> productAfterDelete = getById(storeId);
        if (productAfterDelete.isEmpty()) {
            return foundProduct;
        } else {
            return Optional.empty();
        }

    }

    @Override
    public Optional<FoodaProductRes> removeByExample(final FoodaProductReq productReq) {
        final Optional<FoodaProductRes> foundProduct = getByExample(productReq);
        foundProduct.ifPresent(res -> productRepo.delete(productDtoMapper.requestToDto(productReq)));
        final Optional<FoodaProductRes> productAfterDelete = getByExample(productReq);
        if (productAfterDelete.isEmpty()) {
            return foundProduct;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Boolean existsById(final Long productKey) {
        return productRepo.findById(productKey).isPresent();
    }

    @Override
    public Boolean existsByExample(final FoodaProductReq productReq) {
        return productRepo.exists(Example.of(productDtoMapper.requestToDto(productReq)));
    }

    @Override
    public Optional<FoodaProductRes> getById(final Long externalProductId, final Long storeId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<FoodaProductRes> editById(final Long externalProductId, final Long storeId,
            final FoodaProductReq req) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<FoodaProductRes> removeById(final Long externalProductId, final Long storeId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean existsById(final Long externalProductId, final Long storeId) {
        // TODO Auto-generated method stub
        return null;
    }

}