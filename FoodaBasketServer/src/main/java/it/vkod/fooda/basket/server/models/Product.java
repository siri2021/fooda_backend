package it.vkod.fooda.basket.server.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@NoArgsConstructor
@Document
@JsonAutoDetect
public class Product {
    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID id;
    private UUID userId;
    private String sessionId;
    private Long relatedProductId;
    private String name;
    private String imageUrl;
    private Double price;
    private String description;
    private Double quantity;
}
