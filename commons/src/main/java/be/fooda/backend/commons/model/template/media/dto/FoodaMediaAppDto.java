package be.fooda.backend.commons.model.template.media.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Entity
@Table(name = "APP_SOURCE_MEDIA")
public class FoodaMediaAppDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long storeMediaId;
    private Long appSourceId;
    private FoodaMediaTypeDto type;
    @NotNull
    private String url;
}
