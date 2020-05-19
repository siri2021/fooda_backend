package it.vkod.woo.basket.service.payloads;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect
@Builder(toBuilder = true)
@EqualsAndHashCode
@ToString
public class Billing implements Serializable {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    @Getter
    @Setter
    private UUID billingId;

    @Getter
    @Setter
    private String userId;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String phone;

    @Getter
    @Setter
    private String address;

    @Getter
    @Setter
    private String postcode;

    @Getter
    @Setter
    private String municipality;

    @Getter
    @Setter
    private boolean doNotCall;

}
