package be.fooda.backend.matching.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class MatchCategoryResponse implements Serializable {

    private static final long serialVersionUID = 5721950168234542337L;

    @EqualsAndHashCode.Exclude
    @JsonProperty("category_id")
    private Integer categoryId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("weight")
    private Double weight;
}
