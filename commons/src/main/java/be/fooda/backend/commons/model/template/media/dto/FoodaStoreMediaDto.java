package be.fooda.backend.commons.model.template.media.dto;

import lombok.*;
import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "STORE_MEDIA")
public class FoodaStoreMediaDto {

    @Id
    @GeneratedValue(strategy = GeneratedValue.AUTO)
    private Long mediaId;
    private Long storeId;
    private FoodaMediaTypeDto type;
    private String url;
}
