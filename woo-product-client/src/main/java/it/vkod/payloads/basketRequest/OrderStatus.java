package it.vkod.payloads.basketRequest;

import java.io.Serializable;

public enum OrderStatus implements Serializable {
    PENDING,
    PREPARING,
    DELIVERED,
    PAID
}
