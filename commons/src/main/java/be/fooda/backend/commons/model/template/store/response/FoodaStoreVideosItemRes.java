package be.fooda.backend.commons.model.template.store.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
public class FoodaStoreVideosItemRes {
    private String title;
    private String url;
}