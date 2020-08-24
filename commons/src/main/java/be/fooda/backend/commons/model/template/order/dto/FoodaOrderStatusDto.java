package be.fooda.backend.commons.model.template.order.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@Entity
@Table(name = "ORDER_STATUS")
public class FoodaOrderStatusDto {
    @Id
    private Long statusId;
    private String title;
    private FoodaOrderStatusDto parent;
}