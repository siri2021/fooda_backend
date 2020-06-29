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
public class Contact implements Serializable {
    @Id
    private BigInteger contactId;
    private BigInteger userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Boolean doNotCall;
}
