package be.fooda.backend.store.service;

import java.math.BigDecimal;
import java.util.List;

public interface FoodaStorePaymentMethodService<REQ,RES>{
    List<RES> getStoreByPaymentMethodId(final Long paymentMethodId, final BigDecimal minOrderAmount);

    List<RES> getStoreByPaymentMethodId(final Long paymentMethodId);
}
