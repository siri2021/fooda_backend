package it.vkod.fooda.product.server.models.product.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@JsonAutoDetect
public class ProductResponseList extends ArrayList<ProductResponse> {

}
