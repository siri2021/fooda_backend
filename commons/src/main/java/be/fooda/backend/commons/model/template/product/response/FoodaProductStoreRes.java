package be.fooda.backend.commons.model.template.product.response;

import lombok.*;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class FoodaProductStoreRes {
    private Long storeId;
    private String name;
    private String logo;
}