package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.product.dto.FoodaProductCategoryDto;
import be.fooda.backend.commons.model.template.product.dto.FoodaProductDto;
import be.fooda.backend.commons.model.template.product.dto.FoodaProductKeyDto;
import be.fooda.backend.commons.model.template.product.dto.FoodaProductPriceDto;
import be.fooda.backend.commons.model.template.product.dto.FoodaProductTagDto;
import be.fooda.backend.commons.model.template.product.request.FoodaProductImagesItemReq;
import be.fooda.backend.commons.model.template.product.request.FoodaProductPricesItemReq;
import be.fooda.backend.commons.model.template.product.request.FoodaProductReq;
import be.fooda.backend.commons.model.template.product.request.FoodaProductStoreReq;
import be.fooda.backend.commons.model.template.product.request.FoodaProductTaxesItemReq;
import be.fooda.backend.commons.model.template.product.request.FoodaProductTypeReq;
import be.fooda.backend.commons.model.template.product.response.FoodaProductRes;

import lombok.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class FoodaProductMapper implements FoodaObjectMapper<FoodaProductDto, FoodaProductReq, FoodaProductRes> {

    @Override
    public FoodaProductReq dtoToRequest(final FoodaProductDto dto) {
        return FoodaProductReq.builder()
        .categories(categories(dto))
        .description(dto.getDescription())
        .images(images(dto))
        .isFeatured(false)
        .name(dto.getName())
        .orderLimit(dto.getLimit())
        .prices(prices(dto))
        .productId(dto.getKey().getProductId())
        .store(productStore(dto))
        .tags(tags(dto))
        .taxes(taxes(dto))
        .type(productType(dto))
        .build();
    }

    private List<String> categories(final FoodaProductDto dto){
        return dto.getCategories().stream()
        .map(FoodaProductCategoryDto::getTitle)
        .collect(Collectors.toList());
    }

    private List<FoodaProductImagesItemReq> images(final FoodaProductDto dto){
        return Arrays.asList(FoodaProductImagesItemReq.builder().mediaId(dto.getImageId()).build());
    }

    private List<FoodaProductPricesItemReq> prices(final FoodaProductDto dto){
        return Arrays.asList(FoodaProductPricesItemReq.builder().priceId(dto.getPrice().getPriceId()).amount(dto.getPrice().getAmount()).build());
    }

    private List<String> tags(final FoodaProductDto dto){
        return dto.getTags().stream()
        .map(FoodaProductTagDto::getValue)
        .collect(Collectors.toList());
    }

    private List<FoodaProductTaxesItemReq> taxes(final FoodaProductDto dto){
        return Arrays.asList(FoodaProductTaxesItemReq.builder().taxId(dto.getTax().getTaxId()).title(dto.getTax().getTitle()).build());
    }

    private FoodaProductTypeReq productType(final FoodaProductDto dto){
        return FoodaProductTypeReq.builder()
        .typeId(dto.getType().getTypeId())
        .title(dto.getType().getTitle())
        .build();
    }

    private FoodaProductStoreReq productStore(final FoodaProductDto dto){
        return FoodaProductStoreReq.builder()
        .storeId(dto.getKey().getStoreId())
        .name(dto.getName())
        .storeId(dto.getKey().getStoreId())
        .build();
    }

    @Override
    public FoodaProductReq responseToRequest(final FoodaProductRes res) {
        return FoodaProductReq.builder()
        .categories(res.getCategories())
        .description(res.getDescription())
        .images(images(res))
        .isFeatured(false)
        .name(res.getName())
        .orderLimit(res.getOrderLimit())
        .prices(prices(res))
        .productId(res.getProductId())
        .store(store(res))
        .tags(res.getTags())
        .taxes(taxes(res))
        .type(type(res))
        .build();
    }

    private FoodaProductTypeReq type(final FoodaProductRes res){
        return FoodaProductTypeReq.builder()
        .title(res.getType().getTitle())
        .typeId(res.getType().getTypeId())
        .build();
    }

    private List<FoodaProductTaxesItemReq> taxes(final FoodaProductRes res){
        return res.getTaxes().stream()
        .map(tax -> FoodaProductTaxesItemReq.builder()
        .taxId(tax.getTaxId())
        .isDefault(tax.getIsDefault())
        .percentage(tax.getPercentage())
        .title(tax.getTitle())
        .build())
        .collect(Collectors.toList());
    }

    private FoodaProductStoreReq store(final FoodaProductRes res){
        return FoodaProductStoreReq.builder()
        .name(res.getStore().getName())
        .logo(res.getStore().getLogo())
        .storeId(res.getStore().getStoreId())
        .build();
    }

    private List<FoodaProductImagesItemReq> images(final FoodaProductRes res){
        return res.getImages().stream()
        .map(img -> 
            FoodaProductImagesItemReq.builder()
            .mediaId(img.getMediaId())
            .isDefault(img.getIsDefault())
            .type(type(res))
            .url(img.getUrl())
            .build()
        )
        .collect(Collectors.toList());
    }

    private List<FoodaProductPricesItemReq> prices(final FoodaProductRes res){
        return res.getPrices().stream()
        .map(pri -> FoodaProductPricesItemReq.builder()
            .amount(pri.getAmount())
            .currency(pri.getCurrency())
            .expiry(pri.getExpiry())
            .isDefault(pri.getIsDefault())
            .priceId(pri.getPriceId())
            .build())
        .collect(Collectors.toList());
    }

    @Override
    public FoodaProductRes dtoToResponse(final FoodaProductDto foodaProductDto) {
        final FoodaProductRes res = new FoodaProductRes();

        return res;
    }

    @Override
    public FoodaProductRes requestToResponse(final FoodaProductReq foodaProductReq) {
        final FoodaProductRes res = new FoodaProductRes();
        // TODO setters ..
        return res;
    }

    @Override
    public FoodaProductDto requestToDto(final FoodaProductReq foodaProductReq) {
        return FoodaProductDto.builder()
                .categories(categories(foodaProductReq))
                .description(foodaProductReq.getDescription())
                .isFeatured(false).key(productKey(foodaProductReq))
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
                    .expiry(LocalDate.parse(pReq.getExpiry()))
                    .priceId(pReq.getPriceId())
                    .productKey(FoodaProductKeyDto.builder().productId(req.getProductId()).build())
                    .title(pReq.getTitle()).build())
                .findFirst();
    }
}
