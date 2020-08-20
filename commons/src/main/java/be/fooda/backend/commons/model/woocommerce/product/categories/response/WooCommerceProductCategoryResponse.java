package be.fooda.backend.commons.model.woocommerce.product.categories.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class WooCommerceProductCategoryResponse {

    @JsonProperty("parent")
    private Integer parent;

    @JsonProperty("image")
    private Image image;

    @JsonProperty("menu_order")
    private Integer menuOrder;

    @JsonProperty("_links")
    private Links links;

    @JsonProperty("display")
    private String display;

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