package it.vkod.woo.product.service.payloads.productRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WooProductRequest {

    @JsonProperty("store_id")
    private long storeId;

    @JsonProperty("id")
    private int id;

    @JsonProperty("regular_price")
    private double regularPrice;

    @JsonProperty("short_description")
    private String shortDescription;

    @JsonProperty("images")
    private List<ImagesItem> images;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("categories")
    private List<CategoriesItem> categories;

    @JsonProperty("type")
    private String type;

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRegularPrice(double regularPrice) {
        this.regularPrice = regularPrice;
    }

    public double getRegularPrice() {
        return regularPrice;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setImages(List<ImagesItem> images) {
        this.images = images;
    }

    public List<ImagesItem> getImages() {
        return images;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setCategories(List<CategoriesItem> categories) {
        this.categories = categories;
    }

    public List<CategoriesItem> getCategories() {
        return categories;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return
                "WooProductRequest{" +
                        "store_id = '" + storeId + '\'' +
                        "product_id = '" + id + '\'' +
                        "regular_price = '" + regularPrice + '\'' +
                        ",short_description = '" + shortDescription + '\'' +
                        ",images = '" + images + '\'' +
                        ",name = '" + name + '\'' +
                        ",description = '" + description + '\'' +
                        ",categories = '" + categories + '\'' +
                        ",type = '" + type + '\'' +
                        "}";
    }
}