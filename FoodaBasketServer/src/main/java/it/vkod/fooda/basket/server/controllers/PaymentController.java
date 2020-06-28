package it.vkod.fooda.basket.server.controllers;

import it.vkod.fooda.basket.server.models.Payment;
import it.vkod.fooda.basket.server.services.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("basket/payment/")
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentService;

    @GetMapping("{paymentId}")
    public Payment getPayment(@PathVariable final UUID id) {
        return paymentService.get(id).orElse(null);
    }

    @GetMapping("{userId}")
    public Page<Payment> getPaymentsByUser(@PathVariable final UUID userId) {
        return paymentService.getAll(userId);
    }

    @PostMapping
    public void addPayment(@RequestBody final Payment payment) {
        payment.setId(UUID.randomUUID());
        paymentService.add(payment);
    }

    @PutMapping("{paymentId}")
    public void editPayment(@RequestBody final Payment payment, @PathVariable final UUID paymentId) {
        if (paymentService.exists(paymentId))
            paymentService.edit(payment, paymentId);
    }

    @DeleteMapping("{paymentId}")
    public void deletePayment(@PathVariable final UUID paymentId) {
        paymentService.delete(paymentId);
    }

    @DeleteMapping
    public void deletePayment(@RequestBody final Payment payment) {
        paymentService.delete(payment);
    }

}
