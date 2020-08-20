package be.fooda.backend.commons.model.woocommerce.product.attributes.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WooCommerceProductAttributeRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("order_by")
    private String orderBy;

    @JsonProperty("type")
    private String type;

    @JsonProperty("slug")
    private String slug;

    @JsonProperty("has_archives")
    private Boolean hasArchives;
}