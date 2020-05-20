package it.vkod.woo.basket.service.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonAutoDetect
public class Basket implements Serializable {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    @Getter
    @Setter
    private UUID basketId;

    @Getter
    @Setter
    private String userId;

    @Getter
    @Setter
    private long storeId;

    @Getter
    @Setter
    private String restUrl;

    @Getter
    @Setter
    private long productId;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private double price;

    @Getter
    @Setter
    private int quantity;

    @Getter
    @Setter
    private String imageUrl;
}
