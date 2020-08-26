package be.fooda.backend.commons.model.template.media.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Entity
@Table(name = "APP_SOURCE")
public class FoodaMediaAppSourceDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long appSourceId;
    private String title;
    @NotNull
    private String url;
    private String resolution;
    private Boolean mustBeCached;
}