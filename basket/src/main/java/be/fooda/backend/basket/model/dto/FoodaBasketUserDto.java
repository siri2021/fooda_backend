package be.fooda.backend.basket.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "USER")
public class FoodaBasketUserDto {
    @Id
    private Long userId;
    private String login;
    private String password;
}
