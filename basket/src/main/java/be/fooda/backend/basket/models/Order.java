package be.fooda.backend.basket.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Document
@JsonAutoDetect
public class Order  implements Serializable {
    @Id
    private BigInteger orderId;
    private BigInteger userId;
    private String sessionId;
    private Long storeId;
    private Long relatedOrderId;
    @JsonFormat(pattern = "DD:MM:YYYY hh:mm")
    private LocalDateTime orderDate;
    @JsonFormat(pattern = "DD:MM:YYYY hh:mm")
    private LocalDateTime deliveryDate;
}
