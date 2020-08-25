package be.fooda.backend.commons.model.template.media.response;

import lombok.NoArgsConstructor;

import lombok.*;

@NoArgsConstructor
@Data
public class FoodaMediaStoreInfoRes {
    private Long storeId;
    private String name;
}
