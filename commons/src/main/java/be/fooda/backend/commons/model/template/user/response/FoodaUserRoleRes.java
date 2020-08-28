package be.fooda.backend.commons.model.template.user.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FoodaUserRoleRes {
    public String title;
    public Boolean hasAccessToFooda;
    public Boolean hasAccessToResta;
    public Boolean hasAccessToDella;
}
