package be.fooda.backend.commons.model.woocommerce.product.tags.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class WooCommerceProductTagResponse {

    @JsonProperty("_links")
    private Links links;

    @JsonProperty("name")
    private String name;

    @JsonProperty("count")
    private Integer count;

    @JsonProperty("description")
    private String description;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("slug")
    private String slug;
}