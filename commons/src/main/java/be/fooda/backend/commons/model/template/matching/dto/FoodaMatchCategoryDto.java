package be.fooda.backend.commons.model.template.matching.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "MATCH_CATEGORY")
public class FoodaMatchCategoryDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long matchCategoryId;
    private String title;
    private FoodaMatchCategoryDto parent;
    private Double weight;
}
