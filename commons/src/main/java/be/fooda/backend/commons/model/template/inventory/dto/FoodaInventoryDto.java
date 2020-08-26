package be.fooda.backend.commons.model.template.inventory.dto;

import be.fooda.backend.commons.model.template.product.dto.FoodaProductKeyDto;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Entity
@Table(name = "INVENTORY")
public class FoodaInventoryDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long inventoryId;
    @NotNull
    private FoodaProductKeyDto productKey;
    private String sku;
    private String batchCode;
    private Integer stockQuantity;
}