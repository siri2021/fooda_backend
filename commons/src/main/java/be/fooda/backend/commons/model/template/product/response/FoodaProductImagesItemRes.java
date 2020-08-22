package be.fooda.backend.commons.model.template.product.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class FoodaProductImagesItemRes {

    @JsonProperty("media_id")
    private Integer mediaId;

    @JsonProperty("type")
    private Type type;

    @JsonProperty("url")
    private String url;

    @JsonProperty("default")
    private String jsonMemberDefault;
}