package be.fooda.backend.commons.model.template.matching.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "MATCH_RESULT")
public class FoodaMatchDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long matchId;
    private Long relatedId;
    private String keyword;
    private String matched;
    private String category;
    private Double weight;
    private Double score;
}