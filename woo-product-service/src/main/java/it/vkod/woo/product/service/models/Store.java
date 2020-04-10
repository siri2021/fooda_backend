package it.vkod.woo.product.service.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Store implements Serializable {

    public Store() {

    }

    public Store(String url, String ip4, int port, String cs, String ck, String name, String description, String created, boolean active) {
        this.url = url;
        this.ip4 = ip4;
        this.port = port;
        this.cs = cs;
        this.ck = ck;
        this.name = name;
        this.description = description;
        this.created = created;
        this.active = active;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return id == store.id &&
                url.equals(store.url) &&
                name.equals(store.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url, name);
    }

    @Override
    public String toString() {
        return "Store{ " +
                "id: " + id +
                ", url: '" + url + '\'' +
                ", ip4: '" + ip4 + '\'' +
                ", name: '" + name + '\'' +
                ", description: '" + description + '\'' +
                ", created: '" + created + '\'' +
                " }";
    }
}
