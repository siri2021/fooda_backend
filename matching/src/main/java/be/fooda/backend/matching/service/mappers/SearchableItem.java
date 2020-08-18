package be.fooda.backend.matching.service.mappers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchableItem{
    private String name; // category name : product.name, product.ingredient, store.name ...
    private String value; // property value "margheritta", "tomatoes, mozzarella .. ", "Manhattan's Burger"
    private Double weight; // default score weight 1.00, 0.75
}