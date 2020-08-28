package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.product.request.*;
import be.fooda.backend.commons.model.template.product.response.FoodaProductRes;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
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
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public FoodaProductRes requestToResponse(final FoodaProductReq foodaProductReq) {
        final FoodaProductRes res = new FoodaProductRes();
        // TODO setters ..
        return res;
    }
}
