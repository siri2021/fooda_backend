package it.vkod.fooda.customer.frontend.models.basket.req;

import it.vkod.fooda.customer.frontend.utils.Phone;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@EqualsAndHashCode
public class BasketContact implements Serializable {

    private UUID id;
    private String userId;
    private String firstName;
    private String lastName;
    @Phone
    private String phone;
    @Email
    private String email;
    private Boolean doNotCall;
}
