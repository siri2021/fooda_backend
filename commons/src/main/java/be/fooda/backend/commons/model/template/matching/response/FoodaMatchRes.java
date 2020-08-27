package be.fooda.backend.commons.model.template.matching.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@Data
public class FoodaMatchRes {
    private Long customerId;
    private String session;
    private Set<FoodaMatchItemRes> resultSet;
}