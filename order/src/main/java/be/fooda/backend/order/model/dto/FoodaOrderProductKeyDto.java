package be.fooda.backend.order.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ORDER_PRODUCT_KEY")
public class FoodaOrderProductKeyDto {
    private Long productId;
    private Long storeId;
}
