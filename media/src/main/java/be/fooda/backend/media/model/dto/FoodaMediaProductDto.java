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
@Table(name = "PRODUCT_MEDIA")
public class FoodaMediaProductDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long mediaProductId;
    private FoodaMediaProductKeyDto productKey;
    @OneToOne
    private FoodaMediaTypeDto type;
    @NotNull
    private String url;
}