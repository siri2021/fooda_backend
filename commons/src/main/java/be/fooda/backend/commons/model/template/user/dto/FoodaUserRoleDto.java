package be.fooda.backend.commons.model.template.user.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "USER_ROLE")
public class FoodaUserRoleDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userRoleId;
    private String name;
}

