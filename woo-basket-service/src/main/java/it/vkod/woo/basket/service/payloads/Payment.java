package it.vkod.woo.basket.service.payloads;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect
@Builder(toBuilder = true)
@EqualsAndHashCode
public class Payment {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    @Getter
    @Setter
    private UUID paymentId;

    @Getter
    @Setter
    private long userId;

    @Getter
    @Setter
    private long storeId;

    @Getter
    @Setter
    private String method;

    @Getter
    @Setter
    private String title;

}
