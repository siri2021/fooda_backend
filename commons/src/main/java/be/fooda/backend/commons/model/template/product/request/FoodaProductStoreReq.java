package be.fooda.backend.commons.model.template.product.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class FoodaProductStoreReq {

    @JsonProperty("store_id")
    private Integer storeId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("logo")
    private String logo;
}