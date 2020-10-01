package be.fooda.backend.product.service.impl;

import be.fooda.backend.commons.model.template.product.request.FoodaProductReq;
import be.fooda.backend.commons.model.template.product.response.FoodaProductRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.commons.service.mapper.FoodaHttpMapper;
import be.fooda.backend.product.dao.FoodaProductRepository;
import be.fooda.backend.product.model.dto.FoodaProductDto;
import be.fooda.backend.product.model.dto.FoodaProductKeyDto;
import be.fooda.backend.product.service.FoodaProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class FoodaProductServiceImpl implements FoodaProductService<FoodaProductReq, FoodaProductRes> {

    @Autowired
    private FoodaProductRepository productRepo;

    @Qualifier("foodaProductDtoMapper")
    @Autowired
    private FoodaDtoMapper<FoodaProductDto, FoodaProductReq, FoodaProductRes> dtoMapper;

    @Autowired
    private FoodaHttpMapper<FoodaProductReq, FoodaProductRes> httpMapper;

    @Override
    public Optional<FoodaProductRes> getProductByKey(Long productKey) {
        return productRepo.findById(productKey).map(dtoMapper::dtoToResponse);
    }

    @Override
    public Optional<FoodaProductRes> getProductByKey(Long productId, Long storeId) {
        return productRepo.findByKey(FoodaProductKeyDto.builder().productId(productId).storeId(storeId).build())
                .map(dtoMapper::dtoToResponse);
    }

    @Override
    public Optional<FoodaProductRes> getProductByExample(FoodaProductReq productReq) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<FoodaProductRes> getAllProducts() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<FoodaProductRes> getProductsByName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<FoodaProductRes> getProductsByDescription(String description) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<FoodaProductRes> getProductsByFeatured() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<FoodaProductRes> getProductsByTypeId(Long productTypeId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<FoodaProductRes> getProductsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<FoodaProductRes> getProductsByPriceId(Long productPriceId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<FoodaProductRes> getProductsByPriceId(Long productPriceId, LocalDate expiryDate) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<FoodaProductRes> getProductsByStoreId(Long storeId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<FoodaProductRes> getProductsByCategoryId(Long categoryId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<FoodaProductRes> getProductsByCategories(Set<Long> categories) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<FoodaProductRes> getProductsByTags(Set<String> tags) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<FoodaProductRes> addProduct(FoodaProductReq req) {
        return Optional.of(dtoMapper.dtoToResponse(
                    productRepo.save(
                        dtoMapper.requestToDto(req))));
    }

    @Override
    public Optional<FoodaProductRes> editProductByKey(Long productId, Long storeId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<FoodaProductRes> editProductByExample(FoodaProductReq productReq) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<FoodaProductRes> removeProductByKey(Long productId, Long storeId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<FoodaProductRes> removeProductByExample(FoodaProductReq productReq) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean doesProductExistsById(Long productKey) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean doesProductExists(Long productId, Long storeId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean doesProductExistsByExample(FoodaProductReq productReq) {
        return productRepo.findByKey(FoodaProductKeyDto.builder().productId(productReq.getProductId())
                .storeId(productReq.getStore().getStoreId()).build()).isPresent();
    }

}