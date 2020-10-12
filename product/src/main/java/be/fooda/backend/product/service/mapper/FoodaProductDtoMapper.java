package be.fooda.backend.product.service.mapper;

import be.fooda.backend.commons.model.template.product.request.*;
import be.fooda.backend.commons.model.template.product.response.*;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.product.model.dto.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class FoodaProductDtoMapper implements FoodaDtoMapper<FoodaProductDto, FoodaProductReq, FoodaProductRes> {

    @Override
    public FoodaProductReq dtoToRequest(final FoodaProductDto dto) {
        return FoodaProductReq.builder()
                .productId(dto.getProductId())
                .name(dto.getName())
                .type(productType(dto))
                .store(productStore(dto))
                .description(dto.getDescription())
                .isFeatured(false)
                .orderLimit(dto.getLimit())
                .categories(categories(dto))
                .tags(tags(dto))
                .images(imagesAsReq(dto))
                .prices(pricesAsReq(dto))
                .taxes(taxes(dto))
                .build();
    }

    private List<String> categories(final FoodaProductDto dto) {
        return dto.getCategories().stream().map(FoodaProductCategoryDto::getTitle).collect(Collectors.toList());
    }

    private List<FoodaProductImagesItemReq> imagesAsReq(final FoodaProductDto dto) {
        return Collections.singletonList(FoodaProductImagesItemReq.builder().mediaId(dto.getImageId()).build());
    }

    private List<FoodaProductImagesItemRes> imagesAsRes(final FoodaProductDto dto) {
        return Arrays.asList(FoodaProductImagesItemRes.builder().mediaId(dto.getImageId()).isDefault(true)
                .type(typeAsRes(dto)).build());
    }

    private List<FoodaProductPricesItemReq> pricesAsReq(final FoodaProductDto dto) {
        return Collections.singletonList(FoodaProductPricesItemReq.builder().priceId(dto.getPrice().getProductPriceId())
                .amount(dto.getPrice().getAmount()).build());
    }

    private List<FoodaProductPricesItemRes> pricesAsRes(final FoodaProductDto dto) {
        return Arrays.asList(FoodaProductPricesItemRes.builder().priceId(dto.getPrice().getProductPriceId())
                .title(dto.getType().getTitle()).isDefault(true).expiry(dto.getPrice().getExpiry()).currency("EUR")
                .amount(dto.getPrice().getAmount()).build());
    }

    private List<String> tags(final FoodaProductDto dto) {
        return dto.getTags().stream().map(FoodaProductTagDto::getValue).collect(Collectors.toList());
    }

    private List<FoodaProductTaxesItemReq> taxes(final FoodaProductDto dto) {
        return Collections.singletonList(FoodaProductTaxesItemReq.builder().taxId(dto.getTax().getTaxId())
                .title(dto.getTax().getTitle()).build());
    }

    private FoodaProductTypeReq productType(final FoodaProductDto dto) {
        return FoodaProductTypeReq.builder()
                .typeId(dto.getType().getProductTypeId())
                .title(dto.getType().getTitle())
                .build();
    }

    private FoodaProductStoreReq productStore(final FoodaProductDto dto) {
        return FoodaProductStoreReq.builder().storeId(dto.getStoreId()).name(dto.getName()).build();
    }

    @Override
    public FoodaProductRes dtoToResponse(final FoodaProductDto dto) {
        return FoodaProductRes.builder().categories(categories(dto)).description(dto.getDescription())
                .images(imagesAsRes(dto)).isFeatured(dto.getIsFeatured()).name(dto.getName()).orderLimit(dto.getLimit())
                .prices(pricesAsRes(dto)).productId(dto.getProductId()).stockQuantity(0).store(store(dto))
                .tags(tags(dto)).taxes(taxesAsRes(dto)).type(typeAsRes(dto)).build();
    }

    private FoodaProductTypeRes typeAsRes(final FoodaProductDto dto) {
        return FoodaProductTypeRes.builder().name(dto.getName()).title(dto.getType().getTitle())
                .typeId(dto.getType().getProductTypeId()).build();
    }

    private List<FoodaProductTaxesItemRes> taxesAsRes(final FoodaProductDto dto) {
        return Arrays.asList(FoodaProductTaxesItemRes.builder().isDefault(false).title(dto.getType().getTitle())
                .taxId(dto.getTax().getTaxId()).build());
    }

    private FoodaProductStoreRes store(final FoodaProductDto dto) {
        return FoodaProductStoreRes.builder().name(dto.getName()).storeId(dto.getStoreId()).build();
    }

    @Override
    public FoodaProductDto requestToDto(final FoodaProductReq req) {
        return FoodaProductDto.builder().categories(categories(req)).description(req.getDescription())
                .isFeatured(req.getIsFeatured()).productId(req.getProductId()).storeId(req.getStore().getStoreId())
                .limit(req.getOrderLimit()).name(req.getName())
                .price(price(req).orElse(FoodaProductPriceDto.builder().build())).build();
    }

    @Override
    public FoodaProductDto responseToDto(final FoodaProductRes res) {
        return FoodaProductDto.builder().categories(categoriesAsDto(res)).description(res.getDescription())
                .ingredients(ingredientsAsDto(res)).isFeatured(res.getIsFeatured()).storeId(res.getStore().getStoreId())
                .productId(res.getProductId()).limit(res.getOrderLimit()).name(res.getName()).price(priceAsDto(res))
                .tags(tagAsDto(res)).tax(taxAsDto(res)).type(typeAsDto(res)).build();
    }

    private FoodaProductTypeDto typeAsDto(final FoodaProductRes res) {
        return FoodaProductTypeDto.builder().title(res.getType().getTitle()).productTypeId(res.getType().getTypeId())
                .build();
    }

    private FoodaProductTaxDto taxAsDto(final FoodaProductRes res) {
        return FoodaProductTaxDto.builder().productId(res.getProductId()).title(res.getType().getTitle()).build();
    }

    private List<FoodaProductTagDto> tagAsDto(final FoodaProductRes res) {
        return Arrays.asList(FoodaProductTagDto.builder().build());
    }

    private FoodaProductPriceDto priceAsDto(final FoodaProductRes res) {
        return FoodaProductPriceDto.builder().title(res.getType().getTitle()).productId(res.getProductId()).build();
    }

    private List<FoodaProductIngredientDto> ingredientsAsDto(final FoodaProductRes res) {
        return Arrays
                .asList(FoodaProductIngredientDto.builder().name(res.getName()).build());
    }

    private List<FoodaProductCategoryDto> categoriesAsDto(final FoodaProductRes res) {
        return Arrays.asList(
                FoodaProductCategoryDto.builder().productCategoryId(res.getProductId()).title(res.getType().getTitle()).build());
    }

    private List<FoodaProductCategoryDto> categories(final FoodaProductReq req) {
        return Arrays.asList(FoodaProductCategoryDto.builder().title(req.getType().getTitle()).build());
    }

    private Optional<FoodaProductPriceDto> price(final FoodaProductReq req) {
        return req.getPrices().stream().filter(FoodaProductPricesItemReq::getIsDefault)
                .map(pReq -> FoodaProductPriceDto.builder().amount(pReq.getAmount()).expiry(pReq.getExpiry())
                        .productPriceId(pReq.getPriceId()).title(pReq.getTitle()).build())
                .findFirst();
    }
}