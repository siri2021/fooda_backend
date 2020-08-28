package be.fooda.backend.commons.model.template.user.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FoodaUserReq {
    public final String login;
    public final String password;
}
