package be.fooda.backend.commons.model.template.user.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import be.fooda.backend.commons.service.validator.UniqueLogin;
import lombok.*;
import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Entity
@Table(name = "USER")
public class FoodaUserDto extends FoodaAbstractDto {
    @UniqueLogin
    private String login;
    private char[] password;
}
