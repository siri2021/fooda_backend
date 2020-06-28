package it.vkod.fooda.basket.server.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@Document
@JsonAutoDetect
public class Order {
    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID id;
    private UUID userId;
    private String sessionId;
    private Long storeId;
    private Long relatedOrderId;
    @JsonFormat(pattern = "DD:MM:YYYY hh:mm")
    private LocalDateTime orderDate;
    @JsonFormat(pattern = "DD:MM:YYYY hh:mm")
    private LocalDateTime deliveryDate;
}
