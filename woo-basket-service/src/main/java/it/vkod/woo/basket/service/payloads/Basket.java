package it.vkod.woo.basket.service.payloads;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect
public class Basket implements Serializable {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID basketId;

    @Getter
    @Setter
    private UUID userId;

    @Getter
    @Setter
    private long storeId;

    @Getter
    @Setter
    private long productId;

    @Getter
    @Setter
    private int quantity;
}
