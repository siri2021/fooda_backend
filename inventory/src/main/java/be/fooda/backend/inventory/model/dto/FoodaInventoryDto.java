package be.fooda.backend.inventory.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FoodaInventoryDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long inventoryId;
    
    private Long productId;
    
    private Long storeId;

    @NotNull
    private String sku;

    private String batchCode;
    
    @Min(value = 1, message = "Stock quantity must be higher than 0")
    private Integer stockQuantity;
}