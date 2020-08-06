package be.fooda.backend.commons.model.woocommerce.product.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponse implements Serializable {

    @JsonProperty("id")
    private int id;

    @JsonProperty("store_id")
    private BigInteger storeId;

    @JsonProperty("featured")
    private boolean featured;

    @JsonProperty("type")
    private String type;

    @JsonProperty("price")
    private String price;

    @JsonProperty("sku")
    private String sku;

    @JsonProperty("images")
    private List<ImagesItem> images;

    @JsonProperty("rating_count")
    private int ratingCount;

    @JsonProperty("tags")
    private List<Object> tags;

    @JsonProperty("parent_id")
    private int parentId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("stock_quantity")
    private Object stockQuantity;

    @JsonProperty("sale_price")
    private String salePrice;
}