package be.fooda.backend.commons.model.template.store.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class FoodaStoreImagesItemRes {
    private Long storeImageId;
    private String title;
    private String url;
    private Boolean isDefault;
}