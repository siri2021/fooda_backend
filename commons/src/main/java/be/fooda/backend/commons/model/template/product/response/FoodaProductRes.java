package be.fooda.backend.commons.model.template.product.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class FoodaProductRes {

    @JsonProperty("is_featured")
    private Boolean isFeatured;

    @JsonProperty("images")
    private List<ImagesItem> images;

    @JsonProperty("description")
    private String description;

    @JsonProperty("taxes")
    private List<TaxesItem> taxes;

    @JsonProperty("store")
    private Store store;

    @JsonProperty("stock_quantity")
    private Integer stockQuantity;

    @JsonProperty("type")
    private Type type;

    @JsonProperty("tags")
    private List<String> tags;

    @JsonProperty("product_id")
    private Integer productId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("categories")
    private List<String> categories;

    @JsonProperty("order_limit")
    private Integer orderLimit;

    @JsonProperty("prices")
    private List<PricesItem> prices;
}