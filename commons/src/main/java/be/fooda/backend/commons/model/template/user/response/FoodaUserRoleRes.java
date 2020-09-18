package be.fooda.backend.commons.model.template.user.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class FoodaUserRoleRes {
    private String title;
    private Boolean hasAccessToFooda;
    private Boolean hasAccessToResta;
    private Boolean hasAccessToDella;
}
