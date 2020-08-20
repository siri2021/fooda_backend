package be.fooda.backend.matching.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class MatchResponse implements Serializable {

    private static final long serialVersionUID = 5598635647488388495L;

    @JsonProperty("match_result_id")
    private Long matchResultId;

    @JsonProperty("keyword")
    private String keyword;

    @JsonProperty("score")
    private Double score;

    private MatchCategoryResponse category;
}