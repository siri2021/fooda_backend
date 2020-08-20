package be.fooda.backend.commons.model.woocommerce.product.tags.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class WooCommerceProductTagRequest {

    @JsonProperty("name")
    private String name;
}