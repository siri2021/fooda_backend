package be.fooda.backend.commons.model.template.store.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FoodaStoreImagesItemRes {
    private String title;
    private String url;
    private Boolean isDefault;
}