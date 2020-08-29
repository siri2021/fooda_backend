package be.fooda.backend.basket.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "CONTACT")
public class FoodaBasketContactDto {
    @Id
    private Long contactId;
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Boolean doNotCall;
}
