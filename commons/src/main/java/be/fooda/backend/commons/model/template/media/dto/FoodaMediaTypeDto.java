package be.fooda.backend.commons.model.template.media.dto;

import lombok.*;
import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "MEDIA_TYPE")
public class FoodaMediaTypeDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long typeId;
    private String title;
    private String extension;
}
