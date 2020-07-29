package be.fooda.backend.converter.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
public class Store {

    @CsvBindByName
    @JsonProperty("id")
    @XmlElement
    private Long id;

    @CsvBindByName
    @JsonProperty("name")
    @XmlElement
    private String name;

    @CsvBindByName
    @JsonProperty("url")
    @XmlElement
    private String url;

    @CsvBindByName
    @JsonProperty("key")
    @XmlElement
    private String key;

    @CsvBindByName
    @JsonProperty("secret")
    @XmlElement
    private String secret;

    public Store() {
    }

    public Store(Long id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public Store(Long id, String name, String url, String key, String secret) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.key = key;
        this.secret = secret;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", key='" + key + '\'' +
                ", secret='" + secret + '\'' +
                '}';
    }

    public static class Data extends ListParam<Store> {

    }
}
