package it.vkod.fooda.basket.server.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@NoArgsConstructor
@Document
@JsonAutoDetect
public class Address {
    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID id;
    private UUID userId;
    private String line1;
    private String line2;
    private String municipality;
    private String city;
    private String region;
    private String country;
    private String postcode;
}
