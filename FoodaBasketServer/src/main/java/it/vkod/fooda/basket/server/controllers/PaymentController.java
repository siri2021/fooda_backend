package it.vkod.fooda.basket.server.controllers;

import it.vkod.fooda.basket.server.models.Payment;
import it.vkod.fooda.basket.server.services.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;


@RestController
@RequestMapping("basket/payment/")
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentService;

    @GetMapping("{paymentId}")
    public Payment getPayment(@PathVariable final BigInteger paymentId) {
        return paymentService.get(paymentId).orElse(null);
    }

    @GetMapping("{userId}/page/{page}")
    public Page<Payment> getPaymentsByUser(@PathVariable final BigInteger userId, @PathVariable final int page) {
        return paymentService.get(userId, PageRequest.of(page, 10));
    }

    @PostMapping
    public void addPayment(@RequestBody final Payment payment) {
        paymentService.add(payment);
    }

    @PutMapping("{paymentId}")
    public void editPayment(@RequestBody final Payment payment, @PathVariable final BigInteger paymentId) {
        if (paymentService.exists(paymentId).equals(true))
            paymentService.edit(payment, paymentId);
    }

    @DeleteMapping("{paymentId}")
    public void deletePayment(@PathVariable final BigInteger paymentId) {
        paymentService.delete(paymentId);
    }

    @DeleteMapping
    public void deletePayment(@RequestBody final Payment payment) {
        paymentService.delete(payment);
    }

}
