package it.vkod.woo.basket.service.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Product {

    @NotNull(message = "Store ID is required.")
    private Long storeId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Product name is required.")
    @Basic(optional = false)
    private String name;

    private Double price;

    private String pictureUrl;

    public Product(Long storeId, Long id, @NotNull(message = "Product name is required.") String name, Double price, String pictureUrl) {
        this.storeId = storeId;
        this.id = id;
        this.name = name;
        this.price = price;
        this.pictureUrl = pictureUrl;
    }

    public Product() {
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
