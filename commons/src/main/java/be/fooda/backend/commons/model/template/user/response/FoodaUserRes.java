package be.fooda.backend.commons.model.template.user.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.util.Set;

@Data
@NoArgsConstructor
public class FoodaUserRes {
    public Long userId;
    public String login;
    @OneToMany
    public Set<FoodaUserRoleRes> roles;
}
