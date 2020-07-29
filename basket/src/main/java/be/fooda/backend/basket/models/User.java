package be.fooda.backend.basket.models;

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
public class User implements Serializable {
    @Id
    private BigInteger userId;
    private String username;
    private String password;
    private Boolean active;
}
