package it.vkod.fooda.customer.frontend.models.basket.req;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.UUID;

@Data
public class BasketProduct implements Serializable {

    @EqualsAndHashCode.Exclude
    private UUID id;
    private long storeId;
    private long productId;
    @EqualsAndHashCode.Exclude
    private String name;
    @EqualsAndHashCode.Exclude
    private double price;
    @EqualsAndHashCode.Exclude
    private int quantity;
    @EqualsAndHashCode.Exclude
    private String image;
}
