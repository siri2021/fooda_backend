package be.fooda.backend.commons.model.template.media.dto;

import lombok.*;
import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "STORE_MEDIA")
public class FoodaMediaStoreDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long storeMediaId;
    private Long storeId;
    private FoodaMediaTypeDto type;
    private String url;
}
