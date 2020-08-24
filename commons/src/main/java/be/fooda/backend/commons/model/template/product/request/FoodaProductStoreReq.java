package be.fooda.backend.commons.model.template.product.request;

import lombok.*;
@Data
@Builder
public class FoodaProductStoreReq {
    private Long storeId;
    private String name;
    private String logo;
}