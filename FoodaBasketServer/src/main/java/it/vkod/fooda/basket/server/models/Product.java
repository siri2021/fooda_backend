package it.vkod.fooda.basket.server.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@Document(value = "basket_product")
public class Product implements Serializable {

    @Id
    private UUID basketId;
    private String userId;
    private long storeId;
    private String restUrl;
    private long productId;
    private String name;
    private double price;
    private int quantity;
    private String imageUrl;
}
