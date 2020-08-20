package be.fooda.backend.commons.model.woocommerce.product.attributes.terms.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WooCommerceProductAttributeTermRequest {

    @JsonProperty("name")
    private String name;
}