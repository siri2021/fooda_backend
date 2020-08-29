package be.fooda.backend.basket.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Document(collection = "ADDRESS")
public class FoodaBasketAddressDto {
    @Id
    private Long addressId;
    private Long userId;
    private String line1;
    private String line2;
    private String municipality;
    private String city;
    private String region;
    private String country;
    private String postcode;
}
