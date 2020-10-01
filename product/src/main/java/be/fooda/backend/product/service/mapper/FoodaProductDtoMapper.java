package be.fooda.backend.product.service.mapper;

import be.fooda.backend.commons.model.template.product.response.FoodaProductImagesItemRes;
import be.fooda.backend.commons.model.template.product.response.FoodaProductPricesItemRes;
import be.fooda.backend.commons.model.template.product.response.FoodaProductRes;
import be.fooda.backend.commons.model.template.product.response.FoodaProductStoreRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.product.model.dto.*;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class FoodaProductDtoMapper implements FoodaDtoMapper<FoodaProductDto, FoodaProductReq, FoodaProductRes> {

    @Override
    public FoodaProductReq dtoToRequest(final FoodaProductDto dto) {
        return FoodaProductReq.builder()
                .categories(categories(dto))
                .description(dto.getDescription())
                .images(imagesAsReq(dto))
                .isFeatured(false)
                .name(dto.getName())
                .orderLimit(dto.getLimit())
                .prices(pricesAsReq(dto))
                .productId(dto.getKey().getProductId())
                .store(productStore(dto))
                .tags(tags(dto))
                .taxes(taxes(dto))
                .type(productType(dto))
                .build();
    }

    private List<String> categories(final FoodaProductDto dto) {
        return dto.getCategories().stream()
                .map(FoodaProductCategoryDto::getTitle)
                .collect(Collectors.toList());
    }

    private List<FoodaProductImagesItemReq> imagesAsReq(final FoodaProductDto dto) {
        return Collections.singletonList(FoodaProductImagesItemReq.builder().mediaId(dto.getImageId()).build());
    }

    private List<FoodaProductImagesItemRes> imagesAsRes(final FoodaProductDto dto) {
        FoodaProductImagesItemRes resImage = new FoodaProductImagesItemRes();
        resImage.setMediaId(dto.getImageId());
        return Collections.singletonList(resImage);
    }

    private List<FoodaProductPricesItemReq> pricesAsReq(final FoodaProductDto dto) {
        return Collections.singletonList(FoodaProductPricesItemReq.builder().priceId(dto.getPrice().getProductPriceId()).amount(dto.getPrice().getAmount()).build());
    }

    private List<FoodaProductPricesItemRes> pricesAsRes(final FoodaProductDto dto) {
        FoodaProductPricesItemRes resPrice = new FoodaProductPricesItemRes();
        resPrice.setPriceId(dto.getPrice().getProductPriceId());
        resPrice.setAmount(dto.getPrice().getAmount());
        resPrice.setCurrency("EUR");
        resPrice.setExpiry(dto.getPrice().getExpiry());
        resPrice.setIsDefault(true);
        resPrice.setTitle(dto.getPrice().getTitle());
        return Collections.singletonList(resPrice);
    }

    private List<String> tags(final FoodaProductDto dto) {
        return dto.getTags().stream()
                .map(FoodaProductTagDto::getValue)
                .collect(Collectors.toList());
    }

    private List<FoodaProductTaxesItemReq> taxes(final FoodaProductDto dto) {
        return Collections.singletonList(FoodaProductTaxesItemReq.builder().taxId(dto.getTax().getTaxId()).title(dto.getTax().getTitle()).build());
    }

    private FoodaProductTypeReq productType(final FoodaProductDto dto) {
        return FoodaProductTypeReq.builder()
                .typeId(dto.getType().getTypeId())
                .title(dto.getType().getTitle())
                .build();
    }

    private FoodaProductStoreReq productStore(final FoodaProductDto dto) {
        return FoodaProductStoreReq.builder()
                .storeId(dto.getKey().getStoreId())
                .name(dto.getName())
                .storeId(dto.getKey().getStoreId())
                .build();
    }

    @Override
    public FoodaProductRes dtoToResponse(final FoodaProductDto dto) {
        final FoodaProductRes res = new FoodaProductRes();
        res.setCategories(categories(dto));
        res.setDescription(dto.getDescription());
        res.setImages(imagesAsRes(dto));
        res.setIsFeatured(dto.getIsFeatured());
        res.setName(dto.getName());
        res.setOrderLimit(dto.getLimit());
        res.setPrices(pricesAsRes(dto));
        res.setProductId(dto.getKey().getProductId());
        res.setStockQuantity(0);
        res.setStore(store(dto));
        return res;
    }

    private FoodaProductStoreRes store(FoodaProductDto dto) {
        FoodaProductStoreRes resStore = new FoodaProductStoreRes();
        resStore.setStoreId(dto.getKey().getStoreId());
        return resStore;
    }

    @Override
    public FoodaProductDto requestToDto(final FoodaProductReq foodaProductReq) {
        return FoodaProductDto.builder()
                .categories(categories(foodaProductReq))
                .description(foodaProductReq.getDescription())
                .isFeatured(false)
                .key(productKey(foodaProductReq))
                .limit(foodaProductReq.getOrderLimit())
                .name(foodaProductReq.getName())
                .price(price(foodaProductReq).orElse(FoodaProductPriceDto.builder().build()))
                .build();
    }

    @Override
    public FoodaProductDto responseToDto(final FoodaProductRes foodaProductRes) {
        return null;
    }

    private FoodaProductKeyDto productKey(final FoodaProductReq req) {
        return FoodaProductKeyDto.builder().storeId(req.getStore().getStoreId()).productId(req.getProductId()).build();
    }

    private List<FoodaProductCategoryDto> categories(final FoodaProductReq req) {
        return req.getCategories().stream().map(r -> FoodaProductCategoryDto.builder().title(r).build()).collect(Collectors.toList());
    }

    private Optional<FoodaProductPriceDto> price(final FoodaProductReq req) {
        return req.getPrices()
                .stream()
                .filter(FoodaProductPricesItemReq::getIsDefault)
                .map(pReq -> FoodaProductPriceDto.builder()
                        .amount(pReq.getAmount())
                        .expiry(pReq.getExpiry())
                        .productPriceId(pReq.getPriceId())
                        .productKey(FoodaProductKeyDto.builder().productId(req.getProductId()).build())
                        .title(pReq.getTitle()).build())
                .findFirst();
    }
}
