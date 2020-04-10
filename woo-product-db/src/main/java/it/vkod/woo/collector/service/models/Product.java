package it.vkod.woo.collector.service.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @NotNull(message = "Product name is required.")
    @Basic(optional = false)
    @JsonProperty(value = "name")
    @Column(name = "name")
    private String name;

    @JsonProperty(value = "regular_price")
    @Column(name = "regular_price")
    private Double price;

    @Column(name = "picture_url")
    private String pictureUrl;

    @JsonProperty(value = "store_id")
    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "stock_quantity")
    @JsonProperty(value = "stock_quantity")
    private int stock;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", storeId=" + storeId +
                ", stock=" + stock +
                '}';
    }

    public Product(Long id, @NotNull(message = "Product name is required.") String name, Double price, String pictureUrl, Long storeId, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pictureUrl = pictureUrl;
        this.storeId = storeId;
        this.stock = stock;
    }

    public Product(Long id, @NotNull(message = "Product name is required.") String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(Long id, @NotNull(message = "Product name is required.") String name, Double price, String pictureUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pictureUrl = pictureUrl;
    }

    public Product(Long id, @NotNull(message = "Product name is required.") String name, Double price, String pictureUrl, Long storeId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pictureUrl = pictureUrl;
        this.storeId = storeId;
    }

    public Product() {
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

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}