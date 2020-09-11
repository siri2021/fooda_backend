package be.fooda.backend.media.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "STORE_MEDIA")
public class FoodaMediaStoreDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long storeMediaId;
    @NotNull
    private Long storeId;
    private FoodaMediaTypeDto type;
    @NotNull
    private String url;
}
