package it.vkod.fooda.basket.server.models;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@Document(value = "basket_order")
public class Order implements Serializable {

    @Id
    private UUID basketId;
    private long orderId;
    private String userId;
    private long storeId;

}
