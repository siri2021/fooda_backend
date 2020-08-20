package be.fooda.backend.commons.model.woocommerce.product.reviews.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ReviewerAvatarUrls {

    @JsonProperty("24")
    private String jsonMember24;

    @JsonProperty("48")
    private String jsonMember48;

    @JsonProperty("96")
    private String jsonMember96;
}