package it.vkod.woo.collector.service.services;

import it.vkod.woo.collector.service.models.OrderProduct;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface OrderProductService {

    OrderProduct create(@NotNull(message = "The products for order cannot be null.") @Valid OrderProduct orderProduct);
}