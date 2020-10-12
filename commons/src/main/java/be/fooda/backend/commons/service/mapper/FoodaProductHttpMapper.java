package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.product.request.*;
import be.fooda.backend.commons.model.template.product.response.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FoodaProductHttpMapper implements FoodaHttpMapper<FoodaProductReq, FoodaProductRes> {

    @Override
    public FoodaProductReq responseToRequest(final FoodaProductRes res) {
        return FoodaProductReq.builder()
                .categories(res.getCategories())
                .description(res.getDescription())
                .images(imagesAsReq(res))
                .isFeatured(false)
                .name(res.getName())
                .orderLimit(res.getOrderLimit())
                .prices(pricesAsReq(res))
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

    private List<FoodaProductImagesItemReq> imagesAsReq(final FoodaProductRes res) {
        return res.getImages().stream()
                .map(img ->
                        FoodaProductImagesItemReq.builder()
                                .mediaId(img.getMediaId())
                                .isDefault(img.getIsDefault())
                                .type(type(res))
                                .url(img.getUrl())
                                .build()
                ).collect(Collectors.toList());
    }

    private List<FoodaProductPricesItemReq> pricesAsReq(final FoodaProductRes res) {
        return res.getPrices().stream()
                .map(pri -> FoodaProductPricesItemReq.builder()
                        .amount(pri.getAmount())
                        .currency(pri.getCurrency())
                        .expiry(pri.getExpiry())
                        .isDefault(pri.getIsDefault())
                        .priceId(pri.getPriceId())
                        .title(res.getType().getTitle())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public FoodaProductRes requestToResponse(final FoodaProductReq req) {
        return FoodaProductRes.builder()
                .taxes(taxAsRes(req))
                .type(typeAsRes(req))
                .tags(req.getTags())
                .store(storeAsRes(req))
                .stockQuantity(req.getStockQuantity())
                .productId(req.getProductId())
                .prices(priceAsRes(req))
                .orderLimit(req.getOrderLimit())
                .name(req.getName())
                .isFeatured(req.getIsFeatured())
                .images(imageAsRes(req))
                .description(req.getDescription())
                .categories(req.getCategories())
                .build();
    }

    private FoodaProductTypeRes typeAsRes(FoodaProductReq req) {
        return FoodaProductTypeRes.builder()
                .typeId(req.getType().getTypeId())
                .title(req.getType().getTitle())
                .name(req.getName())
                .build();
    }

    private List<FoodaProductTaxesItemRes> taxAsRes(FoodaProductReq req) {
        return req.getTaxes().stream()
                .map(tax->FoodaProductTaxesItemRes.builder()
                        .taxId(tax.getTaxId())
                        .title(tax.getTitle())
                        .percentage(tax.getPercentage())
                        .isDefault(tax.getIsDefault())
                        .build())
                .collect(Collectors.toList());
    }

    private FoodaProductStoreRes storeAsRes(FoodaProductReq req) {
        return FoodaProductStoreRes.builder()
                .storeId(req.getStore().getStoreId())
                .name(req.getName())
                .logo(req.getStore().getLogo())
                .build();
    }

    private List<FoodaProductPricesItemRes> priceAsRes(FoodaProductReq req) {
        return req.getPrices().stream()
                .map(price->FoodaProductPricesItemRes.builder()
                        .amount(price.getAmount())
                        .currency(price.getCurrency())
                        .expiry(price.getExpiry())
                        .priceId(price.getPriceId())
                        .isDefault(price.getIsDefault())
                        .title(price.getTitle())
                        .build())
                .collect(Collectors.toList());
    }

    private List<FoodaProductImagesItemRes> imageAsRes(FoodaProductReq req) {
        return req.getImages().stream()
                .map(image->FoodaProductImagesItemRes.builder()
                        .isDefault(image.getIsDefault())
                        .mediaId(image.getMediaId())
                        .url(image.getUrl())
                        .type(typeAsRes(req))
                        .build())
                .collect(Collectors.toList());
    }
}