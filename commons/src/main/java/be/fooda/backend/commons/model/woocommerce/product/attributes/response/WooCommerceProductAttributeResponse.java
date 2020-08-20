package be.fooda.backend.commons.model.woocommerce.product.attributes.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class WooCommerceProductAttributeResponse {

    @JsonProperty("_links")
    private Links links;

    @JsonProperty("name")
    private String name;

    @JsonProperty("order_by")
    private String orderBy;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("slug")
    private String slug;

    @JsonProperty("has_archives")
    private Boolean hasArchives;
}