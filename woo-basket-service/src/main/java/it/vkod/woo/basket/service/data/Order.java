package it.vkod.woo.basket.service.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonAutoDetect
public class Order implements Serializable {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    @Getter
    @Setter
    private UUID basketId;

    @Getter
    @Setter
    private long orderId;

    @Getter
    @Setter
    private String userId;

    @Getter
    @Setter
    private long storeId;

}
