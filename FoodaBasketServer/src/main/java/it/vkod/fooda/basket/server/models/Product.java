package it.vkod.fooda.basket.server.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@Document
@JsonAutoDetect
public class Product implements Serializable {
    @Id
    private BigInteger productId;
    private BigInteger userId;
    private String sessionId;
    private String name;
    private String imageUrl;
    private Double price;
    private String description;
    private Double quantity;

    public void increase() {
        setQuantity(getQuantity() + 1);
    }

    public void decrease() {
        setQuantity(getQuantity() - 1);
    }

    public void increase(final Double quantity) {
        setQuantity(getQuantity() + quantity);
    }

    public void decrease(final Double quantity) {
        setQuantity(getQuantity() - quantity);
    }
}
