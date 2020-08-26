package be.fooda.backend.commons.model.template.media.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Entity
@Table(name = "MEDIA_TYPE")
public class FoodaMediaTypeDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long typeId;
    @NotNull
    private String title;
    private String extension;
}
