package be.fooda.backend.commons.model.woocommerce.product.shipping_classes.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WooCommerceProductShippingClassRequest {

    @JsonProperty("name")
    private String name;
}