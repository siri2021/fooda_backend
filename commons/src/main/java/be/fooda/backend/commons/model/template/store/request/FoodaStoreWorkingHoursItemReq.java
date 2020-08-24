package be.fooda.backend.commons.model.template.store.request;

import lombok.*;

@Data
@Builder
public class FoodaStoreWorkingHoursItemReq {
    private String openTime;
    private String closeTime;
    private String workingDate;
}