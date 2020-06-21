package it.vkod.fooda.csv.server.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class Product implements Serializable {

    @CsvBindByName
    @JsonProperty("id")
    @XmlElement
    private Long id;

    @CsvBindByName
    @JsonProperty("storeId")
    @XmlElement
    private Long storeId;

    @CsvBindByName
    @JsonProperty("name")
    @XmlElement
    private String name;

    @CsvBindByName
    @JsonProperty("desc")
    @XmlElement
    private String desc;

    @CsvBindByName
    @JsonProperty("price")
    @XmlElement
    private Double price;

    @CsvBindByName
    @JsonProperty("imgUrl")
    @XmlElement
    private String imgUrl;

    @CsvBindByName
    @JsonProperty("stock")
    @XmlElement
    private int stock;

    public Product() {
    }

    public Product(Long id, Long storeId, String name, String desc, Double price, String imgUrl) {
        this.id = id;
        this.storeId = storeId;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public Product(Long id, Long storeId, String name, String desc, Double price, String imgUrl, int stock) {
        this.id = id;
        this.storeId = storeId;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.imgUrl = imgUrl;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", storeId=" + storeId +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", price=" + price +
                ", imgUrl='" + imgUrl + '\'' +
                ", stock=" + stock +
                '}';
    }

    public static class Data extends ListParam<Product> {

    }
}