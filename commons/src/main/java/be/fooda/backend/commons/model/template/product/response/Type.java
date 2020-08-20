package be.fooda.backend.commons.model.template.product.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Type {

    @JsonProperty("type_id")
    private Integer typeId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("extension")
    private String extension;

    @JsonProperty("title")
    private String title;
}