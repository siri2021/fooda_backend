package be.fooda.backend.commons.model.template.user.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class FoodaUserRes {
    private Long userId;
    private String login;
    @OneToMany
    private Set<FoodaUserRoleRes> roles;
}
