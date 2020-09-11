package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.basket.request.FoodaBasketDeliveryReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketAddressRes;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketDeliveryRes;

public class FoodaBasketDeliveryHttpMapper implements FoodaHttpMapper<FoodaBasketDeliveryReq, FoodaBasketDeliveryRes> {
    @Override
    public FoodaBasketDeliveryReq responseToRequest(FoodaBasketDeliveryRes res) {
        return FoodaBasketDeliveryReq.builder()
                .billingAddressId(res.getBillingAddress().getAddressId())
                .billingContactId(res.getBillingContact().getContactId())
                .deliveryAddressId(res.getDeliveryAddress().getAddressId())
                .deliveryContactId(res.getDeliveryContact().getContactId())
                .session(res.getSession())
                .storeId(res.getStore().getStoreId())
                .userId(res.getUser().getUserId())
                .build();
    }

    @Override
    public FoodaBasketDeliveryRes requestToResponse(FoodaBasketDeliveryReq req) {
        return FoodaBasketDeliveryRes.builder()
                .billingAddress(billingAddress(req))
                .build();
    }

    private FoodaBasketAddressRes billingAddress(FoodaBasketDeliveryReq req) {
        return FoodaBasketAddressRes.builder()
                .addressId(req.getBillingAddressId())
                .build();
    }
}
