package be.fooda.backend.delivery.model;

import javax.persistence.*;

import lombok.*;

@Data
@Builder(toBuilder = true)
@Entity
public class FoodaDeliveryDto {

    @Id
    @GeneratedValue
    private Long deliveryId;

    private String someData;

}
