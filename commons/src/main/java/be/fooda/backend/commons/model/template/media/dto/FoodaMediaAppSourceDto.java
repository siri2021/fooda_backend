package be.fooda.backend.commons.model.template.media.dto;

import lombok.*;
import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "APP_SOURCE")
public class FoodaMediaAppSourceDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long appSourceId;
    private String title;
    private String url;
    private String resolution;
    private Boolean mustBeCached;
}