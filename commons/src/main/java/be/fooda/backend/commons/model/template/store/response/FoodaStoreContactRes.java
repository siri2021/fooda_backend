package be.fooda.backend.commons.model.template.store.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Builder
public class FoodaStoreContactRes {


    private String call;


    private String phoneNumber;


    private String firstName;


    private String familyName;


    private String email;
}