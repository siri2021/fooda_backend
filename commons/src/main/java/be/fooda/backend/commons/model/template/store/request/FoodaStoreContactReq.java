package be.fooda.backend.commons.model.template.store.request;

import lombok.*;
@Data
@Builder
public class FoodaStoreContactReq {

    private String call;
    private String phoneNumber;
    private String firstName;
    private String familyName;
    private String email;
}