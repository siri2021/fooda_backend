package it.vkod.fooda.basket.server.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@Document
@JsonAutoDetect
public class Address implements Serializable {
    @Id
    private BigInteger addressId;
    private BigInteger userId;
    private String line1;
    private String line2;
    private String municipality;
    private String city;
    private String region;
    private String country;
    private String postcode;
}
