package it.vkod.woo.product.client.payloads.basketRequest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BasketProduct implements Serializable {

    @JsonProperty
    private Long storeId;

    @JsonProperty
    private Long id;

    @JsonProperty
    private String name;

    @JsonProperty
    private Double price;

    @JsonProperty
    private String pictureUrl;

    public BasketProduct(Long storeId, Long id, String name, Double price, String pictureUrl) {
        this.storeId = storeId;
        this.id = id;
        this.name = name;
        this.price = price;
        this.pictureUrl = pictureUrl;
    }

    public BasketProduct() {
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Override
    public String toString() {
        return "Product{" +
                "storeId=" + storeId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}';
    }
}
