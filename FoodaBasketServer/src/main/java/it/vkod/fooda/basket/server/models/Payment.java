package it.vkod.fooda.basket.server.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@Document(value = "basket_payment")
public class Payment implements Serializable {

    @Id
    private UUID paymentId;
    private String userId;
    private long storeId;
    private String method;
    private String title;

}
