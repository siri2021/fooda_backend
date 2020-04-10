package it.vkod.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.vkod.models.response.WooProduct;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WooStore implements Serializable {

    private long id;
    private String url;
    private String ip4;
    private int port;
    private String cs;
    private String ck;
    private String name;
    private String description;
    private String created;
    private boolean active;

    private WooProduct[] matchedProducts;

    public WooProduct[] getMatchedProducts() {
        return matchedProducts;
    }

    public void setMatchedProducts(WooProduct[] matchedProducts) {
        this.matchedProducts = matchedProducts;
    }

    public WooStore() {
        this.created = LocalDateTime.now().format(DateTimeFormatter.ofPattern("DD.MM.YYYY hh.mm"));
    }

    public String getCreated() {
        return created;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreated() {
        this.created = LocalDateTime.now().format(DateTimeFormatter.ofPattern("DD.MM.YYYY hh.mm"));
    }

    public String getCs() {
        return cs;
    }

    public void setCs(String cs) {
        this.cs = cs;
    }

    public String getCk() {
        return ck;
    }

    public void setCk(String ck) {
        this.ck = ck;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getIp4() {
        return ip4;
    }

    public void setIp4(String ip4) {
        this.ip4 = ip4;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", ip4='" + ip4 + '\'' +
                ", cs='" + cs + '\'' +
                ", ck='" + ck + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", created='" + created + '\'' +
                ", active=" + active +
                '}';
    }
}
