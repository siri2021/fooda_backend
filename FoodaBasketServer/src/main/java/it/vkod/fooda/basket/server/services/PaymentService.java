package it.vkod.fooda.basket.server.services;

import it.vkod.fooda.basket.server.models.Payment;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface PaymentService {
    void add(final Payment order);
    void edit(final Payment order, final UUID id);
    void delete(final UUID id);
    void delete(final Payment order);
    Optional<Payment> get(final UUID id);
    Page<Payment> getAll(final UUID userId);
    Boolean exists(final Payment order);
    Boolean exists(final UUID id);
}
