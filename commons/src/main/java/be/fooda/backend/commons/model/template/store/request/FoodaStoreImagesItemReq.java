package be.fooda.backend.commons.model.template.store.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class FoodaStoreImagesItemReq {

    @JsonProperty("title")
    private String title;

    @JsonProperty("url")
    private String url;
}