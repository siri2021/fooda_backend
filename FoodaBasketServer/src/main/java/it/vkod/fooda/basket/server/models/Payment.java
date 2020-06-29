package it.vkod.fooda.basket.server.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class Payment implements Serializable {
    @Id
    private BigInteger paymentId;
    private BigInteger userId;
    private String code;
    private String method;
    private Double paidAmount;
}
