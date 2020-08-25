package be.fooda.backend.commons.model.template.media.dto;

import lombok.*;
import javax.persistence.*;

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
    private String url;
}
