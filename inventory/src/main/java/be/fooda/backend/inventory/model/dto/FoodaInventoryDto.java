package be.fooda.backend.inventory.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "INVENTORY")
public class FoodaInventoryDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long inventoryId;
    @NotNull
    private FoodaInventoryProductKeyDto productKey;
    @NotNull
    private String sku;
    private String batchCode;
    @Min(value = 1, message = "Stock quantity must be higher than 0")
    private Integer stockQuantity;
}