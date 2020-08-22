package be.fooda.backend.commons.model.template.product.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class FoodaProductTaxesItemReq {

    @JsonProperty("percentage")
    private Double percentage;

    @JsonProperty("title")
    private String title;

    @JsonProperty("tax_id")
    private Integer taxId;

    @JsonProperty("is_default")
    private Boolean isDefault;
}