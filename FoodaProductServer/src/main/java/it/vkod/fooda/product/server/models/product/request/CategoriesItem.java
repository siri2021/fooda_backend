package it.vkod.fooda.product.server.models.product.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class CategoriesItem implements Serializable {
    @JsonProperty("id")
    private int id;
}